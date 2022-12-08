package com.softart.dfe.interfaces.sefaz.port;

import com.softart.dfe.interfaces.internal.config.Config;

public interface SoapService {
    boolean isInitialized();

    Config getConfig();
}
