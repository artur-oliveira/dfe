package com.softart.dfe.services.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.MdfeSefazService;
import com.softart.dfe.models.mdfe.reception.MdfeRequest;
import com.softart.dfe.models.mdfe.reception.SendMdfe;
import com.softart.dfe.models.mdfe.reception.SendMdfeReturn;
import com.softart.dfe.models.mdfe.reception_sync.Mdfe;

public interface MdfeReceptionService extends MdfeSefazService {

    /**
     * It sends the MDFe to the Sefaz.
     *
     * @param tEnviMDFe The object that contains the XML to be sent to the SEFAZ.
     * @return A SendMdfeReturn object.
     */
    default SendMdfeReturn reception(TEnviMDFe tEnviMDFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return SendMdfeReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(getConfig())
                        .reception(MdfeRequest
                                .builder()
                                .data(tEnviMDFe)
                                .signer(getXmlSigner())
                                .config(getConfig())
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().mdfeValidator().receptionValidators())
                                .afterRequest(getProcess().afterReception())
                                .beforeRequest(getProcess().beforeReception())
                                .build()));
    }

    /**
     * It receives a SendMdfe object and returns a SendMdfeReturn object
     *
     * @param sendMdfe The object that contains the data to be sent to the Sefaz.
     * @return The return is the object SendMdfeReturn, which contains the response of the SEFAZ.
     */
    default SendMdfeReturn reception(SendMdfe sendMdfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(sendMdfe.toObject());
    }

    /**
     * It receives a MDFe.
     *
     * @param tmdFe The object that contains the information of the MDF-e.
     * @return The return is a SendMdfeReturn object, which contains the following attributes:
     */
    default SendMdfeReturn reception(Mdfe tmdFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(SendMdfe.builder().mdFe(tmdFe).build());
    }

    /**
     * It receives an XML string, converts it to a Java object, and then calls the function that receives the Java object
     *
     * @param xml XML string containing the MDF-e to be sent.
     * @return The return is the object SendMdfeReturn, which is the object that contains the response from the SEFAZ.
     */
    default SendMdfeReturn reception(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return reception(MdfeUnmarshallerFactory.getInstance().sendReception(xml).getValue());
    }
}


