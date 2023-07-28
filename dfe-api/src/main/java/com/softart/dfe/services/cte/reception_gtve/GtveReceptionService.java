package com.softart.dfe.services.cte.reception_gtve;

import br.inf.portalfiscal.cte.send.TGTVe;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception_gtve.Gtve;
import com.softart.dfe.models.cte.reception_gtve.GtveRequest;
import com.softart.dfe.models.cte.reception_gtve.GtveReturn;

public interface GtveReceptionService extends CteSefazService {

    /**
     * A function that receives a TGTVe object and returns a GtveReturn object.
     *
     * @param tgtVe The object that will be sent to the SEFAZ.
     * @return A GtveReturn object.
     */
    default GtveReturn receptionGtve(TGTVe tgtVe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(tgtVe.getInfCte().getIde().getTpAmb());
        return GtveReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(config)
                        .receptionGtve(GtveRequest
                                .builder()
                                .config(config)
                                .signer(getXmlSigner())
                                .data(tgtVe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionGtveValidators())
                                .beforeRequest(getProcess().beforeGtve())
                                .afterRequest(getProcess().afterGtve())
                                .build()));
    }

    /**
     * It converts a Gtve object to a GtveReturn object.
     *
     * @param gtve The object that contains the data to be sent to the server.
     * @return A GtveReturn object.
     */
    default GtveReturn receptionGtve(Gtve gtve) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionGtve(gtve.toObject());
    }

    /**
     * It unmarshalls the XML and then calls the function below.
     *
     * @param xml XML string to be sent to the service.
     * @return A GtveReturn object.
     */
    default GtveReturn receptionGtve(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionGtve(CteUnmarshallerFactory.getInstance().receptionGtve(xml).getValue());
    }

}
