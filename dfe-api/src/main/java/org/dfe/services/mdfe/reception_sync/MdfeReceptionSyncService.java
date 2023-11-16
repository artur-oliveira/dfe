package org.dfe.services.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import org.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.services.MdfeSefazService;
import org.dfe.models.mdfe.reception_sync.Mdfe;
import org.dfe.models.mdfe.reception_sync.MdfeReturn;
import org.dfe.models.mdfe.reception_sync.MdfeSyncRequest;

public interface MdfeReceptionSyncService extends MdfeSefazService {

    /**
     * It receives a TMDFe object and returns a MdfeReturn object.
     *
     * @param tmdFe The object that contains the data to be sent to the SEFAZ.
     * @return A MdfeReturn object.
     */
    default MdfeReturn receptionSync(TMDFe tmdFe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        MdfeConfig config = getConfig().withEnviroment(tmdFe.getInfMDFe().getIde().getTpAmb());
        return MdfeReturn
                .builder()
                .build()
                .fromObject(getProviderFactory()
                        .getMdfeService(config)
                        .receptionSync(MdfeSyncRequest
                                .builder()
                                .data(tmdFe)
                                .signer(getXmlSigner())
                                .config(config)
                                .configureProvider(getConfigureProviderFactory())
                                .validators(getValidatorFactory().mdfeValidator().receptionSyncValidators())
                                .afterRequest(getProcess().afterReceptionSync())
                                .beforeRequest(getProcess().beforeReceptionSync())
                                .build()));
    }

    /**
     * It converts the Mdfe object to a MdfeObject object and then calls the function receptionSync(MdfeObject tmdFe)
     *
     * @param mdfe The object that contains the data to be sent to the SEFAZ.
     * @return The return is the object MdfeReturn, which contains the response of the webservice.
     */
    default MdfeReturn receptionSync(Mdfe mdfe) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(Mdfe.build(mdfe, getConfig(), getXmlSigner()).toObject());
    }

    default MdfeReturn receptionSync(String xml) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return receptionSync(Mdfe.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().sendReceptionSync(xml).getValue()));
    }
}


