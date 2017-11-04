package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCPTNode implements ICPTNode {
    private String name;
    private String label;
    private List<ICPTNode> children;

    public AbstractCPTNode(String name) {
        this.name = name;
        this.label = "[]";
        this.children = new ArrayList<>();
    }

    public AbstractCPTNode(String name, String label, ArrayList<ICPTNode> children) {
        this.name = name;
        this.label = label;
        this.children = children;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = "[" + label + "]";
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.label;
    }

    @Override
    public List<ICPTNode> getChildren() {
        return this.children;
    }

    @Override
    public void addChild(ICPTNode child) {
        this.children.add(child);
    }

    @Override
    public void addChildren(List<ICPTNode> children) {
        this.children.addAll(children);
    }

    @Override
    public Object addToGraphModel(mxGraph graph, Object parent) {
        Object currentNode = graph.insertVertex(parent, null, toString(), 0, 0, 50, 50);
        for(ICPTNode child : children) {
            Object childNode = child.addToGraphModel(graph, parent);
            graph.insertEdge(parent, null, "", currentNode, childNode);
        }
        return currentNode;
    }
}
