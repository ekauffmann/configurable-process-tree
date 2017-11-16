package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.And;

import java.util.ArrayList;

public class AndFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        And andNode = new And();
        andNode.setLabel(label);
        andNode.addChildren(children);
        return andNode;
    }
}
