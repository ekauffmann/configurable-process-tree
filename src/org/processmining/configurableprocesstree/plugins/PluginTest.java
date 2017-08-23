package org.processmining.configurableprocesstree.plugins;

import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.processtree.Block;
import org.processmining.processtree.Edge;
import org.processmining.processtree.ProcessTree;
import org.processmining.processtree.Task;
import org.processmining.processtree.editor.EditorObjectBeginner;
import org.processmining.processtree.impl.AbstractBlock;
import org.processmining.processtree.impl.AbstractTask;
import org.processmining.processtree.impl.ProcessTreeImpl;

public class PluginTest {
    @Plugin(
            name = "Process Tree Test",
            parameterLabels = { },
            returnLabels = { "Process Tree Editor" },
            returnTypes = { EditorObjectBeginner.class },
            userAccessible = true,
            help = "Start up editor"
    )
    @UITopiaVariant(
            affiliation = UITopiaVariant.EHV,
            author = "Elisa",
            email = "ekauffma@dcc.uchile.cl"
    )
    public EditorObjectBeginner generateTestTree(PluginContext context) {
        // Process tree
        ProcessTree tree = new ProcessTreeImpl("Test Process Tree");

        // Root: Sequence operator
        Block.Seq seq = new AbstractBlock.Seq("seq");
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
        Block.And and = new AbstractBlock.And("and");
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

        return new EditorObjectBeginner(tree);
    }
}
