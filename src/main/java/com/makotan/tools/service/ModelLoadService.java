package com.makotan.tools.service;

import com.makotan.tools.loader.ModelLoader;
import com.makotan.tools.loader.ModelYamlLoader;
import com.makotan.tools.model.InputType;
import com.makotan.tools.rdbmodel.RdbModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 15:16
 */
@Component
public class ModelLoadService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private ModelYamlLoader yamlLoader;

    public RdbModel loadModel(InputType inputType , String name) {
        ModelLoader loader;
        if (inputType == InputType.jdbc) {
            String[] splitUrl = name.split(":");
            String dbType = splitUrl[1] + "Loader";
            loader = (ModelLoader)context.getBean(dbType, ModelLoader.class);
        } else {
            loader = yamlLoader;
        }
        return loader.load(name);
    }
}
