package com.softart.dfe.enums.internal.nf;

import br.inf.portalfiscal.nfe.send.ObjectFactory;
import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NFStorageKey implements StorageKey {
    NF_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_authorization", ObjectFactory._EnviNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_authorization", ObjectFactory._RetEnviNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.proc_authorization", ObjectFactory._NfeProc_QNAME.getLocalPart())),
    NF_EVENT(System.getProperty("com.softart.dfe.storage.key.nf.send_event", br.inf.portalfiscal.nfe.event_cancel.ObjectFactory._EnvEvento_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_event", br.inf.portalfiscal.nfe.event_cancel.ObjectFactory._RetEnvEvento_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.proc_event", br.inf.portalfiscal.nfe.event_cancel.ObjectFactory._ProcEventoNFe_QNAME.getLocalPart())),
    NF_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_inutilization", ObjectFactory._InutNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_inutilization", ObjectFactory._RetInutNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.proc_inutilization", ObjectFactory._ProcInutNFe_QNAME.getLocalPart())),
    NF_RETURN_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_return_authorization", ObjectFactory._ConsReciNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_return_authorization", ObjectFactory._RetConsReciNFe_QNAME.getLocalPart()), null),
    NF_QUERY_PROTOCOL(System.getProperty("com.softart.dfe.storage.key.nf.send_query_protocol", ObjectFactory._ConsSitNFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_protocol", ObjectFactory._RetConsSitNFe_QNAME.getLocalPart()), null),
    NF_QUERY_REGISTER(System.getProperty("com.softart.dfe.storage.key.nf.send_query_register", ObjectFactory._ConsCad_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_register", ObjectFactory._RetConsCad_QNAME.getLocalPart()), null),
    NF_QUERY_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.nf.send_query_status_service", ObjectFactory._ConsStatServ_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_status_service", ObjectFactory._RetConsStatServ_QNAME.getLocalPart()), null),
    NF_QUERY_GTIN(System.getProperty("com.softart.dfe.storage.key.nf.send_query_gtin", br.inf.portalfiscal.nfe.gtin.ObjectFactory._ConsGTIN_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_gtin", br.inf.portalfiscal.nfe.gtin.ObjectFactory._RetConsGTIN_QNAME.getLocalPart()), null),
    NF_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.nf.distribution", br.inf.portalfiscal.nfe.distribution.ObjectFactory._DistDFeInt_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.nf.return_distribution", br.inf.portalfiscal.nfe.distribution.ObjectFactory._RetDistDFeInt_QNAME.getLocalPart()), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;

}
