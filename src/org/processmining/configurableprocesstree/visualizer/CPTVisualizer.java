package org.processmining.configurableprocesstree.visualizer;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
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
    public JComponent visualize(UIPluginContext context, ConfigurableProcessTree cpt) {
        JFrame frame = new JFrame();
        mxGraph graph = new mxGraph();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            cpt.getRoot().addToGraphModel(graph, parent);
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

        frame.getContentPane().add(graphComponent);

        return (JComponent) frame.getContentPane();
    }
}
