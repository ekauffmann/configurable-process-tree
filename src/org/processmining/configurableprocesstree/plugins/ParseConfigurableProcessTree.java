package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.configurableprocesstree.cptimpl.operators.And;
import org.processmining.configurableprocesstree.exceptions.IncorrectCPTStringFormat;
import org.processmining.configurableprocesstree.exceptions.RuleNotFoundException;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class ParseConfigurableProcessTree {
    @Plugin(
            name = "Configurable Process Tree parser",
            parameterLabels = { },
            returnLabels = { "Configurable Process Tree" },
            returnTypes = { ConfigurableProcessTree.class },
            userAccessible = true,
            help = "Visualizes a text representation of a configurable process tree"
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa",
            email = "ekauffma@dcc.uchile.cl"
    )
    public ConfigurableProcessTree parseTXTFile(PluginContext context) throws RuleNotFoundException, IncorrectCPTStringFormat {
//        String treeStrRep = "<OR{<AND[B,-]{}><SEQ[-,TAU]{124{}}>}>";
//        String treeStrRep ="<SEQ[]{<630[]{}><XOR[]{<AND[B,-,H,H,H]{}><730[]{}>}>}>";
//        String treeStrRep = "<OR[]{<765[B,-,B,-,-]{}><OR[AND,-,-,-,-]{<770[]{}><OR[XOR,-,XOR,-,-]{<540[]{}><SEQ[]{<630[]{}><XOR[]{<AND[B,-,H,H,H]{}><730[]{}>}>}>}>}>}>";
//
//        HashMap<Predicate, NodeFactory> rules = buildRules();
//        CPTParser parser = new CPTParser(rules);
//        ICPTNode rootNode = parser.parseString(treeStrRep);
//
//        return new ConfigurableProcessTree(rootNode);
        return new ConfigurableProcessTree(new And());
    }


}
