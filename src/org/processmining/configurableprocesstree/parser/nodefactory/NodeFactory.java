package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;

import java.util.ArrayList;

public interface NodeFactory {
    ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children);
}
