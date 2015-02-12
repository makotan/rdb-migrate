package com.makotan.tools.writer;

import com.makotan.tools.exception.RmException;
import com.makotan.tools.rdbmodel.RdbModel;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;

/**
 * User: makotan
 * Date: 15/02/11
 * Time: 6:33
 */
@Component("yamlWriter")
public class YamlWriter implements ModelWriter {
    public void write(RdbModel model , String fileName) {
        Yaml yaml = new Yaml();
        try (FileWriter fw = new FileWriter(fileName)) {
            yaml.dump(model , fw);
            fw.flush();
        } catch (IOException e) {
            throw new RmException(e);
        }
    }
}
