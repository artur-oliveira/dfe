package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.Getter;

@Getter
public enum NFStorageKey implements StorageKey {
    NF_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_authorization", "enviNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_authorization", "retEnviNfe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_authorization", "procNfe")),
    NF_EVENT(System.getProperty("com.softart.dfe.storage.key.nf.send_event", "envEventoNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_event", "retEnvEventoNfe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_event", "procEventoNfe")),
    NF_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_inutilization", "inutNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_inutilization", "retInutNfe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_inutilization", "procInutNfe")),
    NF_RETURN_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_return_authorization", "consReciNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_return_authorization", "retConsReciNfe"), null),
    NF_QUERY_PROTOCOL(System.getProperty("com.softart.dfe.storage.key.nf.send_query_protocol", "consSitNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_protocol", "retConsSitNfe"), null),
    NF_QUERY_REGISTER(System.getProperty("com.softart.dfe.storage.key.nf.send_query_register", "consCad"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_register", "retConsCad"), null),
    NF_QUERY_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.nf.send_query_status_service", "consStatServ"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_status_service", "retConsStatServ"), null),
    NF_QUERY_GTIN(System.getProperty("com.softart.dfe.storage.key.nf.send_query_gtin", "consGTIN"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_gtin", "retConsGTIN"), null),
    NF_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.nf.distribution", "distNfe"), System.getProperty("com.softart.dfe.storage.key.nf.return_distribution", "retDistNfe"), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;

    NFStorageKey(String forSend, String forReturn, String forProcessed) {
        this.forSend = forSend;
        this.forReturn = forReturn;
        this.forProcessed = forProcessed;
    }
}
