package com.softart.dferestapi.models.company.request;

import com.softart.dferestapi.models.fiscalconfiguration.CteConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.MdfeConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfceConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfeConfiguration;
import com.softart.dferestapi.models.info.Address;
import com.softart.dferestapi.models.info.BasicInfo;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CompanyUpdateRequest {
    private Long id;
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
