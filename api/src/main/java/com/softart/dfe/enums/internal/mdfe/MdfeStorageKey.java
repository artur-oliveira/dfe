package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeStorageKey implements StorageKey {
    MDFE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.mdfe.distribution", "distMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_distribution", "retDistMDFe"), null),
    MDFE_EVENT(System.getProperty("com.softart.dfe.storage.key.mdfe.event", "eventoMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_event", "retEventoMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc_event", "procEventoMDFe")),
    MDFE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.mdfe.query_receipt", "consReciMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_receipt", "retConsReciMDFe"), null),
    MDFE_QUERY_UNCLOSED(System.getProperty("com.softart.dfe.storage.key.mdfe.query_unclosed", "consReciMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_unclosed", "retConsReciMDFe"), null),
    MDFE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.mdfe.query_situation", "consSitMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_situation", "retConsSitMDFe"), null),
    MDFE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.mdfe.reception", "enviMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception", "retEnviMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", "mdfeProc")),
    MDFE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.mdfe.reception_sync", "mdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception_sync", "retMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", "mdfeProc")),
    MDFE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.mdfe.status_service", "consStatServMDFe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_status_service", "retConsStatServMDFe"), null),
    ;

    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
