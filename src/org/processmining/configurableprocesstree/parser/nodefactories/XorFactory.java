package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Xor;

import java.util.ArrayList;

public class XorFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        Xor xorNode = new Xor();
        xorNode.setLabel(label);
        xorNode.addChildren(children);
        return xorNode;
    }
}
