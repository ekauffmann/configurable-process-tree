package org.processmining.configurableprocesstree.cptimpl;

import com.mxgraph.view.mxGraph;
import org.ujmp.core.collections.ArrayIndexList;

import java.util.List;

public abstract class AbstractCPTNode implements ICPTNode {
    private String label;
    private List<ICPTNode> children;

    public AbstractCPTNode(String label) {
        this.label = label;
        this.children = new ArrayIndexList<ICPTNode>();
    }

    @Override
    public String toString() {
        return this.label;
    }

    public List<ICPTNode> getChildren() {
        return this.children;
    }

    @Override
    public void addChild(ICPTNode child) {
        this.children.add(child);
    }

    @Override
    public Object addToGraphModel(mxGraph graph, Object parent) {
        Object currentNode = graph.insertVertex(parent, null, toString(), 0, 0, 50, 50);
        for(ICPTNode child : children) {
            Object childNode = child.addToGraphModel(graph, parent);
            graph.insertEdge(parent, null, "", currentNode, childNode);
        }
        return currentNode;
    }
}
