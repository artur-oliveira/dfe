package com.softart.dfe.enums.internal.mdfe;

import br.inf.portalfiscal.mdfe.classes.ObjectFactory;
import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeStorageKey implements StorageKey {
    MDFE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.mdfe.distribution", br.inf.portalfiscal.mdfe.distribution.ObjectFactory._DistDFeInt_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_distribution", br.inf.portalfiscal.mdfe.distribution.ObjectFactory._RetDistDFeInt_QNAME.getLocalPart()), null),
    MDFE_EVENT(System.getProperty("com.softart.dfe.storage.key.mdfe.event", ObjectFactory._EventoMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_event", ObjectFactory._RetEventoMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.proc_event", ObjectFactory._ProcEventoMDFe_QNAME.getLocalPart())),
    MDFE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.mdfe.query_receipt", ObjectFactory._ConsReciMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_receipt", ObjectFactory._RetConsReciMDFe_QNAME.getLocalPart()), null),
    MDFE_QUERY_UNCLOSED(System.getProperty("com.softart.dfe.storage.key.mdfe.query_unclosed", ObjectFactory._ConsMDFeNaoEnc_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_unclosed", ObjectFactory._RetConsMDFeNaoEnc_QNAME.getLocalPart()), null),
    MDFE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.mdfe.query_situation", ObjectFactory._ConsSitMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_situation", ObjectFactory._RetConsSitMDFe_QNAME.getLocalPart()), null),
    MDFE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.mdfe.reception", ObjectFactory._EnviMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception", ObjectFactory._RetEnviMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", ObjectFactory._MdfeProc_QNAME.getLocalPart())),
    MDFE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.mdfe.reception_sync", ObjectFactory._MDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception_sync", ObjectFactory._RetMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", ObjectFactory._MdfeProc_QNAME.getLocalPart())),
    MDFE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.mdfe.status_service", ObjectFactory._ConsStatServMDFe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.mdfe.return_status_service", ObjectFactory._RetConsStatServMDFe_QNAME.getLocalPart()), null),
    ;

    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
