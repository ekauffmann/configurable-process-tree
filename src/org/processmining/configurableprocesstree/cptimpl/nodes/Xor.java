package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Xor extends AbstractCPTNode {
    public Xor(String name, String[] label, ArrayList<CPTNode> children) {
        super("XOR", "\u2715", label, children);
    }
}
