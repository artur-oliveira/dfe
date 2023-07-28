package com.softart.dfe.services.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.manifestation.NfeManifestationRequest;
import com.softart.dfe.models.nf.manifestation.NfeReturnManifestation;
import com.softart.dfe.models.nf.manifestation.NfeSendManifestation;
import com.softart.dfe.services.nf.query_protocol.NfQueryProtocolService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface NfeManifestationService extends NfSefazService {

    /**
     * A function that returns the NfeReturnManifestation object, which is the object that contains the response of the
     * manifestation of the event.
     *
     * @param evento The event object to be sent to the SEFAZ.
     * @return The return is a NfeReturnManifestation object, which is a wrapper for the return of the webservice.
     */
    default NfeReturnManifestation manifestation(TEnvEvento evento) throws NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException {
        NfeConfig config = getConfig().withEnviroment(evento.getEvento().stream().findFirst().map(it -> it.getInfEvento().getTpAmb()).orElse(getConfig().environment().getCode()));

        return NfeReturnManifestation
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getNfeService(config)
                        .manifestation(NfeManifestationRequest
                                .builder()
                                .signer(getXmlSigner())
                                .config(config)
                                .data(evento)
                                .validators(getValidatorFactory().nfeValidator().manifestationValidators())
                                .configureProvider(getConfigureProviderFactory())
                                .afterRequest(getProcess().afterManifestation())
                                .beforeRequest(getProcess().beforeManifestation())
                                .build())
                        .second());
    }

    /**
     * It sends a manifestation to the Sefaz
     *
     * @param manifestation Manifestation object
     * @return The return of the manifestation.
     */
    default NfeReturnManifestation manifestation(NfeSendManifestation manifestation) throws NoProviderFound, ProcessException, ValidationException, SecurityException, SoapServiceGeneralException {
        return manifestation(manifestation.toObject());
    }

    /**
     * Confirm the receipt of the event.
     *
     * @param accessKey The access key of the NF-e.
     * @param nseq      The sequence number of the event.
     * @return The return is the object NfeReturnManifestation, which contains the following attributes:
     */
    default NfeReturnManifestation confirmation(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationConfirmation(accessKey, nseq, getConfig()));
    }

    /**
     * This function sends a science manifestation to the Sefaz.
     *
     * @param pair Pair<String, String>
     * @return The return of the method is the object NfeReturnManifestation, which contains the return of the operation.
     */
    default NfeReturnManifestation science(List<Pair<String, String>> pair) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationScience(pair, getConfig()));
    }

    default NfeReturnManifestation science(Pair<String, String> pair) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(Collections.singletonList(pair));
    }

    /**
     * It returns a NfeReturnManifestation object.
     *
     * @param accessKey The access key of the company that will be used to make the request.
     * @param nseq      The sequence number of the NF-e.
     * @return The return is a NfeReturnManifestation object.
     */
    default NfeReturnManifestation science(String accessKey, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(new PairImpl<>(accessKey, nseq));
    }

    /**
     * Ignore the event with the access key and sequence number, and the reason for the ignorance is the motive.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the cancellation.
     * @param nseq      The number of the NF-e to be manifested.
     * @return The return is the object NfeReturnManifestation, which contains the following attributes:
     */
    default NfeReturnManifestation ignorance(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationIgnorance(accessKey, nseq, motive, getConfig()));
    }

    /**
     * This function sends a message to the Sefaz informing that the operation was not performed.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the cancellation.
     * @param nseq      The sequence number of the NF-e.
     * @return The return is the object NfeReturnManifestation, which contains the return of the SEFAZ.
     */
    default NfeReturnManifestation notPerformed(String accessKey, String motive, String nseq) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return manifestation(NfeSendManifestation.operationNotPerformed(accessKey, nseq, motive, getConfig()));
    }

    /**
     * Confirms the receipt of the event of the Manifestation of the Interested Party
     *
     * @param accessKey The access key of the NF-e to be confirmed.
     * @return The return is a NfeReturnManifestation object.
     */
    default NfeReturnManifestation confirmation(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return confirmation(accessKey, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_CONFIRMATION)));
    }

    /**
     * It returns the status of the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @return The return is a object of type NfeReturnManifestation.
     */
    default NfeReturnManifestation science(String accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(Collections.singletonList(accessKey));
    }

    /**
     * It returns a NfeReturnManifestation object.
     *
     * @param accessKey Collection of access keys to be sent to the Sefaz.
     * @return The return is a collection of objects of type NfeReturnManifestation.
     */
    default NfeReturnManifestation science(Collection<String> accessKey) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return science(accessKey.stream().map(it -> {
            try {
                return new PairImpl<>(it, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(it, NFEvent.OPERATION_SCIENCE)));
            } catch (NoProviderFound | SecurityException | ProcessException | ValidationException |
                     SoapServiceGeneralException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()));
    }

    /**
     * It returns the ignorance of the NF-e.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the ignorance.
     * @return The return is a object of type NfeReturnManifestation.
     */
    default NfeReturnManifestation ignorance(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return ignorance(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_IGNORANCE)));
    }

    /**
     * It cancels the manifest.
     *
     * @param accessKey The access key of the NF-e.
     * @param motive    The reason for the rejection of the event.
     * @return The return is a NfeReturnManifestation object.
     */
    default NfeReturnManifestation notPerformed(String accessKey, String motive) throws ProcessException, ValidationException, NoProviderFound, SecurityException, SoapServiceGeneralException {
        return notPerformed(accessKey, motive, String.valueOf(getNfeQueryProtocolService().getLastSequenceNumber(accessKey, NFEvent.OPERATION_NOT_PERFORMED)));
    }

    NfQueryProtocolService getNfeQueryProtocolService();

    @Override
    NfeConfig getConfig();
}
