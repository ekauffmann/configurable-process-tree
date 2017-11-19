package org.processmining.configurableprocesstree.parser.factories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Loop;

import java.util.ArrayList;

public class LoopFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Loop(name, label, children);
    }

    @Override
    public String nameToSymbol(String name) {
        return "\u27F3";
    }
}
