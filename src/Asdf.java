import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxSvgCanvas;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import org.processmining.configurableprocesstree.parser.CPTParser;
import org.processmining.configurableprocesstree.parser.NodeInfo;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asdf {
    public static void main(String[] args) {
        Stack<NodeInfo> n = new Stack<>();
        n.push(new NodeInfo("primero", new String[]{}));
        n.push(new NodeInfo("segundo", new String[]{}));
        n.peek().incrementChildren();
        System.out.println(n.toString());
    }
}
