package org.processmining.configurableprocesstree.cptimpl.nodes;

import com.mxgraph.view.mxGraph;

import java.util.ArrayList;

public class Blocked extends AbstractCPTNode {
    public Blocked(String name, ArrayList<CPTNode> label, ArrayList<CPTNode> children) {
        super("BLOCKED", "B", label, children);
    }

    public Blocked() {
        super("BLOCKED", "B", new ArrayList<>(), new ArrayList<>());
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
