package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Seq extends AbstractCPTNode {
    public Seq(String name, String[] label, ArrayList<CPTNode> children) {
        super("SEQ", "\u2192", label, children);
    }
}
