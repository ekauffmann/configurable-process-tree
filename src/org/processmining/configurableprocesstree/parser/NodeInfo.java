package org.processmining.configurableprocesstree.parser;

import java.util.Stack;

public class NodeInfo {
    private String name;
    private String[] label;
    private int numberOfChildren;

    public NodeInfo(String name, String[] label) {
        this.name = name;
        this.label = label;
        this.numberOfChildren = 0;
    }

    public void incrementChildren() {
        this.numberOfChildren++;
    }

    public String getName() {
        return this.name;
    }

    public String[] getLabel() {
        return this.label;
    }
    public int getNumberOfChildren() {
        return this.numberOfChildren;
    }

}
