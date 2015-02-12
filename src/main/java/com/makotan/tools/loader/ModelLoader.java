package com.makotan.tools.loader;

import com.makotan.tools.rdbmodel.RdbModel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 15:23
 */
public interface ModelLoader {
    RdbModel load(String name);
}
