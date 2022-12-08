package com.softart.dfe.interfaces.storage;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XML;

public interface Store<T extends XML> {

    Config getConfig();

    T getData();

    String getXml();

}
