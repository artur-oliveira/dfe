package com.softart.dfe.services.cte.distribution;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.distribution.CteDistribution;
import com.softart.dfe.models.cte.distribution.CteDistributionRequest;
import com.softart.dfe.models.cte.distribution.CteReturnDistribution;
import com.softart.dfe.util.StringUtils;

public interface CteDistributionService extends CteSefazService {

    /**
     * A function that returns a CteReturnDistribution object.
     *
     * @param cteDistribution CteDistribution object
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distribution(CteDistribution cteDistribution) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
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

    /**
     * Search for a CTe by its unique number (NSU)
     *
     * @param nsu The unique number of the CTe.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUniqueNsu(Number nsu) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
        return distribution(CteDistribution
                .builder()
                .tpAmb(getConfig().environment().getCode())
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .consNSU(CteDistribution.ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }

    /**
     * Distribute the last CTe with the NSU number 'nsu'
     *
     * @param nsu The last NSU number received.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUltNsu(Number nsu) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
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
