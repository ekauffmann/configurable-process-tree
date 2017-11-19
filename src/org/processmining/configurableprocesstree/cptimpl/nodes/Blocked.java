package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;

public class Blocked extends AbstractCPTNode {
    public Blocked(String name, String[] label, ArrayList<CPTNode> children) {
        super("BLOCKED", "B", label, children);
    }

    @Override
    public Object addToGraphModel(mxGraph graph, Object parent) {
        Object currentNode = graph.insertVertex(parent, null, this.toString(), 0, 0, 50, 50, "fillCollor=black");
        for(CPTNode child : children) {
            Object childNode = child.addToGraphModel(graph, parent);
            graph.insertEdge(parent, null, "", currentNode, childNode);
        }
        return currentNode;
    }
}
