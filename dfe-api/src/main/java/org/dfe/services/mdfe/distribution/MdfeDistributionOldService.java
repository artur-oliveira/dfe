package org.dfe.services.mdfe.distribution;

import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import org.dfe.enums.internal.Environment;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.services.MdfeSefazService;
import org.dfe.models.mdfe.distribution.MdfeDistributionOld;
import org.dfe.models.mdfe.distribution.MdfeDistributionOldRequest;
import org.dfe.models.mdfe.distribution.MdfeReturnDistributionOld;
import org.dfe.util.StringUtils;

public interface MdfeDistributionOldService extends MdfeSefazService {

    /**
     * It returns a MdfeReturnDistributionOld object, which is a wrapper for the response of the distribution function
     *
     * @param tDistDFeInt The object that contains the data to be sent to the distribution service.
     * @return A MdfeReturnDistributionOld object.
     */
    default MdfeReturnDistributionOld distribution(DistDFeInt tDistDFeInt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(tDistDFeInt.getTpAmb());
        return MdfeReturnDistributionOld
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .distributionOld(MdfeDistributionOldRequest
                                .builder()
                                .data(tDistDFeInt)
                                .config(config)
                                .signer(getXmlSigner())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }


    default MdfeReturnDistributionOld distribution(MdfeDistributionOld distribution) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(distribution.toObject());
    }

    default MdfeReturnDistributionOld distributionUniqueNsu(Number nsu, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistributionOld
                .builder()
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .tpAmb(environment.getCode())
                .consNSU(MdfeDistributionOld.ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());

    }

    default MdfeReturnDistributionOld distributionUniqueNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distributionUniqueNsu(nsu, getConfig().environment());
    }

    default MdfeReturnDistributionOld distributionUltNsu(Number nsu, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distribution(MdfeDistributionOld
                .builder()
                .cnpj(getConfig().cnpj())
                .cpf(getConfig().cpf())
                .cufAutor(getConfig().uf().getCode())
                .tpAmb(environment.getCode())
                .distNSU(MdfeDistributionOld.DistNSU.builder().ultNSU(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build());
    }

    default MdfeReturnDistributionOld distributionUltNsu(Number nsu) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return distributionUltNsu(nsu, getConfig().environment());
    }

}
