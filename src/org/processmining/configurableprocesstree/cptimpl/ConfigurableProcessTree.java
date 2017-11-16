package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;


public class ConfigurableProcessTree {
    private CPTNode root;

    public ConfigurableProcessTree(CPTNode root) {
        this.root = root;
    }

    public CPTNode getRoot() {
        return root;
    }

    public mxGraph buildMxGraph() {
        mxGraph graph = new mxGraph();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            this.root.addToGraphModel(graph, parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());

        graph.setCellsEditable(false);
        graph.setCellsSelectable(false);
        graph.setCellsLocked(true);

        return graph;
    }
}
