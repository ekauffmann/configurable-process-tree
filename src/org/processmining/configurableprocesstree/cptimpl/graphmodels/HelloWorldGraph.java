package org.processmining.configurableprocesstree.cptimpl.graphmodels;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.*;
import org.processmining.configurableprocesstree.cptimpl.operators.And;
import org.processmining.configurableprocesstree.cptimpl.operators.Or;
import org.processmining.configurableprocesstree.cptimpl.operators.Xor;

import javax.swing.*;

public class HelloWorldGraph extends JFrame {

    public HelloWorldGraph() {
        super("Hello Graph!");
        mxGraph graph = new mxGraph(){
            public boolean isCellSelectable(Object cell) {
                if (model.isEdge(cell)) {
                    return false;
                }
                return super.isCellSelectable(cell);
            }
        };
        Object parent = graph.getDefaultParent();
        ICPTNode root = new And();
        ICPTNode n2 = new And();
        ICPTNode n3 = new Or();
        ICPTNode n4 = new Or();
        ICPTNode n5 = new Xor();
        ICPTNode task = new Task("Task 1");

        root.addChild(n2);
        root.addChild(n3);
        n2.addChild(n4);
        n3.addChild(n5);
        n3.addChild(task);

        graph.getModel().beginUpdate();
        try {
            root.addToGraphModel(graph, parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());


        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setToolTips(true);
        graphComponent.setConnectable(false);

        graph.setCellsEditable(false);
        graph.setCellsSelectable(false);
        graph.setCellsLocked(true);

        getContentPane().add(graphComponent);
    }

    public static void main(String[] args) {
        HelloWorldGraph frame = new HelloWorldGraph();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}
