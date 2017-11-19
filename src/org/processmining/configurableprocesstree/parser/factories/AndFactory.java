package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.And;

import java.util.ArrayList;

public class AndFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new And(name, label, children);
    }

    @Override
    public String nameToSymbol(String name) {
        return "\u2227";
    }
}
