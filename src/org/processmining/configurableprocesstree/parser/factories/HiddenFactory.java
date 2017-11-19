package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Hidden;

import java.util.ArrayList;

public class HiddenFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Hidden(name, label, children);
    }

    @Override
    public String nameToSymbol(String name) {
        return "H";
    }
}
