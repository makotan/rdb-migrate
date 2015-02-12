package com.makotan.tools.writer;

import com.makotan.tools.rdbmodel.RdbModel;

/**
 * User: makotan
 * Date: 15/02/11
 * Time: 6:33
 */
public interface ModelWriter {
    void write(RdbModel model , String fileName);
}
