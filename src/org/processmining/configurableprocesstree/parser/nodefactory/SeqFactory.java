package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.operators.Seq;

import java.util.ArrayList;

public class SeqFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        Seq seqNode = new Seq();
        seqNode.setLabel(label);
        seqNode.addChildren(children);
        return seqNode;
    }
}
