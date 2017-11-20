package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Loop extends AbstractCPTNode {
    public Loop(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("LOOP", "\u27F3", label, children);
    }

    public Loop() {
        super("LOOP", "\u27F3", new ArrayList<>(), new ArrayList<>());
    }
    @Override
    public boolean isConsistent() {
        return (this.children.size() == 3) && super.isConsistent();
    }

    @Override
    public CPTNode newCleanDuplicate() {
        return new Loop();
    }
}
