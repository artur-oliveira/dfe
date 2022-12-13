package com.softart.dfe.services.nf.manifestation;

import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractManifestationService implements NfeManifestationService {

    @Override
    public NfeReturnManifestation confirmation(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return confirmation(accessKey, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_CONFIRMATION)));
    }

    @Override
    public NfeReturnManifestation science(Collection<String> accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(accessKey.stream().map(it -> {
            try {
                return new PairImpl<>(it, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(it, NFEvent.OPERATION_SCIENCE)));
            } catch (NoProviderFound | SecurityException | ProcessException | ValidationException |
                     SoapServiceGeneralException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()));
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
