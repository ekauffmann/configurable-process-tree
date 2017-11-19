package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Or extends AbstractCPTNode {
    public Or(String name, String[] label, ArrayList<CPTNode> children) {
        super("OR", "\u2228", label, children);
    }
}
