package com.makotan.tools.loader;

import com.makotan.tools.exception.RmException;
import com.makotan.tools.rdbmodel.RdbModel;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileReader;
import java.io.IOException;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 15:21
 */
@Component
public class ModelYamlLoader implements ModelLoader {
    @Override
    public RdbModel load(String name) {
        Constructor constructor = new Constructor(RdbModel.class);
        Yaml yaml = new Yaml(constructor);
        Object model;
        try (FileReader reader = new FileReader(name)) {
            model = yaml.load(reader);
        } catch (IOException e) {
            throw new RmException(e);
        }
        return (RdbModel) model;
    }
}
