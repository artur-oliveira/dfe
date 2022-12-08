package com.softart.dfe.interfaces.services;

import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.process.cte.CteProcess;

public interface CteSefazService extends SefazService {

    CteConfig getConfig();

    CteProcess getProcess();

}
