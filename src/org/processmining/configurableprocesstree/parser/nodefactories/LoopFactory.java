package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Loop;

import java.util.ArrayList;

public class LoopFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        Loop loopNode = new Loop();
        loopNode.setLabel(label);
        loopNode.addChildren(children);
        return loopNode;
    }
}
