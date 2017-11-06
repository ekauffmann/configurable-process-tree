package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;

import java.util.ArrayList;

public interface NodeFactory {
    ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children);
}