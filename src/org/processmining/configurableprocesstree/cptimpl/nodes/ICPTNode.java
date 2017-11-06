package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.List;

public interface ICPTNode {
    String toString();
    List<ICPTNode> getChildren();
    void setName(String name);
    void setLabel(String label);
    void addChild(ICPTNode child);
    void addChildren(List<ICPTNode> children);
    Object addToGraphModel(mxGraph graph, Object parent);
}
