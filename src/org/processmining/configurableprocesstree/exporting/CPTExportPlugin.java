package org.processmining.configurableprocesstree.exporting;

import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxSvgCanvas;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.contexts.uitopia.annotations.UIExportPlugin;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;
import org.w3c.dom.Document;

import java.io.File;
import java.io.IOException;

@Plugin(
    name = "Export Configurable Process Tree",
    parameterLabels = { "Configurable Process Tree" , "File" },
    returnLabels = {},
    returnTypes = {}, userAccessible = true
)
@UIExportPlugin(
    description = "Configurable Process Tree visualization (.svg)",
    extension = "svg"
)
public class CPTExportPlugin {
    @UITopiaVariant(
            affiliation = "Universidad de Chile",
            author = "Elisa Kauffmann F.",
            email = "ekauffma@dcc.uchile.cl"
        )
    @PluginVariant(
            requiredParameterLabels = { 0, 1 }
            )
    public void export(PluginContext context, ConfigurableProcessTree cpt, File file) throws IOException {
        mxGraph graph = new mxGraph();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            cpt.getRoot().addToGraphModel(graph, parent);
        } finally {
            graph.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.execute(graph.getDefaultParent());

        graph.setCellsEditable(false);
        graph.setCellsSelectable(true);
        graph.setCellsLocked(true);

        mxSvgCanvas canvas = (mxSvgCanvas) mxCellRenderer
                .drawCells(graph, null, 1, null,
                        new mxCellRenderer.CanvasFactory() {
                            @Override
                            public mxICanvas createCanvas(int width, int height) {
                                mxSvgCanvas canvas = new mxSvgCanvas(
                                        mxDomUtils.createSvgDocument(
                                                width, height
                                        )
                                );
                                canvas.setEmbedded(true);
                                return canvas;
                            }
                        });
        String wrongXML = mxXmlUtils.getXml(canvas.getDocument());
        String correctXML = wrongXML.replaceAll("xmlns=\"\"", "");
        mxUtils.writeFile(correctXML, file.getPath());

    }
}
