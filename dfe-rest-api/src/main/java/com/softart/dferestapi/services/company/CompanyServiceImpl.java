package com.softart.dferestapi.services.company;

import com.softart.dferestapi.exceptions.entity.EntityAlreadyExistsException;
import com.softart.dferestapi.exceptions.entity.EntityNotFoundException;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.company.Company;
import com.softart.dferestapi.models.company.request.CompanyPartialUpdateRequest;
import com.softart.dferestapi.models.company.request.CompanyRequest;
import com.softart.dferestapi.models.company.request.CompanyUpdateRequest;
import com.softart.dferestapi.repository.CompanyRepository;
import com.softart.dferestapi.services.auth.AccountService;
import com.softart.dferestapi.services.certificate.CertificateService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Getter
public class CompanyServiceImpl implements CompanyService {

    protected final AccountService accountService;
    protected final CertificateService certificateService;
    protected final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(AccountService accountService, CertificateService certificateService, CompanyRepository companyRepository) {
        this.accountService = accountService;
        this.certificateService = certificateService;
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        Account account = getAccountService().getLoggedAccount();

        if (account.isAdmin()) {
            return getCompanyRepository().findAll();
        } else {
            return getCompanyRepository().findAllByAccount(account);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Company findById(Long id) {
        return getCompanyRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    @Transactional
    public Company createCompany(CompanyRequest companyRequest) {
        Account account = getAccountService().getLoggedAccount();
        if (Objects.nonNull(companyRequest.getInfo().getCnpj())) {
            getCompanyRepository().findFirstByAccountAndInfoCnpj(account, companyRequest.getInfo().getCnpj()).ifPresent((company -> {
                throw new EntityAlreadyExistsException(company.getId());
            }));
        }
        if (Objects.nonNull(companyRequest.getInfo().getCpf())) {
            getCompanyRepository().findFirstByAccountAndInfoCpf(account, companyRequest.getInfo().getCpf()).ifPresent((company -> {
                throw new EntityAlreadyExistsException(company.getId());
            }));
        }

        return getCompanyRepository().save(Company.builder()
                .account(getAccountService().getLoggedAccount())
                .address(companyRequest.getAddress())
                .certificate(Optional.ofNullable(companyRequest.getCertificateId()).map((cert) -> getCertificateService().findById(companyRequest.getCertificateId())).orElse(null))
                .nfeConfiguration(companyRequest.getNfeConfiguration())
                .cteConfiguration(companyRequest.getCteConfiguration())
                .nfceConfiguration(companyRequest.getNfceConfiguration())
                .mdfeConfiguration(companyRequest.getMdfeConfiguration())
                .info(companyRequest.getInfo())
                .build());
    }

    @Override
    @Transactional
    public Company updateCompany(CompanyUpdateRequest updateRequest) {
        Company company = findById(updateRequest.getId());

        company.setInfo(updateRequest.getInfo());
        company.setAddress(updateRequest.getAddress());
        company.setMdfeConfiguration(updateRequest.getMdfeConfiguration());
        company.setCteConfiguration(updateRequest.getCteConfiguration());
        company.setNfceConfiguration(updateRequest.getNfceConfiguration());
        company.setNfeConfiguration(updateRequest.getNfeConfiguration());
        company.setCertificate(Optional.ofNullable(updateRequest.getCertificateId()).map((cert) -> getCertificateService().findById(updateRequest.getCertificateId())).orElse(null));

        return getCompanyRepository().save(company);
    }

    @Override
    @Transactional
    public Company partialUpdateCompany(CompanyPartialUpdateRequest partialUpdateRequest) {
        Company company = findById(partialUpdateRequest.getId());

        company.setInfo(partialUpdateRequest.isSetInfoCalled() ? partialUpdateRequest.getInfo() : company.getInfo());
        company.setAddress(partialUpdateRequest.isSetAddressCalled() ? partialUpdateRequest.getAddress() : company.getAddress());
        company.setMdfeConfiguration(partialUpdateRequest.isSetMdfeConfigurationCalled() ? partialUpdateRequest.getMdfeConfiguration() : company.getMdfeConfiguration());
        company.setCteConfiguration(partialUpdateRequest.isSetCteConfigurationCalled() ? partialUpdateRequest.getCteConfiguration() : company.getCteConfiguration());
        company.setNfceConfiguration(partialUpdateRequest.isSetNfceConfigurationCalled() ? partialUpdateRequest.getNfceConfiguration() : company.getNfceConfiguration());
        company.setNfeConfiguration(partialUpdateRequest.isSetNfeConfigurationCalled() ? partialUpdateRequest.getNfeConfiguration() : company.getNfeConfiguration());
        company.setCertificate(partialUpdateRequest.isSetCertificateIdCalled() ? Optional.ofNullable(partialUpdateRequest.getCertificateId()).map((cert) -> getCertificateService().findById(partialUpdateRequest.getCertificateId())).orElse(null) : company.getCertificate());

        return getCompanyRepository().save(company);
    }
}
