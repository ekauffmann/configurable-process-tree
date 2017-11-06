package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Or;

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
