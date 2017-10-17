package org.processmining.configurableprocesstree.visualizer;

import org.jgraph.JGraph;
import org.processmining.contexts.uitopia.UIPluginContext;
import org.processmining.contexts.uitopia.annotations.Visualizer;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.processtree.ProcessTree;
import org.processmining.processtree.editor.graphpanel.GraphPanel;
import org.processmining.processtree.editor.interaction.GraphMouseListener;
import org.processmining.processtree.visualization.tree.TreeLayoutBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CPTVisualizer {

    @Plugin(name = "Start Configurable Process Tree Visualizer",
            returnLabels = { "Configurable Process Tree Visualizer" },
            returnTypes = { JComponent.class },
            parameterLabels = {	"Configurable Process Tree" },
            userAccessible = true)
    @Visualizer
    public JComponent visualize(UIPluginContext context, final CPTVisualizerObject visualizerObject){
        ProcessTree tree = visualizerObject.getTree();
        TreeLayoutBuilder builder = new TreeLayoutBuilder(tree);
        JGraph graph = builder.getJGraph();
        return graph;
    }

    private void createLayout(UIPluginContext context, ProcessTree tree, JPanel parent, boolean beginner){
        Rectangle screenRect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        Dimension screenSize = screenRect.getSize();
        int maxWidth = (int) screenSize.getWidth() - 30;
        // scaling due to ProM overhead
        int maxHeight = (int) screenSize.getHeight() - 130;
        Dimension dimGraphPanel = new Dimension((int)(0.7 * maxWidth), (int)(0.7 * maxHeight));
        Dimension dimPropertyPanel = new Dimension((int)(0.7 * maxWidth), (int)(0.3 * maxHeight));
        Dimension dimEditorPanel = new Dimension((int)(0.3 * maxWidth), maxHeight);
        // create the set of folded nodes
        Set<UUID> foldedNodes = new HashSet<>();
        // first make the visualiser for the process tree itself
        GraphPanel graphPanel = new GraphPanel(tree, dimGraphPanel, foldedNodes);
        // add the properties panel
        //PropertyPanel propertyPanel = new PropertyPanel(tree, dimPropertyPanel);
        //propertyPanel.setGraphPanel(graphPanel);
        // now make a mouse listener to connect all
        GraphMouseListener graphMouseListener = new GraphMouseListener(tree, graphPanel.getGraph(), foldedNodes);
        //graphMouseListener.addPropertyPanel(propertyPanel);
        graphMouseListener.addGraphPanel(graphPanel);
        // add the mouse listener to the graph panel
        graphPanel.addMouseListener(graphMouseListener);
        // create the editor panel
        //EditorPanel editorPanel = new EditorPanel(context, tree, graphPanel, graphMouseListener, dimEditorPanel, beginner);

        //graphMouseListener.addEditorPanel(editorPanel);
        //graphPanel.setEditorPanel(editorPanel);

        //JSplitPane topBottom = new JSplitPane(JSplitPane.VERTICAL_SPLIT, graphPanel.getComponent(), propertyPanel.getComponent());
        //topBottom.setPreferredSize(new Dimension((int)(0.7*maxWidth), maxHeight));
        //topBottom.setDividerLocation((int)(0.7 * maxHeight));

        //editorPanel.getEditorPanel().setPreferredSize(new Dimension((int)(0.3*maxWidth), maxHeight));

        //JSplitPane leftRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, topBottom, editorPanel.getEditorPanel());
        //topBottom.validate();
        //leftRight.validate();
        //parent.add(leftRight);
        // now do some magic with the size of the stuff
        //int widthEditorPanel = editorPanel.getWidth();
        // we still have the maxWidth
        //int widthOfTopBottom = (maxWidth - widthEditorPanel);
        //topBottom.setPreferredSize(new Dimension(widthOfTopBottom, maxHeight - 2));

    }
}
