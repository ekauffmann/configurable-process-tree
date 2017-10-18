package org.processmining.configurableprocesstree.visualizer;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgraph.JGraph;
import org.processmining.configurableprocesstree.models.graphmodels.HelloWorldGraph;
import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.processtree.ProcessTree;
import org.processmining.processtree.editor.graphpanel.GraphPanel;
import org.processmining.processtree.editor.interaction.GraphMouseListener;
import org.processmining.processtree.visualization.tree.TreeLayoutBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
