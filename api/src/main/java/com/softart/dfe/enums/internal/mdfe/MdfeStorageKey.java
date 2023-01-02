package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeStorageKey implements StorageKey {
    MDFE_DISTRIBUTION(System.getProperty("STORAGE_KEY_MDFE_DISTRIBUTION", "distMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_DISTRIBUTION", "retDistMdfe"), null),
    MDFE_EVENT(System.getProperty("STORAGE_KEY_MDFE_EVENT", "eventoMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_EVENT", "retEventoMdfe"), System.getProperty("STORAGE_KEY_MDFE_PROC_EVENT", "procEventoMdfe")),
    MDFE_QUERY_RECEIPT(System.getProperty("STORAGE_KEY_MDFE_QUERY_RECEIPT", "consReciMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_QUERY_RECEIPT", "retConsReciMdfe"), null),
    MDFE_QUERY_UNCLOSED(System.getProperty("STORAGE_KEY_MDFE_QUERY_UNCLOSED", "consReciMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_QUERY_UNCLOSED", "retConsReciMdfe"), null),
    MDFE_QUERY_SITUATION(System.getProperty("STORAGE_KEY_MDFE_QUERY_SITUATION", "consSitMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_QUERY_SITUATION", "retConsSitMdfe"), null),
    MDFE_RECEPTION(System.getProperty("STORAGE_KEY_MDFE_RECEPTION", "enviMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_RECEPTION", "retEnviMdfe"), System.getProperty("STORAGE_KEY_MDFE_PROC", "procMdfe")),
    MDFE_RECEPTION_SYNC(System.getProperty("STORAGE_KEY_MDFE_RECEPTION_SYNC", "mdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_RECEPTION_SYNC", "retMdfe"), System.getProperty("STORAGE_KEY_MDFE_PROC", "procMdfe")),
    MDFE_STATUS_SERVICE(System.getProperty("STORAGE_KEY_MDFE_STATUS_SERVICE", "consStatServMdfe"), System.getProperty("STORAGE_KEY_MDFE_RETURN_STATUS_SERVICE", "retConsStatServMdfe"), null),
    ;

    private final String forSend;
    private final String forReturn;
    private final String forProcessed;
}
