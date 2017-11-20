package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCPTNode implements CPTNode{
    String name;
    String symbol;
    ArrayList<CPTNode> label;
    List<CPTNode> children;

    AbstractCPTNode(String name, ArrayList<CPTNode> label) {
        this(name, name, label, new ArrayList<>());
    }

    AbstractCPTNode(String name, String symbol, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        this.name = name;
        this.symbol = symbol;
        this.label = label;
        this.children = children;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(ArrayList<CPTNode> label) {
        this.label = label;
    }

    // for visualization
    @Override
    public String toString() {
        // do not display label if it is configured
        if (this.label.size() == 1 && "-".equals(this.label.get(0).getSymbol())) {
            return this.getSymbol();
        }
        StringBuilder builder = new StringBuilder();
        for(CPTNode c : this.label) {
            builder.append(c.getSymbol());
            builder.append(", ");
        }
        builder = builder.delete(builder.length() - 2, builder.length());
        return this.symbol + "\n" + builder.toString();
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

    @Override
    public boolean isConsistent() {
        if (this.children.isEmpty()) {
            return false;
        } else {
            for (CPTNode child : this.children) {
                if (!child.isConsistent()) return false;
            }
        }
        return true;
    }

    @Override
    public String structureTextRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append("(");
        for(CPTNode child : this.children) {
            stringBuilder.append(child.structureTextRepresentation());
            stringBuilder.append(", ");
        }

        if (!this.children.isEmpty()) {
            // delete last ',' and ' '
            stringBuilder = stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    @Override
    public int numberOfNodes() {
        // self
        int counter = 1;
        for (CPTNode child : children) {
            counter += child.numberOfNodes();
        }

        return counter;
    }

    @Override
    public CPTNode applyConfiguration(int index) {
        return this;
    }
}
