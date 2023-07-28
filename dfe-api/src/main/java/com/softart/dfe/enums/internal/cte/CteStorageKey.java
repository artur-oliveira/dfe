package com.softart.dfe.enums.internal.cte;

import br.inf.portalfiscal.cte.send.ObjectFactory;
import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteStorageKey implements StorageKey {
    CTE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.cte.distribution", br.inf.portalfiscal.cte.distribution.ObjectFactory._DistDFeInt_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_distribution", br.inf.portalfiscal.cte.distribution.ObjectFactory._RetDistDFeInt_QNAME.getLocalPart()), null),
    CTE_EVENT(System.getProperty("com.softart.dfe.storage.key.cte.event", ObjectFactory._EventoCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_event", ObjectFactory._RetEventoCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc_event", ObjectFactory._ProcEventoCTe_QNAME.getLocalPart())),
    CTE_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.cte.inutilization", ObjectFactory._InutCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_inutilization", ObjectFactory._RetInutCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc_inutilization", ObjectFactory._ProcInutCTe_QNAME.getLocalPart())),
    CTE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.cte.query_receipt", ObjectFactory._ConsReciCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_query_receipt", ObjectFactory._RetConsReciCTe_QNAME.getLocalPart()), null),
    CTE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.cte.query_situation", ObjectFactory._ConsSitCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_query_situation", ObjectFactory._RetConsSitCTe_QNAME.getLocalPart()), null),
    CTE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.cte.reception", ObjectFactory._EnviCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_reception", ObjectFactory._RetEnviCte_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc", ObjectFactory._CteProc_QNAME.getLocalPart())),
    CTE_RECEPTION_GTVE(System.getProperty("com.softart.dfe.storage.key.cte.reception_gtve", ObjectFactory._GTVe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_gtve", ObjectFactory._RetGTVe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc_gtve", ObjectFactory._GTVeProc_QNAME.getLocalPart())),
    CTE_RECEPTION_OS(System.getProperty("com.softart.dfe.storage.key.cte.reception_os", ObjectFactory._CTeOS_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_os", ObjectFactory._RetCTeOS_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc_os", ObjectFactory._CteOSProc_QNAME.getLocalPart())),
    CTE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.cte.reception_sync", ObjectFactory._CTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_sync", ObjectFactory._RetCTe_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.proc", ObjectFactory._CteProc_QNAME.getLocalPart())),
    CTE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.cte.status_service", ObjectFactory._ConsStatServCte_QNAME.getLocalPart()), System.getProperty("com.softart.dfe.storage.key.cte.return_status_service", ObjectFactory._RetConsStatServCte_QNAME.getLocalPart()), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
