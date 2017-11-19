package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Xor;

import java.util.ArrayList;

public class XorFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Xor(name, label, children);
    }

    @Override
    public String nameToSymbol(String name) {
        return "\u2715";
    }
}
