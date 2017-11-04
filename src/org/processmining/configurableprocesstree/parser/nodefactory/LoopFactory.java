package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.operators.And;
import org.processmining.configurableprocesstree.cptimpl.operators.Loop;

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
