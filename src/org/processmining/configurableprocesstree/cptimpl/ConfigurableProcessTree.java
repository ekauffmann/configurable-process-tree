package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;

import java.util.ArrayList;


public class ConfigurableProcessTree {
    private CPTNode root;
    private String name;
    private ArrayList<String> configurations;

    public ConfigurableProcessTree(CPTNode root, String name, ArrayList<String> configurations) {
        this.root = root;
        this.name = name.replace(".cpt", "");
        this.configurations = configurations;
    }

    public ConfigurableProcessTree(CPTNode root, String name) {
        // build default empty configuration
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < root.numberOfNodes() - 1; i++) {
            stringBuilder.append("-,");
        }
        stringBuilder.append("-");
        stringBuilder.append("]");

        ArrayList<String> configs = new ArrayList<>();
        configs.add(stringBuilder.toString());

        this.root = root;
        this.name = name.replace(".cpt", "");
        this.configurations = configs;
    }

    public CPTNode getRoot() {
        return root;
    }

    public String getName() {
        return this.name;
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

    public boolean isConsistent() {
        return this.root.isConsistent();
    }

    public ArrayList<ConfigurableProcessTree> configure() {
        ArrayList<ConfigurableProcessTree> configs = new ArrayList<>();

        for (int i = 0; i < this.configurations.size(); i++) {
            CPTNode appliedConfig = this.root.applyConfiguration(i);
            String configName = this.name + "_" + (i+1);
            configs.add(new ConfigurableProcessTree(appliedConfig, configName));
        }

        return configs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.root.structureTextRepresentation());
        stringBuilder.append(" ");
        stringBuilder.append("[");
        for(String config : this.configurations) {
            stringBuilder.append("[");
            stringBuilder.append(config);
            stringBuilder.append("]");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
