package org.apache.tiles.autotag.velocity;

import java.io.File;
import java.util.Map;

import org.apache.tiles.autotag.generate.AbstractTemplateClassGenerator;
import org.apache.tiles.autotag.model.TemplateClass;
import org.apache.tiles.autotag.model.TemplateSuite;
import org.apache.velocity.app.VelocityEngine;

public class VelocityDirectiveGenerator extends AbstractTemplateClassGenerator {

    public VelocityDirectiveGenerator(VelocityEngine velocityEngine) {
        super(velocityEngine);
    }

    @Override
    protected String getDirectoryName(File directory, String packageName,
            TemplateSuite suite, TemplateClass clazz, Map<String, String> parameters) {
        return packageName.replaceAll("\\.", "/");
    }

    @Override
    protected String getFilename(File directory, String packageName,
            TemplateSuite suite, TemplateClass clazz, Map<String, String> parameters) {
        return clazz.getTagClassPrefix() + "Directive.java";
    }

    @Override
    protected String getTemplatePath(File directory, String packageName,
            TemplateSuite suite, TemplateClass clazz, Map<String, String> parameters) {
        return "/org/apache/tiles/autotag/velocity/velocityDirective.vm";
    }
}
