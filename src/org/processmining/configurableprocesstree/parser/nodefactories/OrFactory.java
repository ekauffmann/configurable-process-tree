package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Or;

import java.util.ArrayList;

public class OrFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        Or orNode = new Or();
        orNode.setLabel(label);
        orNode.addChildren(children);
        return orNode;
    }
}
