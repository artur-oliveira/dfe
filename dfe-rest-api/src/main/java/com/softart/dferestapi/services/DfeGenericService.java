package com.softart.dferestapi.services;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dferestapi.services.config.DfeConfigurationService;

public interface DfeGenericService {
    Config getConfig();

    DfeConfigurationService getDfeConfigurationService();
}
