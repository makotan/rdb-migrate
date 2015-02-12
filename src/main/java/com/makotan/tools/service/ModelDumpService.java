package com.makotan.tools.service;

import com.makotan.tools.loader.ModelLoader;
import com.makotan.tools.model.InputType;
import com.makotan.tools.model.OutputType;
import com.makotan.tools.rdbmodel.RdbModel;
import com.makotan.tools.writer.YamlWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * User: makotan
 * Date: 15/02/11
 * Time: 8:33
 */
@Component
public class ModelDumpService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private YamlWriter yamlWriter;


    public void dumpModel(OutputType outputType , RdbModel model, String name) {
        if (outputType == OutputType.yaml) {
            yamlWriter.write(model , name);
        }
    }
}
