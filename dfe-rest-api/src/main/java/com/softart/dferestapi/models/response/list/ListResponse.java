package com.softart.dferestapi.models.response.list;

import com.softart.dferestapi.models.certificate.CertificateDTO;
import com.softart.dferestapi.models.company.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ListResponse<T> {
    private final List<T> data;

    public final static class CompanyListResponse extends ListResponse<CompanyDTO> {
        public CompanyListResponse(List<CompanyDTO> data) {
            super(data);
        }
    }

    public final static class CertificateListResponse extends ListResponse<CertificateDTO> {
        public CertificateListResponse(List<CertificateDTO> data) {
            super(data);
        }
    }
}
