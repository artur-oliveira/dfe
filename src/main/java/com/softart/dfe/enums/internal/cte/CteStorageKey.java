package com.softart.dfe.enums.internal.cte;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.Getter;

@Getter
public enum CteStorageKey implements StorageKey {
    CTE_DISTRIBUTION(System.getProperty("STORAGE_KEY_CTE_DISTRIBUTION", "distCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_DISTRIBUTION", "retDistCte"), null),
    CTE_EVENT(System.getProperty("STORAGE_KEY_CTE_EVENT", "eventoCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_EVENT", "retEventoCte"), System.getProperty("STORAGE_KEY_CTE_PROC_EVENT", "procEventoCte")),
    CTE_INUTILIZATION(System.getProperty("STORAGE_KEY_CTE_INUTILIZATION", "inutCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_INUTILIZATION", "retInutCte"), System.getProperty("STORAGE_KEY_CTE_PROC_INUTILIZATION", "procInutCte")),
    CTE_QUERY_RECEIPT(System.getProperty("STORAGE_KEY_CTE_QUERY_RECEIPT", "consReciCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_QUERY_RECEIPT", "retConsReciCte"), null),
    CTE_QUERY_SITUATION(System.getProperty("STORAGE_KEY_CTE_QUERY_SITUATION", "consSitCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_QUERY_SITUATION", "retConsSitCte"), null),
    CTE_RECEPTION(System.getProperty("STORAGE_KEY_CTE_RECEPTION", "enviCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_RECEPTION", "retEnviCte"), System.getProperty("STORAGE_KEY_CTE_PROC", "procCte")),
    CTE_RECEPTION_GTVE(System.getProperty("STORAGE_KEY_CTE_RECEPTION_GTVE", "gtve"), System.getProperty("STORAGE_KEY_CTE_RETURN_RECEPTION_GTVE", "retGtve"), System.getProperty("STORAGE_KEY_CTE_PROC_GTVE", "procGtve")),
    CTE_RECEPTION_OS(System.getProperty("STORAGE_KEY_CTE_RECEPTION_OS", "cteOS"), System.getProperty("STORAGE_KEY_CTE_RETURN_RECEPTION_OS", "retCteOS"), System.getProperty("STORAGE_KEY_CTE_PROC_OS", "procCteOS")),
    CTE_RECEPTION_SYNC(System.getProperty("STORAGE_KEY_CTE_RECEPTION_SYNC", "cte"), System.getProperty("STORAGE_KEY_CTE_RETURN_RECEPTION_SYNC", "retCte"), System.getProperty("STORAGE_KEY_CTE_PROC", "procCte")),
    CTE_STATUS_SERVICE(System.getProperty("STORAGE_KEY_CTE_STATUS_SERVICE", "consStatServCte"), System.getProperty("STORAGE_KEY_CTE_RETURN_STATUS_SERVICE", "retConsStatServCte"), null),
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
