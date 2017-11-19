package org.processmining.configurableprocesstree.parser.factories;


import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;

import java.util.ArrayList;

public class NoConfigurationFactory implements CPTElementFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return null;
    }

    @Override
    public String nameToSymbol(String name) {
        return "-";
    }
}
