package com.softart.dferestapi.models.company.request;

import com.softart.dferestapi.models.fiscalconfiguration.CteConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.MdfeConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfceConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfeConfiguration;
import com.softart.dferestapi.models.info.Address;
import com.softart.dferestapi.models.info.BasicInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CompanyRequest {

    private Long certificateId;

    @Valid
    @NotNull
    private BasicInfo info;

    @Valid
    @NotNull
    private Address address;

    @Valid
    private NfeConfiguration nfeConfiguration;

    @Valid
    private NfceConfiguration nfceConfiguration;

    @Valid
    private CteConfiguration cteConfiguration;

    @Valid
    private MdfeConfiguration mdfeConfiguration;
}
