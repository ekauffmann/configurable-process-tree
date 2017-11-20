package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Xor extends AbstractCPTNode {
    public Xor(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("XOR", "\u2715", label, children);
    }

    public Xor() {
        super("XOR", "\u2715", new ArrayList<>(), new ArrayList<>());
    }

}
