package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.Getter;

@Getter
public enum NFStorageKey implements StorageKey {
    NF_AUTHORIZATION(System.getProperty("STORAGE_KEY_NF_SEND_AUTHORIZATION", "enviNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_AUTHORIZATION", "retEnviNfe"), System.getProperty("STORAGE_KEY_NF_PROC_AUTHORIZATION", "procNfe")),
    NF_EVENT(System.getProperty("STORAGE_KEY_NF_SEND_EVENT", "envEventoNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_EVENT", "retEnvEventoNfe"), System.getProperty("STORAGE_KEY_NF_PROC_EVENT", "procEventoNfe")),
    NF_INUTILIZATION(System.getProperty("STORAGE_KEY_NF_SEND_INUTILIZATION", "inutNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_INUTILIZATION", "retInutNfe"), System.getProperty("STORAGE_KEY_NF_PROC_INUTILIZATION", "procInutNfe")),
    NF_RETURN_AUTHORIZATION(System.getProperty("STORAGE_KEY_NF_SEND_RETURN_AUTHORIZATION", "consReciNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_RETURN_AUTHORIZATION", "retConsReciNfe"), null),
    NF_QUERY_PROTOCOL(System.getProperty("STORAGE_KEY_NF_SEND_QUERY_PROTOCOL", "consSitNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_QUERY_PROTOCOL", "retConsSitNfe"), null),
    NF_QUERY_STATUS_SERVICE(System.getProperty("STORAGE_KEY_NF_SEND_QUERY_STATUS_SERVICE", "consStatServ"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_QUERY_STATUS_SERVICE", "retConsStatServ"), null),
    NF_QUERY_GTIN(System.getProperty("STORAGE_KEY_NF_SEND_QUERY_GTIN", "consGTIN"), System.getProperty("STORAGE_KEY_NF_RETURN_SEND_QUERY_GTIN", "retConsGTIN"), null),
    NF_DISTRIBUTION(System.getProperty("STORAGE_KEY_NF_DISTRIBUTION", "distNfe"), System.getProperty("STORAGE_KEY_NF_RETURN_DISTRIBUTION", "retDistNfe"), null),
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
