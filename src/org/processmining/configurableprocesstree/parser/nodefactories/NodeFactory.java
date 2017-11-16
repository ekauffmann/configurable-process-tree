package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;

import java.util.ArrayList;

public interface NodeFactory {
    CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children);
}
