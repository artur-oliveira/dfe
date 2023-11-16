package org.dfe.services.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TGTVe;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.services.Cte4SefazService;
import org.dfe.models.cte4.reception_gtve.Gtve;
import org.dfe.models.cte4.reception_gtve.GtveRequest;
import org.dfe.models.cte4.reception_gtve.GtveReturn;

public interface GtveReceptionService extends Cte4SefazService {

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
                        .getCte4Service(config)
                        .receptionGtve(GtveRequest
                                .builder()
                                .config(config)
                                .signer(getXmlSigner())
                                .data(tgtVe)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cte4Validator().receptionGtveValidators())
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
        return receptionGtve(CteUnmarshallerFactory.getInstance().receptionGtve400(xml).getValue());
    }

}
