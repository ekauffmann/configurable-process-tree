package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCPTNode implements CPTNode {
    private String name;
    private String[] label;
    private List<CPTNode> children;

    public AbstractCPTNode(String name) {
        this.name = name;
        this.label = new String[]{};
        this.children = new ArrayList<>();
    }

    public AbstractCPTNode(String name, String[] label, ArrayList<CPTNode> children) {
        this.name = name;
        this.label = label;
        this.children = children;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(String s : this.label) {
            builder.append(s);
        }
        return this.name + "\n" + builder.toString();
    }

    @Override
    public List<CPTNode> getChildren() {
        return this.children;
    }

    @Override
    public void addChild(CPTNode child) {
        this.children.add(child);
    }

    @Override
    public void addChildren(List<CPTNode> children) {
        this.children.addAll(children);
    }

    @Override
    public Object addToGraphModel(mxGraph graph, Object parent) {
        Object currentNode = graph.insertVertex(parent, null, this.toString(), 0, 0, 50, 50);
        for(CPTNode child : children) {
            Object childNode = child.addToGraphModel(graph, parent);
            graph.insertEdge(parent, null, "", currentNode, childNode);
        }
        return currentNode;
    }
}
