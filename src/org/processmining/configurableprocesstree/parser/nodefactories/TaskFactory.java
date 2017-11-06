package org.processmining.configurableprocesstree.parser.nodefactories;

import org.processmining.configurableprocesstree.cptimpl.nodes.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.nodes.Task;

import java.util.ArrayList;

public class TaskFactory implements NodeFactory {
    @Override
    public ICPTNode buildNode(String name, String label, ArrayList<ICPTNode> children) {
        Task taskNode = new Task(name);
        taskNode.setLabel(label);
        taskNode.addChildren(children);
        return taskNode;
    }
}
