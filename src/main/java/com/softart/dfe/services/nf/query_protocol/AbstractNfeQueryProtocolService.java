package com.softart.dfe.services.nf.query_protocol;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractNfeQueryProtocolService implements NfQueryProtocolService {

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig());
    }

    @Override
    public Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return queryProtocol(accessKey)
                .getProcEventoNFe()
                .stream()
                .filter(it -> Objects.equals(eventType, it.getEvento().getInfEvento().getTpEvento()))
                .map(it -> Long.valueOf(it.getEvento().getInfEvento().getNSeqEvento()))
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1L;
    }
}
