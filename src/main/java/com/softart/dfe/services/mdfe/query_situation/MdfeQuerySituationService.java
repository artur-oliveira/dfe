package com.softart.dfe.services.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.query_situation.MdfeQuerySituation;
import com.softart.dfe.models.mdfe.query_situation.MdfeQuerySituationRequest;
import com.softart.dfe.models.mdfe.query_situation.MdfeReturnQuerySituation;

public interface MdfeQuerySituationService extends MdfeSefazService {

    default MdfeReturnQuerySituation querySituation(TConsSitMDFe tConsSitMDFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return MdfeReturnQuerySituation
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .querySituation(MdfeQuerySituationRequest
                                .builder()
                                .data(tConsSitMDFe)
                                .config(getConfig())
                                .signer(getXmlSigner())
                                .validators(getValidatorFactory().mdfeValidator().querySituationValidators())
                                .afterRequest(getProcess().afterQuerySituation())
                                .beforeRequest(getProcess().beforeQuerySituation())
                                .configureProvider(getConfigureProviderFactory())
                                .build()));
    }

    default MdfeReturnQuerySituation querySituation(MdfeQuerySituation queryUnclosed) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(queryUnclosed.toObject());
    }

    default MdfeReturnQuerySituation querySituation(String accessKey) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(MdfeQuerySituation.build(accessKey, getConfig()));
    }

    default Long getLastSequenceNumber(String accessKey, String eventType) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return querySituation(accessKey).getLastSequenceNumber(eventType);
    }

    default Long getLastSequenceNumber(String accessKey, MdfeEvent event) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return getLastSequenceNumber(accessKey, event.getCode());
    }

}
