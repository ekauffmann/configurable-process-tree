package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;

import java.util.ArrayList;

public interface CPTElementFactory {
    CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children);
    String nameToSymbol(String name);
}
