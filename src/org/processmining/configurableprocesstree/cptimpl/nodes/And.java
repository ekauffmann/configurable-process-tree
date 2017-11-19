package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class And extends AbstractCPTNode {
    public And(String name, String[] label, ArrayList<CPTNode> children) {
        super("AND", "\u2227", label, children);
    }
}
