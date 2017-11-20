package org.processmining.configurableprocesstree.cptimpl.nodes;

import java.util.ArrayList;

public class NoConfigNode extends AbstractCPTNode {
    public NoConfigNode(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("-", "-", label, children);
    }

    public NoConfigNode() {
        super("-", "-", new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public boolean doNotApplyConfig() {
        return true;
    }

    @Override
    public CPTNode newCleanDuplicate() {
        return new NoConfigNode();
    }
}
