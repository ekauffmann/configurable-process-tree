import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxSvgCanvas;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asdf {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([A-Z0-9]+)(\\[.*\\])?");
        Matcher m = p.matcher("TAU[]");
        m.matches();
    }
//
//    mxSvgCanvas canvas = (mxSvgCanvas) mxCellRenderer
//            .drawCells(graph, null, 1, null,
//                    new mxCellRenderer.CanvasFactory()
//                    {
//                        public mxICanvas createCanvas(
//                                int width, int height)
//                        {
//                            mxSvgCanvas canvas = new mxSvgCanvas(
//                                    mxDomUtils.createSvgDocument(
//                                            width, height));
//                            canvas.setEmbedded(true);
//
//                            return canvas;
//                        }
//
//                    });
//
//						mxUtils.writeFile(mxXmlUtils.getXml(canvas.getDocument()),
//    filename);
}
