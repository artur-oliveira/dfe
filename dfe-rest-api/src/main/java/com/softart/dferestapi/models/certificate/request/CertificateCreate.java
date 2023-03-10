package com.softart.dferestapi.models.certificate.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CertificateCreate {

    private byte[] bytes;
    private String password;

}
