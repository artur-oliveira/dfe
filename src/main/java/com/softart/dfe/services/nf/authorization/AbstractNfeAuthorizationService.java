package com.softart.dfe.services.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.NFSend;
import com.softart.dfe.enums.nf.version.NFVersion;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.sefaz.nf.common.NfCommonService;
import com.softart.dfe.interfaces.validation.nf.common.NfCommonValidator;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.util.StringUtils;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractNfeAuthorizationService implements NfAuthorizationService {

    @Override
    public TEnviNFe getEnviNfe(Collection<Nf> nfs) throws ProcessException {
        TEnviNFe tEnviNFe = new br.inf.portalfiscal.nfe.send.ObjectFactory().createTEnviNFe();
        tEnviNFe.setVersao(NFVersion.getDefault().getVersion());
        tEnviNFe.setIdLote(StringUtils.random());
        tEnviNFe.setIndSinc(getConfig().send().getCode());

        // NF-e em São Paulo e Bahia, são assíncronas
        if ((nfs.stream().anyMatch(Nf::isNfe) && (getConfig().uf().equals(UF.SP) || getConfig().uf().equals(UF.BA))) || nfs.size() > 1) {
            tEnviNFe.setIndSinc(NFSend.ASYNC.getCode());
        }

        tEnviNFe.getNFe().addAll(nfs.stream().map(XMLAdapter::toObject).collect(Collectors.toList()));

        return tEnviNFe;
    }

    @Override
    public NfCommonService getService() throws NoProviderFound, SoapServiceGeneralException {
        return getProviderFactory().getNfeService(getConfig());
    }

    @Override
    public NfCommonValidator getValidator() {
        return getValidatorFactory().nfeValidator();
    }
}
