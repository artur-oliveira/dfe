package com.softart.dferestapi.models.company;

import com.softart.dferestapi.models.fiscalconfiguration.CteConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.MdfeConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfceConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfeConfiguration;
import com.softart.dferestapi.models.info.Address;
import com.softart.dferestapi.models.info.BasicInfo;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CompanyDTO {
    private Long id;
    private Long accountId;
    private BasicInfo info;

    private Address address;

    private NfeConfiguration nfeConfiguration;

    private NfceConfiguration nfceConfiguration;

    private CteConfiguration cteConfiguration;

    private MdfeConfiguration mdfeConfiguration;

    public CompanyDTO(Company company) {
        setId(company.getId());
        setAccountId(company.getAccount().getId());
        setAddress(company.getAddress());
        setInfo(company.getInfo());
        setNfeConfiguration(company.getNfeConfiguration());
        setNfceConfiguration(company.getNfceConfiguration());
        setCteConfiguration(company.getCteConfiguration());
        setMdfeConfiguration(company.getMdfeConfiguration());
    }

}
