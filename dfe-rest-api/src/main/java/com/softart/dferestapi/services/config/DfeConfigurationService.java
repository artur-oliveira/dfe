package com.softart.dferestapi.services.config;

import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dferestapi.models.company.Company;

public interface DfeConfigurationService {

    NfConfig getNfConfig(Company company);

    CteConfig getCteConfig(Company company);

    MdfeConfig getMdfeConfig(Company company);

}
