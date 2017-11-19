package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Loop extends AbstractCPTNode {
    public Loop(String name, String[] label, ArrayList<CPTNode> children) {
        super("LOOP", "\u27F3", label, children);
    }

    @Override
    public boolean isConsistent() {
        return (this.children.size() == 3) && super.isConsistent();
    }
}
