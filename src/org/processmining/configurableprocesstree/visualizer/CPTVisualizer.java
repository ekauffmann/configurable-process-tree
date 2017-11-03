package org.processmining.configurableprocesstree.visualizer;

import org.processmining.configurableprocesstree.cptimpl.graphmodels.HelloWorldGraph;
import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.framework.plugin.annotations.Plugin;

import javax.swing.*;

public class CPTVisualizer {

    @Plugin(name = "Start Configurable Process Tree Visualizer",
            returnLabels = { "Configurable Process Tree Visualizer" },
            returnTypes = { JComponent.class },
            parameterLabels = {	"Configurable Process Tree" },
            userAccessible = true)
    @Visualizer
    public JComponent visualize(UIPluginContext context, HelloWorldGraph graph) {

        return (JComponent) graph.getContentPane();
    }
}
