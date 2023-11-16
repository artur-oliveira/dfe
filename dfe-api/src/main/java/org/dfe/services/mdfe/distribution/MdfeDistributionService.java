package org.dfe.services.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import org.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.services.MdfeSefazService;
import org.dfe.models.mdfe.distribution.MdfeDistribution;
import org.dfe.models.mdfe.distribution.MdfeDistributionRequest;
import org.dfe.models.mdfe.distribution.MdfeReturnDistribution;

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
