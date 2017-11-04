package org.processmining.configurableprocesstree.cptimpl.graphmodels;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.*;
import org.processmining.configurableprocesstree.cptimpl.operators.And;
import org.processmining.configurableprocesstree.cptimpl.operators.Or;
import org.processmining.configurableprocesstree.cptimpl.operators.Xor;
import org.processmining.configurableprocesstree.parser.CPTParser;
import org.processmining.configurableprocesstree.parser.nodefactory.*;
import org.processmining.configurableprocesstree.parser.predicate.*;

import javax.swing.*;
import java.util.HashMap;

public class HelloWorldGraph extends JFrame {

    public HelloWorldGraph() throws Exception {
        super("Hello Graph!");
        mxGraph graph = new mxGraph(){
            public boolean isCellSelectable(Object cell) {
                if (model.isEdge(cell)) {
                    return false;
                }
                return super.isCellSelectable(cell);
            }
        };
        Object parent = graph.getDefaultParent();
//        ICPTNode root = new And();
//        ICPTNode n2 = new And();
//        ICPTNode n3 = new Or();
//        ICPTNode n4 = new Or();
//        ICPTNode n5 = new Xor();
//        ICPTNode task = new Task("Task 1");
//
//        root.addChild(n2);
//        root.addChild(n3);
//        n2.addChild(n4);
//        n3.addChild(n5);
//        n3.addChild(task);

        // big tree
//        ICPTNode bigTree = buildBigBinaryTree(8);

        graph.getModel().beginUpdate();
//        String treeStrRep = "<OR{<AND[B,-]{}><SEQ[-,TAU]{124{}}>}>";
//        String treeStrRep ="<SEQ[]{<630[]{}><XOR[]{<AND[B,-,H,H,H]{}><730[]{}>}>}>";
        String treeStrRep = "<OR[]{<765[B,-,B,-,-]{}><OR[AND,-,-,-,-]{<770[]{}><OR[XOR,-,XOR,-,-]{<540[]{}><SEQ[]{<630[]{}><XOR[]{<AND[B,-,H,H,H]{}><730[]{}>}>}>}>}>}>";

        // build parser rules
        HashMap<Predicate, NodeFactory> rules = new HashMap<>();
        rules.put(new XorPredicate(), new XorFactory());
        rules.put(new OrPredicate(), new OrFactory());
        rules.put(new SeqPredicate(), new SeqFactory());
        rules.put(new AndPredicate(), new AndFactory());
        rules.put(new TaskPredicate(), new TaskFactory());

        CPTParser parser = new CPTParser(rules);
        ICPTNode tree = parser.parseString(treeStrRep);
        try {
            tree.addToGraphModel(graph, parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());


        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setToolTips(true);
        graphComponent.setConnectable(false);

        graph.setCellsEditable(false);
        graph.setCellsSelectable(false);
        graph.setCellsLocked(true);

        getContentPane().add(graphComponent);
    }

    private ICPTNode buildBigBinaryTree(int levels) {
        ICPTNode root = new And();

        return addManyNodes(levels, root);
    }

    private ICPTNode addManyNodes(int levels, ICPTNode node) {
        if (levels <= 1) return node;
        else {
            ICPTNode leftChild = new And();
            ICPTNode rightChild = new And();
            node.addChild(leftChild);
            node.addChild(rightChild);
            addManyNodes(levels - 1, leftChild);
            addManyNodes(levels - 1, rightChild);
            return node;
        }
    }

    public static void main(String[] args) throws Exception {
        HelloWorldGraph frame = new HelloWorldGraph();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
