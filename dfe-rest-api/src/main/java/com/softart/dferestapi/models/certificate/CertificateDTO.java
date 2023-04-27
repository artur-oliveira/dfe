package com.softart.dferestapi.models.certificate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CertificateDTO {
    private Long id;
    private String alias;
    private String subject;
    private String md5;
    private Date expiresAt;
    private Date createdAt;
    private Date updatedAt;

    public CertificateDTO(final Certificate certificate) {
        setId(certificate.getId());
        setAlias(certificate.getAlias());
        setSubject(certificate.getSubject());
        setMd5(certificate.getMd5());
        setExpiresAt(certificate.getExpiresAt());
        setCreatedAt(certificate.getCreatedAt());
        setUpdatedAt(certificate.getUpdatedAt());
    }
}
