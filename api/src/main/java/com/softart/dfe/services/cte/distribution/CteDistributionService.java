package com.softart.dfe.services.cte.distribution;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
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
    default CteReturnDistribution distribution(CteDistribution cteDistribution, Environment environment) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(environment);
        return CteReturnDistribution.builder().build()
                .fromObject(
                        getProviderFactory()
                                .getCteService(config)
                                .distribution(CteDistributionRequest
                                        .builder()
                                        .data(cteDistribution.toObject())
                                        .config(config)
                                        .beforeRequest(getProcess().beforeDistribution())
                                        .afterRequest(getProcess().afterDistribution())
                                        .validators(getValidatorFactory().cteValidator().distributionValidators())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    /**
     * It sends a CteDistribution object to the webservice and returns a CteReturnDistribution object
     *
     * @param cteDistribution The CteDistribution object that contains the data to be sent to the webservice.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distribution(CteDistribution cteDistribution) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(cteDistribution, getConfig().environment());
    }

    /**
     * It returns the distribution of a unique NSU
     *
     * @param nsu         The NSU number of the CTe to be consulted.
     * @param environment Environment.HOMOLOGATION or Environment.PRODUCTION
     * @return The return of the distribution method is a CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUniqueNsu(Number nsu, Environment environment) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
        return distribution(CteDistribution
                .builder()
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .tpAmb(environment.getCode())
                .consNSU(CteDistribution.ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build(), environment);

    }

    /**
     * Returns the distribution of the last NSU.
     *
     * @param nsu         The last NSU number that you have received.
     * @param environment The environment you want to use.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUltNsu(Number nsu, Environment environment) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(CteDistribution
                .builder()
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .tpAmb(environment.getCode())
                .distNSU(CteDistribution.DistNSU.builder().ultNSU(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build(), environment);
    }


    /**
     * It returns the distribution of a unique NSU.
     *
     * @param nsu The NSU number of the CTe.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUniqueNsu(Number nsu) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
        return distributionUniqueNsu(nsu, getConfig().environment());
    }

    /**
     * Returns the distribution of the last NSU
     *
     * @param nsu The NSU number of the CTe.
     * @return A CteReturnDistribution object.
     */
    default CteReturnDistribution distributionUltNsu(Number nsu) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distributionUltNsu(nsu, getConfig().environment());
    }
}
