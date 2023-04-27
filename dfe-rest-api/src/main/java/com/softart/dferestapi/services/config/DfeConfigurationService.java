package com.softart.dferestapi.services.config;

import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dferestapi.models.company.Company;

public interface DfeConfigurationService {

    KeyStoreInfo keyStoreInfo(Company company);

    NfeConfig getNfeConfig(Company company);

    NfceConfig getNfceConfig(Company company);

    CteConfig getCteConfig(Company company);

    MdfeConfig getMdfeConfig(Company company);

    NfeConfig getNfeConfig();

    NfceConfig getNfceConfig();

    CteConfig getCteConfig();

    MdfeConfig getMdfeConfig();

}
