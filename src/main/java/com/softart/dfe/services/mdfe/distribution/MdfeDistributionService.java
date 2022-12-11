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

    default MdfeReturnDistribution distribution(MdfeDistribution distribution) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(distribution.toObject());
    }

    default MdfeReturnDistribution distributionUniqueNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistribution.distributionUniqueNsu(nsu, getConfig()));
    }

    default MdfeReturnDistribution distributionUltNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistribution.distributionUltNsu(nsu, getConfig()));
    }

}
