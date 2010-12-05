package org.apache.tiles.autotag.velocity;

import java.io.File;

import org.apache.tiles.autotag.generate.TemplateGenerator;
import org.apache.tiles.autotag.generate.TemplateGeneratorBuilder;
import org.apache.tiles.autotag.generate.TemplateGeneratorFactory;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTemplateGeneratorFactory implements
        TemplateGeneratorFactory {

    /**
     * Location of the file.
     */
    private File classesOutputDirectory;

    /**
     * Location of the file.
     */
    private File resourcesOutputDirectory;

    private VelocityEngine velocityEngine;

    private TemplateGeneratorBuilder templateGeneratorBuilder;

    public VelocityTemplateGeneratorFactory(File classesOutputDirectory,
            File resourcesOutputDirectory, VelocityEngine velocityEngine, TemplateGeneratorBuilder templateGeneratorBuilder) {
        this.classesOutputDirectory = classesOutputDirectory;
        this.resourcesOutputDirectory = resourcesOutputDirectory;
        this.velocityEngine = velocityEngine;
        this.templateGeneratorBuilder = templateGeneratorBuilder;
    }

    @Override
    public TemplateGenerator createTemplateGenerator() {
        return templateGeneratorBuilder
                .setClassesOutputDirectory(classesOutputDirectory)
                .setResourcesOutputDirectory(resourcesOutputDirectory)
                .addResourcesTemplateSuiteGenerator(
                        new VelocityPropertiesGenerator(velocityEngine))
                .addClassesTemplateClassGenerator(
                        new VelocityDirectiveGenerator(velocityEngine)).build();
    }

}
