package com.softart.dferestapi.services.config;

import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dferestapi.models.company.Company;
import org.springframework.stereotype.Service;

@Service
public final class DfeConfigurationServiceImpl implements DfeConfigurationService {

    @Override
    public CteConfig getCteConfig(Company company) {
        return null;
    }

    @Override
    public MdfeConfig getMdfeConfig(Company company) {
        return null;
    }

    @Override
    public NfConfig getNfConfig(Company company) {
        return null;
    }
}
