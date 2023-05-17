package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.interfaces.internal.config.Config;
import lombok.Getter;

@Getter
public abstract class AbstractSoapService {
    protected final int RETRY_TIMES_IF_FAIL = Integer.parseInt(System.getProperty("com.softart.dfe.soap.retry", "5"));
    protected final boolean LAZY_INITIALIZATION = Boolean.parseBoolean(System.getProperty("com.softart.dfe.soap.lazy", "false"));
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
