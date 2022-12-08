package com.softart.dfe.services.cte.distribution;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.cte.distribution.CteDistribution;
import com.softart.dfe.models.cte.distribution.CteDistributionRequest;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import com.softart.dfe.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCteDistributionService implements CteDistributionService {

    @Override
    public CteReturnDistribution distribution(CteDistribution cteDistribution) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return CteReturnDistribution.builder().build()
                .fromObject(
                        getProviderFactory()
                                .getCteService(getConfig())
                                .distribution(CteDistributionRequest
                                        .builder()
                                        .data(cteDistribution.toObject())
                                        .config(getConfig())
                                        .beforeRequest(getProcess().beforeDistribution())
                                        .afterRequest(getProcess().afterDistribution())
                                        .validators(getValidatorFactory().cteValidator().distributionValidators())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    @Override
    public CteReturnDistribution distributionUniqueNsu(Number nsu) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
        return distribution(CteDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .consNSU(CteDistribution.ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }

    @Override
    public CteReturnDistribution distributionUltNsu(Number nsu) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(CteDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .distNSU(CteDistribution.DistNSU.builder().ultNSU(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }
}
