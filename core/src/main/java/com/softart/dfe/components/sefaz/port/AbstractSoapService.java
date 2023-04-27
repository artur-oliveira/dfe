package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.interfaces.internal.config.Config;
import lombok.Getter;

@Getter
public abstract class AbstractSoapService {
    protected boolean initialized = false;
    protected Config config;

    public AbstractSoapService() {

    }

    public AbstractSoapService(Config config) {
        this.config = config;
    }

    public AbstractSoapService withConfig(Config config) {
        this.config = config;
        return this;
    }
}
