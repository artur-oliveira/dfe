package com.softart.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.internal.nf.QrCodeNfceURL;
import com.softart.dfe.enums.internal.nf.QueryNfceURL;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.models.nf.authorization.Nf;

import java.util.Collection;

public abstract class AbstractNfceAuthorizationService extends AbstractNfeAuthorizationService {

    @Override
    public TEnviNFe getEnviNfe(Collection<Nf> nfs) throws ProcessException {
        for (Nf nf : nfs) {
            if (nf.isNfce()) {
                try {
                    nf.setInfNFeSupl(Nf.InfNFeSupl
                            .builder()
                            .urlChave(QueryNfceURL.get(UF.valueOfNf(nf), Environment.valueOfNf(nf)))
                            .qrCode(QrCodeNfceURL.generate(nf, getConfig(), getXmlSigner()))
                            .build());
                } catch (Exception e) {
                    throw new ProcessException(e);
                }
            }
        }

        return super.getEnviNfe(nfs);
    }

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfceService(getConfig());
    }

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfceValidator();
    }
}
