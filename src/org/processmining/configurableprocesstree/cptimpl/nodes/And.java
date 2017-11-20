package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class And extends AbstractCPTNode {
    public And(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("AND", "\u2227", label, children);
    }

    public And() {
        super("AND", "\u2227", new ArrayList<>(), new ArrayList<>());
    }
}
