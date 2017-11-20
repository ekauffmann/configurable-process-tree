package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Hidden extends AbstractCPTNode {
    public Hidden(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("TAU", "\u03C4", label, children);
    }

    public Hidden() {
        super("TAU", "\u03C4", new ArrayList<>(), new ArrayList<>());
    }
}