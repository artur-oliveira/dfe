package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CteStorageKey implements StorageKey {
    CTE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.cte.distribution", "distDFeInt"), System.getProperty("com.softart.dfe.storage.key.cte.return_distribution", "retDistDFeInt"), null),
    CTE_EVENT(System.getProperty("com.softart.dfe.storage.key.cte.event", "eventoCTe"), System.getProperty("com.softart.dfe.storage.key.cte.return_event", "retEventoCTe"), System.getProperty("com.softart.dfe.storage.key.cte.proc_event", "procEventoCTe")),
    CTE_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.cte.inutilization", "inutCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_inutilization", "retInutCte"), System.getProperty("com.softart.dfe.storage.key.cte.proc_inutilization", "procInutCte")),
    CTE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.cte.query_receipt", "consReciCTe"), System.getProperty("com.softart.dfe.storage.key.cte.return_query_receipt", "retConsReciCTe"), null),
    CTE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.cte.query_situation", "consSitCTe"), System.getProperty("com.softart.dfe.storage.key.cte.return_query_situation", "retConsSitCTe"), null),
    CTE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.cte.reception", "enviCTe"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception", "retEnviCTe"), System.getProperty("com.softart.dfe.storage.key.cte.proc", "cteProc")),
    CTE_RECEPTION_GTVE(System.getProperty("com.softart.dfe.storage.key.cte.reception_gtve", "GTVe"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_gtve", "retGTVe"), System.getProperty("com.softart.dfe.storage.key.cte.proc_gtve", "GTVeProc")),
    CTE_RECEPTION_OS(System.getProperty("com.softart.dfe.storage.key.cte.reception_os", "CTeOS"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_os", "retCTeOS"), System.getProperty("com.softart.dfe.storage.key.cte.proc_os", "cteOSProc")),
    CTE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.cte.reception_sync", "CTe"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_sync", "retCTe"), System.getProperty("com.softart.dfe.storage.key.cte.proc", "cteProc")),
    CTE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.cte.status_service", "consStatServCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_status_service", "retConsStatServCte"), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
