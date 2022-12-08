package com.softart.dfe.services.nf.distribution;

import com.softart.dfe.enums.nf.version.NFDistributionVersion;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.distribution.NfeDistribution;
import com.softart.dfe.models.nf.distribution.NfeDistributionRequest;
import com.softart.dfe.models.nf.distribution.NfeReturnDistribution;
import com.softart.dfe.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractNfeDistributionService implements NfeDistributionService {

    @Override
    public NfeReturnDistribution distribution(NfeDistribution nfeDistribution) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return NfeReturnDistribution.builder().build()
                .fromObject(
                        getProviderFactory()
                                .getNfeService(getConfig())
                                .distribution(NfeDistributionRequest
                                        .builder()
                                        .data(nfeDistribution.toObject())
                                        .config(getConfig())
                                        .beforeRequest(getProcess().beforeDistribution())
                                        .afterRequest(getProcess().afterDistribution())
                                        .validators(getValidatorFactory().nfeValidator().distributionValidators())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    @Override
    public NfeReturnDistribution distributionUniqueNsu(Long nsu) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
        return distribution(NfeDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .versao(NFDistributionVersion.getDefault().getVersion())
                .cufAutor(getConfig().uf().getCode())
                .consNSU(NfeDistribution.ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }

    @Override
    public NfeReturnDistribution distributionAccessKey(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(NfeDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .versao(NFDistributionVersion.getDefault().getVersion())
                .cufAutor(getConfig().uf().getCode())
                .consChNFe(NfeDistribution.ConsChNFe.builder().chNFe(accessKey).build())
                .build());
    }

    @Override
    public NfeReturnDistribution distributionUltNsu(Long nsu) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(NfeDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .versao(NFDistributionVersion.getDefault().getVersion())
                .cufAutor(getConfig().uf().getCode())
                .distNSU(NfeDistribution.DistNSU.builder().ultNSU(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }
}
