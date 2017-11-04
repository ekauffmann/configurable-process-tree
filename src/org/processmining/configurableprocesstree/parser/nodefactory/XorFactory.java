package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.operators.Xor;

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
