package com.softart.dferestapi.services.certificate;

import com.softart.dfe.components.security.keystore.KeyStoreParserFactory;
import com.softart.dfe.enums.internal.KeyType;
import com.softart.dfe.util.HashUtils;
import com.softart.dfe.util.InputStreamUtils;
import com.softart.dferestapi.exceptions.entity.EntityAlreadyExistsException;
import com.softart.dferestapi.exceptions.entity.EntityNotFoundException;
import com.softart.dferestapi.models.auth.Account;
import com.softart.dferestapi.models.certificate.Certificate;
import com.softart.dferestapi.models.certificate.request.CertificateCreate;
import com.softart.dferestapi.repository.CertificateRepository;
import com.softart.dferestapi.services.auth.AccountService;
import com.softart.dferestapi.services.encrypt.EncryptService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;

@Service
@Getter
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final AccountService accountService;
    private final EncryptService encryptService;
    private final KeyStoreService keyStoreService;

    @Autowired
    public CertificateServiceImpl(
            CertificateRepository certificateRepository,
            AccountService accountService,
            EncryptService encryptService,
            KeyStoreService keyStoreService
    ) {
        this.certificateRepository = certificateRepository;
        this.accountService = accountService;
        this.encryptService = encryptService;
        this.keyStoreService = keyStoreService;
    }


    @Override
    @SneakyThrows
    @Transactional
    public Certificate create(CertificateCreate certificateCreate) {
        Account account = getAccountService().getLoggedAccount();
        String md5 = HashUtils.md5(certificateCreate.getBytes());
        getCertificateRepository().findByAccountAndMd5(account, md5).ifPresent((certificate) -> {
            throw new EntityAlreadyExistsException(certificate.getId());
        });

        try (InputStream is = InputStreamUtils.newByteArrayInputStream(certificateCreate.getBytes())) {

            KeyStore ks = KeyStoreParserFactory.getInstance().read(is, KeyType.PFX.getType(), certificateCreate.getPassword());
            String alias = KeyStoreParserFactory.getInstance().getAlias(ks);
            String subject = KeyStoreParserFactory.getInstance().getSubject(ks);
            Date notAfter = KeyStoreParserFactory.getInstance().getExpiration(ks);
            String salt = getEncryptService().generateSalt();

            getKeyStoreService().addKeyStore(md5, certificateCreate.getBytes());

            return getCertificateRepository().save(
                    Certificate
                            .builder()
                            .alias(alias)
                            .md5(md5)
                            .subject(subject)
                            .password(getEncryptService().encrypt(certificateCreate.getPassword(), salt))
                            .salt(salt)
                            .expiresAt(notAfter)
                            .account(account)
                            .build()
            );
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Certificate findById(Long id) {
        return getCertificateRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<Certificate> findAll() {
        return getCertificateRepository().findAllByAccount(getAccountService().getLoggedAccount());
    }

    @Override
    public Certificate decrypt(Certificate certificate) {
        return certificate.decrypt(getEncryptService());
    }

    @Override
    @Transactional
    public Certificate delete(Long id) {
        Certificate certificate = findById(id);
        getCertificateRepository().delete(findById(id));
        return certificate;
    }
}
