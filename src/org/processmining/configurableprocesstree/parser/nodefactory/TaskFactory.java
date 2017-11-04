package org.processmining.configurableprocesstree.parser.nodefactory;

import org.processmining.configurableprocesstree.cptimpl.ICPTNode;
import org.processmining.configurableprocesstree.cptimpl.Task;

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
