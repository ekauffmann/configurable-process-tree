package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.view.mxGraph;

public interface ICPTNode {
    String toString();
    void addChild(ICPTNode child);
    Object addToGraphModel(mxGraph graph, Object parent);
}
