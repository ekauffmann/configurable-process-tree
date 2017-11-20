package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class Or extends AbstractCPTNode {
    public Or(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("OR", "\u2228", label, children);
    }

    public Or() {
        super("OR", "\u2228", new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public CPTNode newCleanDuplicate() {
        return new Or();
    }
}
