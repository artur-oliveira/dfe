package org.dfe.services.mdfe.reception;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import org.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.services.MdfeSefazService;
import org.dfe.models.mdfe.reception.MdfeRequest;
import org.dfe.models.mdfe.reception.SendMdfe;
import org.dfe.models.mdfe.reception.SendMdfeReturn;
import org.dfe.models.mdfe.reception_sync.Mdfe;

public interface MdfeReceptionService extends MdfeSefazService {

    /**
     * It sends the MDFe to the Sefaz.
     *
     * @param tEnviMDFe The object that contains the XML to be sent to the SEFAZ.
     * @return A SendMdfeReturn object.
     */
    default SendMdfeReturn reception(TEnviMDFe tEnviMDFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(tEnviMDFe.getMDFe().getInfMDFe().getIde().getTpAmb());

        return SendMdfeReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .reception(MdfeRequest
                                .builder()
                                .data(tEnviMDFe)
                                .signer(getXmlSigner())
                                .config(config)
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


