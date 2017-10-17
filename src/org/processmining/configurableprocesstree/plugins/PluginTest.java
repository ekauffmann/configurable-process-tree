package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.impl.AbstractConfigurableBlock;
import org.processmining.configurableprocesstree.impl.CPTImpl;
import org.processmining.configurableprocesstree.visualizer.CPTVisualizerObject;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.processtree.Block;
import org.processmining.processtree.Edge;
import org.processmining.processtree.Task;
import org.processmining.processtree.impl.AbstractTask;

public class PluginTest {
    @Plugin(
            name = "Configurable Process Tree Visualizer",
            parameterLabels = { },
            returnLabels = { "Configurable Process Tree" },
            returnTypes = { CPTVisualizerObject.class },
            userAccessible = true,
            help = "Start up visualizer"
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa",
            email = "ekauffma@dcc.uchile.cl"
    )
    public CPTVisualizerObject generateTestTree(PluginContext context) {
        // Process tree
        CPTImpl tree = new CPTImpl();

        // Root: Sequence operator
        Block.Seq seq = new AbstractConfigurableBlock.Seq("seq");
        seq.setProcessTree(tree);
        tree.addNode(seq);
        tree.setRoot(seq);

        // Activity A
        Task.Manual manA = new AbstractTask.Manual("A");
        manA.setProcessTree(tree);
        tree.addNode(manA);

        // Edge to A
        Edge edgeA = seq.addChild(manA);
        manA.addIncomingEdge(edgeA);
        tree.addEdge(edgeA);

        // And operator
        Block.And and = new AbstractConfigurableBlock.And("and");
        and.setProcessTree(tree);
        tree.addNode(and);

        // Edge to and
        Edge edgeAnd = seq.addChild(and);
        and.addIncomingEdge(edgeAnd);
        tree.addEdge(edgeAnd);

        // Activity B
        Task.Manual manB = new AbstractTask.Manual("B");
        manB.setProcessTree(tree);
        tree.addNode(manB);

        // Edge to B
        Edge edgeB = seq.addChild(manB);
        manB.addIncomingEdge(edgeB);
        tree.addEdge(edgeB);

        // and first child: activity C
        Task.Manual manC = new AbstractTask.Manual("C");
        manC.setProcessTree(tree);
        tree.addNode(manC);

        // add edge from and to activity C
        Edge edgeC = and.addChild(manC);
        manB.addIncomingEdge(edgeC);
        tree.addEdge(edgeC);

        // and second child: activity D
        Task.Manual manD = new AbstractTask.Manual("D");
        manD.setProcessTree(tree);
        tree.addNode(manD);

        // add edge from and to activity C
        Edge edgeD = and.addChild(manD);
        manC.addIncomingEdge(edgeD);
        tree.addEdge(edgeD);

        return new CPTVisualizerObject(tree);
    }
}
