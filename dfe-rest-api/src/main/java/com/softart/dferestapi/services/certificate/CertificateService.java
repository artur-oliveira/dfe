package com.softart.dferestapi.services.certificate;

import com.softart.dferestapi.models.certificate.Certificate;
import com.softart.dferestapi.models.certificate.request.CertificateCreate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CertificateService {
    Certificate create(CertificateCreate certificateCreate);

    Certificate findById(Long id);

    List<Certificate> findAll();

    @Transactional(readOnly = true)
    default Certificate findDecryptedById(Long id) {
        return decrypt(findById(id));
    }

    Certificate decrypt(Certificate certificate);

    @SuppressWarnings("all")
    Certificate delete(Long id);
}
