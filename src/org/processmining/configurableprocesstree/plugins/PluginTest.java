package org.processmining.configurableprocesstree.plugins;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.models.MyNode;
import org.processmining.configurableprocesstree.models.graphmodels.HelloWorldGraph;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class PluginTest {
    @Plugin(
            name = "Configurable Process Tree Visualizer",
            parameterLabels = { },
            returnLabels = { "Configurable Process Tree" },
            returnTypes = { HelloWorldGraph.class },
            userAccessible = true,
            help = "Start up visualizer"
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa",
            email = "ekauffma@dcc.uchile.cl"
    )
    public HelloWorldGraph generateTestTree(PluginContext context) {
        return new HelloWorldGraph();
    }
}
