package org.apache.tiles.autotag.generate;

import java.io.File;
import java.util.Map;

import org.apache.tiles.autotag.model.TemplateClass;
import org.apache.tiles.autotag.model.TemplateSuite;

public interface TemplateClassGenerator {

    void generate(File directory, String packageName, TemplateSuite suite, TemplateClass clazz, Map<String, String> parameters);
}
