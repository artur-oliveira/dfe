package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeStorageKey implements StorageKey {
    MDFE_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.mdfe.distribution", "distMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_distribution", "retDistMdfe"), null),
    MDFE_EVENT(System.getProperty("com.softart.dfe.storage.key.mdfe.event", "eventoMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_event", "retEventoMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc_event", "procEventoMdfe")),
    MDFE_QUERY_RECEIPT(System.getProperty("com.softart.dfe.storage.key.mdfe.query_receipt", "consReciMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_receipt", "retConsReciMdfe"), null),
    MDFE_QUERY_UNCLOSED(System.getProperty("com.softart.dfe.storage.key.mdfe.query_unclosed", "consReciMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_unclosed", "retConsReciMdfe"), null),
    MDFE_QUERY_SITUATION(System.getProperty("com.softart.dfe.storage.key.mdfe.query_situation", "consSitMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_query_situation", "retConsSitMdfe"), null),
    MDFE_RECEPTION(System.getProperty("com.softart.dfe.storage.key.mdfe.reception", "enviMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception", "retEnviMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", "procMdfe")),
    MDFE_RECEPTION_SYNC(System.getProperty("com.softart.dfe.storage.key.mdfe.reception_sync", "mdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_reception_sync", "retMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.proc", "procMdfe")),
    MDFE_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.mdfe.status_service", "consStatServMdfe"), System.getProperty("com.softart.dfe.storage.key.mdfe.return_status_service", "retConsStatServMdfe"), null),
    ;

    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
