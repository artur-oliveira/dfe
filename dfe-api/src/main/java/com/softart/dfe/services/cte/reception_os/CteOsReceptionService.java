package com.softart.dfe.services.cte.reception_os;

import br.inf.portalfiscal.cte.send.TCTeOS;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.services.CteSefazService;
import com.softart.dfe.models.cte.reception_os.CteOs;
import com.softart.dfe.models.cte.reception_os.CteOsRequest;
import com.softart.dfe.models.cte.reception_os.CteOsReturn;

public interface CteOsReceptionService extends CteSefazService {

    /**
     * It receives a CTeOS object and returns a CTeOSReturn object.
     *
     * @param tcTeOS The object that contains the data to be sent to the SEFAZ.
     * @return A CteOsReturn object.
     */
    default CteOsReturn receptionOs(TCTeOS tcTeOS) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        CteConfig config = getConfig().withEnviroment(tcTeOS.getInfCte().getIde().getTpAmb());
        return CteOsReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getCteService(config)
                        .receptionOs(CteOsRequest
                                .builder()
                                .config(config)
                                .signer(getXmlSigner())
                                .data(tcTeOS)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().cteValidator().receptionCteOsValidators())
                                .beforeRequest(getProcess().beforeCteOs())
                                .afterRequest(getProcess().afterCteOs())
                                .build()));
    }

    /**
     * It converts the CteOs object to a CteOsReturn object.
     *
     * @param cteOs The CteOs object that will be sent to the SEFAZ.
     * @return The return is a CteOsReturn object.
     */
    default CteOsReturn receptionOs(CteOs cteOs) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionOs(cteOs.toObject());
    }

    /**
     * It receives a XML string and returns a CteOsReturn object.
     *
     * @param xml XML string containing the OS to be sent.
     * @return The CteOsReturn object.
     */
    default CteOsReturn receptionOs(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionOs(CteUnmarshallerFactory.getInstance().receptionCteOs(xml).getValue());
    }

}
