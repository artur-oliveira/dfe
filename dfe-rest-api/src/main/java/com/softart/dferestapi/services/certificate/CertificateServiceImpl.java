package com.softart.dferestapi.services.certificate;

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
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

@Service
@Getter
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;
    private final AccountService accountService;
    private final EncryptService encryptService;

    @Autowired
    public CertificateServiceImpl(CertificateRepository certificateRepository, AccountService accountService, EncryptService encryptService) {
        this.certificateRepository = certificateRepository;
        this.accountService = accountService;
        this.encryptService = encryptService;
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
            KeyStore keyStore = KeyStore.getInstance(KeyType.PFX.getType());
            keyStore.load(is, certificateCreate.getPassword().toCharArray());
            String alias = keyStore.aliases().nextElement();
            X509Certificate certificate = (X509Certificate) keyStore.getCertificate(alias);
            String subject = Arrays.stream(certificate.getSubjectDN().toString().split(",")).findFirst().orElse(alias);

            String salt = getEncryptService().generateSalt();

            return getCertificateRepository().save(
                    Certificate
                            .builder()
                            .alias(alias)
                            .md5(md5)
                            .subject(subject)
                            .password(getEncryptService().encrypt(certificateCreate.getPassword(), salt))
                            .salt(salt)
                            .expiresAt(certificate.getNotAfter())
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
    @Transactional(readOnly = true)
    public Certificate findDecryptedById(Long id) {
        Certificate certificate = findById(id);

        certificate.setDecryptedPassword(getEncryptService().decrypt(certificate.getPassword(), certificate.getSalt()));

        return certificate;
    }

    @Override
    @Transactional
    public Certificate delete(Long id) {
        Certificate certificate = findById(id);
        getCertificateRepository().delete(findById(id));
        return certificate;
    }
}
