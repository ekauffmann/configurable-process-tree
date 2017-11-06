package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.configurableprocesstree.exceptions.IncorrectCPTStringFormat;
import org.processmining.configurableprocesstree.exceptions.RuleNotFoundException;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;

public class ApplyConfigurationsPlugin {
    @Plugin(
            name = "Apply Configurations of a Configurable Process Tree",
            parameterLabels = { },
            returnLabels = { "Configurable Process Tree" },
            returnTypes = { ConfigurableProcessTree.class },
            userAccessible = true,
            help = "asdasd"
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa Kauffmann F.",
            email = "ekauffma@dcc.uchile.cl"
    )
    public  applyConfigurations(PluginContext context, ConfigurableProcessTree cpt){
    }
}
