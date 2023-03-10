package com.softart.dferestapi.services.certificate;

import com.softart.dferestapi.models.certificate.Certificate;
import com.softart.dferestapi.models.certificate.request.CertificateCreate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CertificateService {
    Certificate create(CertificateCreate certificateCreate);

    Certificate findById(Long id);

    List<Certificate> findAll();

    Certificate findDecryptedById(Long id);

    Certificate delete(Long id);
}
