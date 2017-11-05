package org.processmining.configurableprocesstree.cptimpl;

public class ConfigurableProcessTree {
    private ICPTNode root;

    public ConfigurableProcessTree(ICPTNode root) {
        this.root = root;
    }

    public ICPTNode getRoot() {
        return root;
    }
}
