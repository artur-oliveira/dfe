package com.softart.dfe.services.nf.manifestation;

import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.manifestation.NfeManifestationRequest;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.models.nf.manifestation.NfeSendManifestation;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;

public abstract class AbstractManifestationService implements NfeManifestationService {

    @Override
    public NfeReturnManifestation manifestation(NfeSendManifestation manifestation) throws NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException {
        return NfeReturnManifestation
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getNfeService(getConfig())
                        .manifestation(NfeManifestationRequest
                                .builder()
                                .signer(getXmlSigner())
                                .config(getConfig())
                                .data(manifestation.toObject())
                                .validators(getValidatorFactory().nfeValidator().manifestationValidators())
                                .configureProvider(getConfigureProviderFactory())
                                .afterRequest(getProcess().afterManifestation())
                                .beforeRequest(getProcess().beforeManifestation())
                                .build())
                        .second());
    }

    @Override
    public NfeReturnManifestation confirmation(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationConfirmation(accessKey, nseq, getConfig()));
    }

    @Override
    public NfeReturnManifestation science(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationScience(accessKey, nseq, getConfig()));
    }

    @Override
    public NfeReturnManifestation ignorance(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationIgnorance(accessKey, nseq, motive, getConfig()));
    }

    @Override
    public NfeReturnManifestation notPerformed(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationNotPerformed(accessKey, nseq, motive, getConfig()));
    }

    @Override
    public NfeReturnManifestation confirmation(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return confirmation(accessKey, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_CONFIRMATION)));
    }

    @Override
    public NfeReturnManifestation science(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(accessKey, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_SCIENCE)));
    }

    @Override
    public NfeReturnManifestation ignorance(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return ignorance(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_IGNORANCE)));
    }

    @Override
    public NfeReturnManifestation notPerformed(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return notPerformed(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_NOT_PERFORMED)));
    }

    protected abstract NfQueryProtocolService getNfeQueryProtocolService();
}
