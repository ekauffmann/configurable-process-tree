package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.view.mxGraph;

import java.util.List;

public interface ICPTNode {
    String toString();
    List<ICPTNode> getChildren();
    void addChild(ICPTNode child);
    Object addToGraphModel(mxGraph graph, Object parent);
}
