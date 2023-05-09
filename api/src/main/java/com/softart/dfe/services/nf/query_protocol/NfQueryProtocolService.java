package com.softart.dfe.services.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TNfeProc;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.query_protocol.QueryProtocolNfe;
import com.softart.dfe.models.nf.query_protocol.QueryProtocolRequest;
import com.softart.dfe.models.nf.query_protocol.ReturnQueryProtocolNfe;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public interface NfQueryProtocolService extends NfSefazService {

    /**
     * It queries the protocol of the NFe.
     *
     * @param accessKey The access key of the NF-e.
     * @return A ReturnQueryProtocolNfe object.
     */
    default ReturnQueryProtocolNfe queryProtocol(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryProtocol(accessKey, getConfig().environment());
    }

    default ReturnQueryProtocolNfe queryProtocol(String accessKey, Environment environment) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return ReturnQueryProtocolNfe
                .builder()
                .build()
                .fromObject(getService(environment)
                        .queryProtocol(QueryProtocolRequest
                                .builder()
                                .data(QueryProtocolNfe.builder().chNFe(accessKey).tpAmb(environment.getCode()).build().toObject())
                                .validators(getValidator().queryProtocolValidators())
                                .afterRequest(getProcess().afterQueryProtocol())
                                .beforeRequest(getProcess().beforeQueryProtocol())
                                .config(getConfig().withEnviroment(environment))
                                .configureProvider(getConfigureProviderFactory())
                                .build())
                        .second());
    }

    /**
     * It takes a list of NFe's, queries the protocol for each one, and returns a list of TNfeProc's
     *
     * @param sendNf The object that contains the NF-e to be sent.
     * @return A collection of TNfeProc objects.
     */
    default Collection<TNfeProc> getProcessed(TEnviNFe sendNf) {
        return sendNf.getNFe().stream().map(it -> {
            try {
                TNfeProc tNfeProc = new TNfeProc();
                tNfeProc.setNFe(it);
                tNfeProc.setVersao(it.getInfNFe().getVersao());
                tNfeProc.setProtNFe(queryProtocol(AccessKeyParserFactory.nfe().fromId(it.getInfNFe().getId())).getProtNFe().toObject());
                return tNfeProc;
            } catch (NoProviderFound | SecurityException | ProcessException | ValidationException |
                     SoapServiceGeneralException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    /**
     * It takes a string and returns a collection of TNfeProc objects.
     *
     * @param sendNf XML of the NF-e to be sent.
     * @return A collection of TNfeProc objects.
     */
    default Collection<TNfeProc> getProcessed(String sendNf) {
        return getProcessed(NfUnmarshallerFactory.getInstance().enviNfe(sendNf).getValue());
    }


    /**
     * This function returns a service object that can be used to make calls to the NfCommonService
     *
     * @param environment The environment you want to connect to.
     * @return A service object that can be used to call the service.
     */
    NfCommonService getService(Environment environment) throws NoProviderFound, SoapServiceGeneralException;

    /**
     * Returns the validator used by this class
     *
     * @return The validator object.
     */
    NfCommonValidator getValidator();

    /**
     * This function returns the last sequence number for the given event type
     *
     * @param accessKey The access key for the account.
     * @param eventType The event type you want to get the last sequence number for.
     * @return The last sequence number for the given event type.
     */
    default Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryProtocol(accessKey)
                .getProcEventoNFe()
                .stream()
                .filter(it -> Objects.equals(eventType, it.getEvento().getInfEvento().getTpEvento()))
                .map(it -> Long.valueOf(it.getEvento().getInfEvento().getNSeqEvento()))
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1L;
    }

    /**
     * Get the last sequence number for a given event type
     *
     * @param accessKey The access key of the user who is making the request.
     * @param event     The event code for which you want to get the last sequence number.
     * @return The last sequence number for the given event.
     */
    default Long getLastSequenceNumber(String accessKey, NFEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }
}
