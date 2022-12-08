package com.softart.dfe.services.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TUf;
import br.inf.portalfiscal.nfe.send.TNFe;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.enums.nf.identification.NFType;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.services.NfSefazService;
import com.softart.dfe.models.nf.authorization.Nf;
import com.softart.dfe.models.nf.epec.NfeEpec;
import com.softart.dfe.models.nf.epec.ReturnNfeEpec;
import com.softart.dfe.models.nf.epec.SendNfeEpec;

public interface NfeEpecService extends NfSefazService {

    ReturnNfeEpec epec(SendNfeEpec sendNfeEpec) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException;

    default ReturnNfeEpec epec(String accessKey, NfeEpec.InfEvento.DetEvento detEvento) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(SendNfeEpec.epec(accessKey, detEvento, getConfig()));
    }

    default ReturnNfeEpec epec(String accessKey, String emissionDate, NFType type, String stateRegistration, TUf uf, String cnpj, String cpf, String foreignId, String recipientStateRegistration, String totalValue, String totalIcms, String totalIcmsSt) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        return epec(accessKey, NfeEpec.InfEvento.DetEvento.builder().dhEmi(emissionDate).tpNF(type.getCode()).cOrgaoAutor(getConfig().uf().getCode()).ie(stateRegistration).dest(NfeEpec.InfEvento.DetEvento.Dest.builder().cnpj(cnpj).uf(uf).cpf(cpf).idEstrangeiro(foreignId).ie(recipientStateRegistration).vnf(totalValue).vicms(totalIcms).vst(totalIcmsSt).build()).build());
    }


    default ReturnNfeEpec epec(Nf n) throws NoProviderFound, SecurityException, ProcessException, ValidationException, SoapServiceGeneralException {
        TNFe tnFe = n.toObject();
        return epec(AccessKeyParserFactory.nfe().fromId(tnFe.getInfNFe().getId()), n.getInfNFe().getIde().getDhEmi(), NFType.valueOfCode(n.getInfNFe().getIde().getTpNF()), n.getInfNFe().getEmit().getIe(), TUf.valueOf(n.getInfNFe().getEmit().getEnderEmit().getUf().name()), n.getInfNFe().getEmit().getCnpj(), n.getInfNFe().getEmit().getCpf(), n.getInfNFe().getDest().getIdEstrangeiro(), n.getInfNFe().getDest().getIe(), n.getInfNFe().getTotal().getIcmsTot().getVnf(), n.getInfNFe().getTotal().getIcmsTot().getVicms(), n.getInfNFe().getTotal().getIcmsTot().getVst());
    }
}
