package com.softart.dfe.services.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception.Cte;
import com.softart.dfe.models.cte.reception.CteRequest;
import com.softart.dfe.models.cte.reception.CteReturnSend;
import com.softart.dfe.models.cte.reception.CteSend;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public interface CteReceptionService extends CteSefazService {

    /**
     * It receives a CTe and sends it to the Sefaz.
     *
     * @param enviCTe The object that contains the data to be sent to the SEFAZ.
     * @return A CteReturnSend object.
     */
    default CteReturnSend reception(TEnviCTe enviCTe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(enviCTe.getCTe().stream().findFirst().map(it -> it.getInfCte().getIde().getTpAmb()).orElse(getConfig().environment().getCode()));
        return CteReturnSend
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(config)
                        .reception(CteRequest
                                .builder()
                                .config(config)
                                .signer(getXmlSigner())
                                .data(enviCTe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionCteValidators())
                                .beforeRequest(getProcess().beforeReception())
                                .afterRequest(getProcess().afterReception())
                                .build()));
    }

    /**
     * It receives a CteSend object, converts it to a CteSend object, and returns a CteReturnSend object
     *
     * @param cteSend CteSend object
     * @return The CteReturnSend object.
     */
    default CteReturnSend reception(CteSend cteSend) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(cteSend.toObject());
    }

    /**
     * Send a CTe to the Sefaz and return the response.
     *
     * @param cte Cte object with the data to be sent.
     * @return The CteReturnSend object.
     */
    default CteReturnSend reception(Cte cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(Collections.singletonList(cte));
    }

    /**
     * It receives a collection of Cte objects and returns a CteReturnSend object.
     *
     * @param cte Collection of Cte objects to be sent.
     * @return The CteReturnSend object, which contains the CteReturn object.
     */
    default CteReturnSend reception(Collection<Cte> cte) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(CteSend.builder().cTe(new ArrayList<>(cte)).build());
    }

    /**
     * This function receives a CTe XML and returns a CTeReturnSend object.
     *
     * @param xml XML string of the CTe to be sent.
     * @return The CteReturnSend object.
     */
    default CteReturnSend reception(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(CteUnmarshallerFactory.getInstance().enviCte(xml).getValue());
    }
}
