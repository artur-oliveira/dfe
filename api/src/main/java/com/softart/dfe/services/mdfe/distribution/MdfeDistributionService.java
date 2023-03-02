package com.softart.dfe.services.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.distribution.MdfeDistribution;
import com.softart.dfe.models.mdfe.distribution.MdfeDistributionRequest;
import com.softart.dfe.models.mdfe.distribution.MdfeReturnDistribution;

public interface MdfeDistributionService extends MdfeSefazService {

    /**
     * It returns a MdfeReturnDistribution object, which is a wrapper for the response of the distribution function
     *
     * @param tDistDFeInt The object that contains the data to be sent to the distribution service.
     * @return A MdfeReturnDistribution object.
     */
    default MdfeReturnDistribution distribution(DistDFeInt tDistDFeInt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnDistribution
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .distribution(MdfeDistributionRequest
                                .builder()
                                .data(tDistDFeInt)
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().distributionValidators())
                                .afterRequest(getProcess().afterDistribution())
                                .beforeRequest(getProcess().beforeDistribution())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    /**
     * It sends a distribution request to the MDF-e webservice
     *
     * @param distribution The distribution object.
     * @return The return of the distribution.
     */
    default MdfeReturnDistribution distribution(MdfeDistribution distribution) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(distribution.toObject());
    }

    /**
     * It returns the distribution of a MDF-e by its unique number
     *
     * @param nsu The unique number of the distribution.
     * @return The return of the distribution.
     */
    default MdfeReturnDistribution distributionUniqueNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistribution.distributionUniqueNsu(nsu, getConfig()));
    }

    /**
     * Returns the distribution of the last NSU.
     *
     * @param nsu The NSU number of the distribution.
     * @return The return of the distribution is a MdfeReturnDistribution object.
     */
    default MdfeReturnDistribution distributionUltNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistribution.distributionUltNsu(nsu, getConfig()));
    }

}
