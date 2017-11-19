package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.CPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Task;

import java.util.ArrayList;

public class TaskFactory implements NodeFactory {
    @Override
    public CPTNode buildNode(String name, String[] label, ArrayList<CPTNode> children) {
        return new Task(name, label, children);
    }
}
