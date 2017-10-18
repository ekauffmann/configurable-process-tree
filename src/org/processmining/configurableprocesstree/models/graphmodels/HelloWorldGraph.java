package org.processmining.configurableprocesstree.models.graphmodels;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.models.MyNode;

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
        MyNode root = new MyNode("Nodo 1");
        MyNode n2 = new MyNode("Nodo 2");
        MyNode n3 = new MyNode("Nodo 3");
        MyNode n4 = new MyNode("Nodo 4");

        root.addChildren(n2);
        root.addChildren(n3);
        n3.addChildren(n4);

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
        graph.setResetEdgesOnMove(true);

        getContentPane().add(graphComponent);
    }

    public static void main(String[] args) {
        HelloWorldGraph frame = new HelloWorldGraph();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}
