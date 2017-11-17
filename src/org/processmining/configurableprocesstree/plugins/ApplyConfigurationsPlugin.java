package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.configurableprocesstree.exceptions.InconsistentCPTException;
import org.processmining.configurableprocesstree.exceptions.IncorrectCPTStringFormat;
import org.processmining.configurableprocesstree.exceptions.RuleNotFoundException;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ApplyConfigurationsPlugin {
    @Plugin(
            name = "Apply Configurations of a Configurable Process Tree",
            parameterLabels = { "Configurable Process Tree" },
            returnLabels = {},
            returnTypes = {},
            userAccessible = true,
            help = ""
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa Kauffmann F.",
            email = "ekauffma@dcc.uchile.cl"
    )
    public void applyConfigurations(PluginContext context, ConfigurableProcessTree cpt) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("/home/elisa/Documents/F/text-input-examples/" + cpt.getName() + ".zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        ArrayList<ConfigurableProcessTree> configurations = cpt.configure();

        for (ConfigurableProcessTree config : configurations) {
            String configString = config.toString();
            writeToZipFile(configString, config.getName(), zipOutputStream);
        }

        zipOutputStream.close();
        fileOutputStream.close();
    }

    private void writeToZipFile(String content, String filename, ZipOutputStream zipOutputStream) throws IOException {
        System.out.println("Writing " + filename + " to zip file");

        ZipEntry zipEntry = new ZipEntry(filename + ".cpt");
        zipOutputStream.putNextEntry(zipEntry);
        byte[] data = content.getBytes();
        zipOutputStream.write(data, 0, data.length);
        zipOutputStream.closeEntry();
    }
}
