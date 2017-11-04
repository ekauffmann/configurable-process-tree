package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.operators.Or;

import java.util.ArrayList;

public class OrFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        Or orNode = new Or();
        orNode.setLabel(label);
        orNode.addChildren(children);
        return orNode;
    }
}
