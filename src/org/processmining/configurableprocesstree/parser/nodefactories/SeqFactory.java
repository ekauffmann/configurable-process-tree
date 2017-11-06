package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Seq;

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
