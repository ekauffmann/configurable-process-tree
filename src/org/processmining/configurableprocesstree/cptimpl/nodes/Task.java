package org.processmining.configurableprocesstree.cptimpl.nodes;

public class Task extends AbstractCPTNode {
    public Task(String label) {
        super(label);
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
