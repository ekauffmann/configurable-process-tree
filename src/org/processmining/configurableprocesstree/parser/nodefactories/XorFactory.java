package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Xor;

import java.util.ArrayList;

public class XorFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        Xor xorNode = new Xor();
        xorNode.setLabel(label);
        xorNode.addChildren(children);
        return xorNode;
    }
}
