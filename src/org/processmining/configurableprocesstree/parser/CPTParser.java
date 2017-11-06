package org.processmining.configurableprocesstree.parser;

import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.exceptions.EmptyFileException;
import org.processmining.configurableprocesstree.exceptions.IncorrectCPTStringFormat;
import org.processmining.configurableprocesstree.exceptions.MoreThanOneLineFileException;
import org.processmining.configurableprocesstree.exceptions.RuleNotFoundException;
import org.processmining.configurableprocesstree.parser.nodefactories.NodeFactory;
import org.processmining.configurableprocesstree.parser.predicates.Predicate;

import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPTParser {
    private HashMap<Predicate, NodeFactory> rules;
    private Stack<String> namesStack;
    private Stack<Integer> childrenCounterStack;
    private Stack<ICPTNode> nodesStack;
    private Pattern nodeDataPattern;
    private char nodeStart = "(".charAt(0);
    private char nodeEnd = ")".charAt(0);
    private char childrenStart = "{".charAt(0);
    private char childrenEnd = "}".charAt(0);

    public CPTParser(HashMap<Predicate, NodeFactory> rules) {
        this.rules = rules;
        this.namesStack = new Stack<>();
        this.childrenCounterStack = new Stack<>();
        this.nodesStack = new Stack<>();
        this.nodeDataPattern = Pattern.compile("([A-Z0-9]+)(?>\\[(.*)\\])");

    }

    public ConfigurableProcessTree parseTreeFromFile(InputStream inputStream, String filename) throws EmptyFileException, IOException, MoreThanOneLineFileException, RuleNotFoundException, IncorrectCPTStringFormat {
        String line = readFile(inputStream, filename);
        ICPTNode root = parseString(line);
        return new ConfigurableProcessTree(root);
    }

    private String readFile(InputStream inputStream, String filename) throws IOException, EmptyFileException, MoreThanOneLineFileException {
        ArrayList<String> lines = new ArrayList<>();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }


        if (lines.isEmpty()) {
            throw new EmptyFileException(filename);
        } else if (lines.size() > 1) {
            throw new MoreThanOneLineFileException(filename);
        }

        return lines.get(0);
    }

    private ICPTNode parseString(String str) throws IncorrectCPTStringFormat, RuleNotFoundException {
        childrenCounterStack.push(0);
        StringBuilder nodeData = new StringBuilder();


        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);

            // new node is introduced. Add as a child to the parent counter for children and get node name
            if (nodeStart == c) {
                int lastCounter = childrenCounterStack.pop();
                childrenCounterStack.push(lastCounter+1);

                // get name and label, push to stack and reset variable
                while (str.charAt(index+1) != childrenStart) {
                    index++;
                    nodeData.append(str.charAt(index));
                }
                namesStack.push(nodeData.toString());
                nodeData = new StringBuilder();
            }

            // put a new children counter to the stack
            else if (childrenStart == c) {
                childrenCounterStack.push(0);
            }

            // pop necessary data from stacks, build node, and push it to node stack
            else if (nodeEnd == c) {
                int numberOfChildren;
                String data;
                try {
                    numberOfChildren = childrenCounterStack.pop();
                    data = namesStack.pop();
                } catch (EmptyStackException e) {
                    throw new IncorrectCPTStringFormat();
                }

                ArrayList<ICPTNode> children = new ArrayList<>();
                for (int i = 0; i < numberOfChildren; i++) {
                    try {
                        // add to first position of array
                        children.add(0, nodesStack.pop());
                    } catch (EmptyStackException e) {
                        throw new IncorrectCPTStringFormat();
                    }
                }
                nodesStack.push(parseNode(data, children));
            }
        }
        // check if parsing process went ok, i.e. stacks are empty and nodesStack contains tree root
        if (namesStack.isEmpty() && childrenCounterStack.size() == 1 && nodesStack.size() == 1) {
            return nodesStack.pop();
        } else {
            throw new IncorrectCPTStringFormat();
        }
    }

    private ICPTNode parseNode(String data, ArrayList<ICPTNode> children) throws IncorrectCPTStringFormat, RuleNotFoundException {
        ICPTNode node = null;
        Matcher matcher = this.nodeDataPattern.matcher(data);
        if (!matcher.matches()) throw new IncorrectCPTStringFormat();

        String name = matcher.group(1);
        String label = matcher.group(2);

        for (Predicate predicate : rules.keySet()) {
            if (predicate.checkPredicate(name)) {
                node = rules.get(predicate).buildNode(name, label, children);
                break;
            }
        }

        if (node == null) throw new RuleNotFoundException(name);

        return node;
    }
}
