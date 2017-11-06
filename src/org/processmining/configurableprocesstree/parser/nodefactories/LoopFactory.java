package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Loop;

import java.util.ArrayList;

public class LoopFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        Loop loopNode = new Loop();
        loopNode.setLabel(label);
        loopNode.addChildren(children);
        return loopNode;
    }
}
