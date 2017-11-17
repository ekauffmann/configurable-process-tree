package org.processmining.configurableprocesstree.cptimpl.nodes;

public class Loop extends AbstractCPTNode {
    public Loop() {
        super("LOOP");
    }

    @Override
    public boolean isConsistent() {
        return (this.children.size() == 3) && super.isConsistent();
    }
}
