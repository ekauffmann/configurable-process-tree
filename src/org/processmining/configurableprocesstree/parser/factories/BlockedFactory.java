package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.Blocked;
import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;

import java.util.ArrayList;

public class BlockedFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Blocked(name, label, children);
    }

    @Override
    public String nameToSymbol(String name) {
        return "B";
    }
}
