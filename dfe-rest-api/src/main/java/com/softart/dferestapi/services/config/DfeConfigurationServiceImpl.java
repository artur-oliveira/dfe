package com.softart.dferestapi.services.config;

import com.softart.dfe.components.internal.config.PfxCteConfigImpl;
import com.softart.dfe.components.internal.config.PfxMdfeConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfceConfigImpl;
import com.softart.dfe.components.internal.config.PfxNfeConfigImpl;
import com.softart.dfe.interfaces.internal.KeyStoreInfo;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dferestapi.components.aws.S3;
import com.softart.dferestapi.models.company.Company;
import com.softart.dferestapi.services.auth.AccountService;
import com.softart.dferestapi.services.certificate.CertificateService;
import com.softart.dferestapi.services.certificate.KeyStoreService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public final class DfeConfigurationServiceImpl implements DfeConfigurationService {

    private final AccountService accountService;
    private final S3 s3;
    private final CertificateService certificateService;
    private final KeyStoreService keyStoreService;

    @Autowired
    public DfeConfigurationServiceImpl(
            AccountService accountService,
            S3 s3,
            CertificateService certificateService,
            KeyStoreService keyStoreService
    ) {
        this.accountService = accountService;
        this.s3 = s3;
        this.certificateService = certificateService;
        this.keyStoreService = keyStoreService;
    }

    @Override
    @SneakyThrows
    public KeyStoreInfo keyStoreInfo(Company company) {
        return getKeyStoreService().getKeyStore(company.getCertificate().getMd5(), getCertificateService().decrypt(company.getCertificate()).getDecryptedPassword());
    }

    @Override
    @SneakyThrows
    public NfeConfig getNfeConfig(Company company) {
        return new PfxNfeConfigImpl(company.getAddress().getUf(), company.getInfo().getCnpj(), company.getNfeConfiguration().getEnvironment(), keyStoreInfo(company), company.getNfeConfiguration().getEmissionType(), company.getNfeConfiguration().getNfSend());
    }

    @Override
    @SneakyThrows
    public NfceConfig getNfceConfig(Company company) {
        return new PfxNfceConfigImpl(company.getAddress().getUf(), company.getInfo().getCnpj(), company.getNfceConfiguration().getEnvironment(), keyStoreInfo(company), company.getNfceConfiguration().getEmissionType(), company.getNfceConfiguration().getNfSend(), company.getNfceConfiguration().getCsc(), company.getNfceConfiguration().getCscId());
    }

    @Override
    @SneakyThrows
    public CteConfig getCteConfig(Company company) {
        return new PfxCteConfigImpl(company.getAddress().getUf(), company.getInfo().getCnpj(), company.getCteConfiguration().getEnvironment(), keyStoreInfo(company), company.getCteConfiguration().getEmissionType());
    }

    @Override
    @SneakyThrows
    public MdfeConfig getMdfeConfig(Company company) {
        return new PfxMdfeConfigImpl(company.getAddress().getUf(), company.getInfo().getCnpj(), company.getMdfeConfiguration().getEnvironment(), keyStoreInfo(company), company.getMdfeConfiguration().getEmissionType());
    }

    @Override
    public NfeConfig getNfeConfig() {
        return getNfeConfig(getAccountService().getLoggedAccount().getDefaultCompany());
    }

    @Override
    public NfceConfig getNfceConfig() {
        return getNfceConfig(getAccountService().getLoggedAccount().getDefaultCompany());
    }

    @Override
    public CteConfig getCteConfig() {
        return getCteConfig(getAccountService().getLoggedAccount().getDefaultCompany());
    }

    @Override
    public MdfeConfig getMdfeConfig() {
        return getMdfeConfig(getAccountService().getLoggedAccount().getDefaultCompany());
    }
}
