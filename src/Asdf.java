import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxSvgCanvas;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.view.mxGraph;
import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.configurableprocesstree.exceptions.EmptyFileException;
import org.processmining.configurableprocesstree.exceptions.IncorrectCPTStringFormat;
import org.processmining.configurableprocesstree.exceptions.MoreThanOneLineFileException;
import org.processmining.configurableprocesstree.exceptions.RuleNotFoundException;
import org.processmining.configurableprocesstree.parser.CPTParser;
import org.processmining.configurableprocesstree.parser.NodeInfo;
import org.processmining.configurableprocesstree.parser.nodefactories.*;
import org.processmining.configurableprocesstree.parser.predicates.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asdf {
    public static void main(String[] args) throws IOException, EmptyFileException, MoreThanOneLineFileException, IncorrectCPTStringFormat, RuleNotFoundException {
        HashMap<Predicate, NodeFactory> rules = new HashMap<>();
        rules.put(new AndPredicate(), new AndFactory());
        rules.put(new LoopPredicate(), new LoopFactory());
        rules.put(new OrPredicate(), new OrFactory());
        rules.put(new SeqPredicate(), new SeqFactory());
        rules.put(new TaskPredicate(), new TaskFactory());
        rules.put(new XorPredicate(), new XorFactory());
        CPTParser parser = new CPTParser(rules);

        String filename = "/home/elisa/Documents/F/text-input-examples/ejemplo_memoria.cpt";
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        ConfigurableProcessTree cpt = parser.parseTreeFromFile(fileInputStream, filename);

        JFrame frame = new JFrame();
        mxGraph graph = cpt.buildMxGraph();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setToolTips(true);
        graphComponent.setConnectable(false);

        frame.getContentPane().add(graphComponent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0,0,700,700);
        frame.setVisible(true);


    }
}
