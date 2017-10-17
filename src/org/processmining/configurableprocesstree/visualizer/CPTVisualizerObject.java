package org.processmining.configurableprocesstree.visualizer;

import org.processmining.processtree.ProcessTree;

public class CPTVisualizerObject {
    ProcessTree tree;

    public CPTVisualizerObject(ProcessTree tree) {
            this.tree = tree;
    }

    public ProcessTree getTree() {
        return tree;
    }
}
