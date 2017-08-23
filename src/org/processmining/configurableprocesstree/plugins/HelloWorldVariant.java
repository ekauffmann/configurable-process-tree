package org.processmining.configurableprocesstree.plugins;

import org.processmining.contexts.uitopia.annotations.UITopiaVariant;
import org.processmining.framework.plugin.PluginContext;
import org.processmining.framework.plugin.annotations.Plugin;
import org.processmining.framework.plugin.annotations.PluginVariant;

@Plugin(
        name = "My Hello World Variant Plugin",
        parameterLabels = { "My string input" },
        returnLabels = { "Hello world string" },
        returnTypes = { String.class },
        userAccessible = true,
        help = "Produces a string"
)
public class HelloWorldVariant {
    @UITopiaVariant(
            affiliation = "My company",
            author = "My name",
            email = "My e-mail address"
    )
    @PluginVariant(
            requiredParameterLabels = {}
    )
    public static String helloWorld(PluginContext context) {
        return "Hello World";
    }

    @UITopiaVariant(
            affiliation = "My company",
            author = "My name",
            email = "My e-mail address"
    )
    @PluginVariant(
            requiredParameterLabels = {0}
    )
    public static String helloWorld(PluginContext context, String input) {
        return input;
    }
}
