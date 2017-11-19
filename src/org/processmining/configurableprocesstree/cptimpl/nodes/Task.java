package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Task extends AbstractCPTNode {
    public Task(String name, String[] label, ArrayList<CPTNode> children) {
        super(name, label);
    }

    @Override
    public boolean isConsistent() {
        return this.children.isEmpty();
    }

    @Override
    public String structureTextRepresentation() {
        return "LEAF:" + this.name;
    }
}
