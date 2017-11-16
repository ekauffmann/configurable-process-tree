package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.List;

public interface CPTNode {
    String toString();
    List<CPTNode> getChildren();
    void setName(String name);
    void setLabel(String[] label);
    void addChild(CPTNode child);
    void addChildren(List<CPTNode> children);
    Object addToGraphModel(mxGraph graph, Object parent);
}
