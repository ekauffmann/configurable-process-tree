package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.operators.And;

import java.util.ArrayList;

public class AndFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        And andNode = new And();
        andNode.setLabel(label);
        andNode.addChildren(children);
        return andNode;
    }
}
