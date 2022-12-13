package com.softart.dfe.services.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import com.softart.dfe.enums.nf.version.NFDistributionVersion;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.distribution.NfeDistribution;
import com.softart.dfe.models.nf.distribution.NfeDistributionRequest;
import com.softart.dfe.models.nf.distribution.NfeReturnDistribution;
import com.softart.dfe.util.StringUtils;

public interface NfeDistributionService extends NfSefazService {

    /**
     * A function that receives a parameter of type TDistDFeInt and returns a NfeReturnDistribution object.
     *
     * @param tDistDFeInt The object that contains the parameters for the distribution request.
     * @return A NfeReturnDistribution object.
     */
    default NfeReturnDistribution distribution(TDistDFeInt tDistDFeInt) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return NfeReturnDistribution.builder().build()
                .fromObject(
                        getProviderFactory()
                                .getNfeService(getConfig())
                                .distribution(NfeDistributionRequest
                                        .builder()
                                        .data(tDistDFeInt)
                                        .config(getConfig())
                                        .beforeRequest(getProcess().beforeDistribution())
                                        .afterRequest(getProcess().afterDistribution())
                                        .validators(getValidatorFactory().nfeValidator().distributionValidators())
                                        .configureProvider(getConfigureProviderFactory())
                                        .build())
                                .second()
                );
    }

    /**
     * It sends a distribution request to the NFe server
     *
     * @param nfeDistribution NfeDistribution object
     * @return The return of the distribution method is a NfeReturnDistribution object.
     */
    default NfeReturnDistribution distribution(NfeDistribution nfeDistribution) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return distribution(nfeDistribution.toObject());
    }

    /**
     * Distribute a unique NSU number
     *
     * @param nsu Unique number of the NF-e
     * @return The return of the distribution is a NfeReturnDistribution object, which contains the following attributes:
     */
    default NfeReturnDistribution distributionUniqueNsu(Long nsu) throws ValidationException, NoProviderFound, SecurityException, ProcessException, SoapServiceGeneralException {
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

    /**
     * Distribute the NFe with the access key.
     *
     * @param accessKey The access key of the NF-e to be consulted.
     * @return The NfeReturnDistribution object.
     */
    default NfeReturnDistribution distributionAccessKey(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
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

    /**
     * It returns the distribution of the last NSU.
     *
     * @param nsu The last NSU number received.
     * @return The return of the distribution is a NfeReturnDistribution object, which contains the following attributes:
     */
    default NfeReturnDistribution distributionUltNsu(Long nsu) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
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
