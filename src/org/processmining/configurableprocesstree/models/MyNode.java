package org.processmining.configurableprocesstree.models;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.List;

public class MyNode {
    private String label;
    private List<MyNode> children;

    public MyNode(String l) {
        this.label = l;
        this.children = new ArrayList<MyNode>();
    };

    public String getLabel() {
        return label;
    }

    public void setLabel(String l) {
        this.label = l;
    }

    public String toString() {
        return label;
    }

    public void addChildren(MyNode child) {
        this.children.add(child);
    }

    public Object addToGraphModel(mxGraph graph, Object parent) {
        Object currentNode = graph.insertVertex(parent, null, toString(), 0, 0, 50, 50);
        for(MyNode child : children) {
            Object childNode = child.addToGraphModel(graph, parent);
            graph.insertEdge(parent, null, "", currentNode, childNode);
        }

        return currentNode;
    }
}
