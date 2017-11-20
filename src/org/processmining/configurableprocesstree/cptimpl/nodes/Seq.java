package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Seq extends AbstractCPTNode {
    public Seq(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("SEQ", "\u2192", label, children);
    }

    public Seq() {
        super("SEQ", "\u2192", new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public CPTNode newCleanDuplicate() {
        return new Seq();
    }
}
