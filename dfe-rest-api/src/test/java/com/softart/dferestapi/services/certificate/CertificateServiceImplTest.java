package com.softart.dferestapi.services.certificate;

import com.softart.dfe.util.IOUtils;
import com.softart.dferestapi.models.certificate.Certificate;
import com.softart.dferestapi.models.certificate.request.CertificateCreate;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;


@SpringBootTest
@Getter
class CertificateServiceImplTest {

    @Autowired
    private CertificateService certificateService;

    @Test
    void create() throws IOException {

        Certificate cert = getCertificateService().create(CertificateCreate.builder()
                .bytes(IOUtils.readAllBytes(new File("/path/to/certificate.pfx")))
                .password("*")
                .build());

        Assertions.assertEquals("*", getCertificateService().findDecryptedById(cert.getId()).getDecryptedPassword());

    }
}