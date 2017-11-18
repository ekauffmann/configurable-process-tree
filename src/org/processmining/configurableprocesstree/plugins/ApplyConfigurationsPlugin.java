package org.processmining.configurableprocesstree.plugins;

import org.processmining.configurableprocesstree.cptimpl.ConfigurableProcessTree;
import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.plugins.utils.ProvidedObjectHelper;

import java.util.ArrayList;


public class ApplyConfigurationsPlugin {
    @Plugin(
            name = "Apply Configurations of a Configurable Process Tree",
            parameterLabels = { "Configurable Process Tree" },
            returnLabels = {},
            returnTypes = {},
            help = ""
    )
    @UITopiaVariant(
            affiliation = "DCC, Universidad de Chile",
            author = "Elisa Kauffmann F.",
            email = "ekauffma@dcc.uchile.cl"
    )
    public void applyConfigurations(PluginContext context, ConfigurableProcessTree cpt){
        ArrayList<ConfigurableProcessTree> configurations = cpt.configure();
        for(ConfigurableProcessTree config : configurations) {
            context.getProvidedObjectManager().createProvidedObject(config.getName(), config, ConfigurableProcessTree.class, context);
            ProvidedObjectHelper.setFavorite(context, config);
        }

    }

}
