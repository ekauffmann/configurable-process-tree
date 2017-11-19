package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Seq;

import java.util.ArrayList;

public class SeqFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Seq(name, label, children);
    }
}
