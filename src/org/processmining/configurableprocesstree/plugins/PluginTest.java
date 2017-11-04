package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.cptimpl.graphmodels.HelloWorldGraph;
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
    public HelloWorldGraph generateTestTree(PluginContext context) throws Exception {
        return new HelloWorldGraph();
    }
}
