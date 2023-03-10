package com.softart.dferestapi.models.company.request;

import com.softart.dferestapi.models.fiscalconfiguration.CteConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.MdfeConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfceConfiguration;
import com.softart.dferestapi.models.fiscalconfiguration.NfeConfiguration;
import com.softart.dferestapi.models.info.Address;
import com.softart.dferestapi.models.info.BasicInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CompanyPartialUpdateRequest {
    private Long id;
    @Valid
    private BasicInfo info;

    @Valid
    private Address address;

    @Valid
    private NfeConfiguration nfeConfiguration;

    @Valid
    private NfceConfiguration nfceConfiguration;

    @Valid
    private CteConfiguration cteConfiguration;

    @Valid
    private MdfeConfiguration mdfeConfiguration;

    private boolean setInfoCalled = false;
    private boolean setAddressCalled = false;
    private boolean setNfeConfigurationCalled = false;
    private boolean setNfceConfigurationCalled = false;
    private boolean setCteConfigurationCalled = false;
    private boolean setMdfeConfigurationCalled = false;

    public void setInfo(@Valid @NotNull BasicInfo info) {
        this.info = info;
        setSetInfoCalled(true);
    }

    public void setAddress(@Valid @NotNull Address address) {
        this.address = address;
        setSetAddressCalled(true);
    }

    public void setCteConfiguration(@Valid CteConfiguration cteConfiguration) {
        this.cteConfiguration = cteConfiguration;
        setSetCteConfigurationCalled(true);
    }

    public void setNfeConfiguration(@Valid NfeConfiguration nfeConfiguration) {
        this.nfeConfiguration = nfeConfiguration;
        setSetNfeConfigurationCalled(true);
    }

    public void setNfceConfiguration(@Valid NfceConfiguration nfceConfiguration) {
        this.nfceConfiguration = nfceConfiguration;
        setSetNfceConfigurationCalled(true);
    }

    public void setMdfeConfiguration(@Valid MdfeConfiguration mdfeConfiguration) {
        this.mdfeConfiguration = mdfeConfiguration;
        setSetMdfeConfigurationCalled(true);
    }
}
