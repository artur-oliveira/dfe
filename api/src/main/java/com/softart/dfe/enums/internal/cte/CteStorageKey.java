package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.Getter;

@Getter
public enum CteStorageKey implements StorageKey {
    CTE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.cte.distribution", "distCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_distribution", "retDistCte"), null),
    CTE_EVENT(System.getProperty("com.softart.dfe.storage.key.cte.event", "eventoCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_event", "retEventoCte"), System.getProperty("com.softart.dfe.storage.key.cte.proc_event", "procEventoCte")),
    CTE_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.cte.inutilization", "inutCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_inutilization", "retInutCte"), System.getProperty("com.softart.dfe.storage.key.cte.proc_inutilization", "procInutCte")),
    CTE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.cte.query_receipt", "consReciCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_query_receipt", "retConsReciCte"), null),
    CTE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.cte.query_situation", "consSitCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_query_situation", "retConsSitCte"), null),
    CTE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.cte.reception", "enviCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception", "retEnviCte"), System.getProperty("com.softart.dfe.storage.key.cte.proc", "procCte")),
    CTE_RECEPTION_GTVE(System.getProperty("com.softart.dfe.storage.key.cte.reception_gtve", "gtve"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_gtve", "retGtve"), System.getProperty("com.softart.dfe.storage.key.cte.proc_gtve", "procGtve")),
    CTE_RECEPTION_OS(System.getProperty("com.softart.dfe.storage.key.cte.reception_os", "cteOS"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_os", "retCteOS"), System.getProperty("com.softart.dfe.storage.key.cte.proc_os", "procCteOS")),
    CTE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.cte.reception_sync", "cte"), System.getProperty("com.softart.dfe.storage.key.cte.return_reception_sync", "retCte"), System.getProperty("com.softart.dfe.storage.key.cte.proc", "procCte")),
    CTE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.cte.status_service", "consStatServCte"), System.getProperty("com.softart.dfe.storage.key.cte.return_status_service", "retConsStatServCte"), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;

    CteStorageKey(String forSend, String forReturn, String forProcessed) {
        this.forSend = forSend;
        this.forReturn = forReturn;
        this.forProcessed = forProcessed;
    }
}
