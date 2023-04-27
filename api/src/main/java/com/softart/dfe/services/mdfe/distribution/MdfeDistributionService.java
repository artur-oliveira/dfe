package com.softart.dfe.services.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import com.softart.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
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
    default MdfeReturnDistribution distribution(TDistDFe tDistDFeInt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(tDistDFeInt.getTpAmb());
        return MdfeReturnDistribution
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .distribution(MdfeDistributionRequest
                                .builder()
                                .data(tDistDFeInt)
                                .config(config)
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

    default MdfeReturnDistribution distribution(Number nsu, MdfeDfeSolicitation solicitation, MdfeDfeCompression compression, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistribution.build(nsu, solicitation, compression, getConfig().withEnviroment(environment)));
    }

    default MdfeReturnDistribution distribution(Number nsu, MdfeDfeSolicitation solicitation, MdfeDfeCompression compression) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(nsu, solicitation, compression, getConfig().environment());
    }

    default MdfeReturnDistribution distribution(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(nsu, MdfeDfeSolicitation.CODE_9, MdfeDfeCompression.NO, getConfig().environment());
    }

}
