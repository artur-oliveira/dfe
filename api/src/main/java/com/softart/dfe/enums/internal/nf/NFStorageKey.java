package com.softart.dfe.enums.internal.nf;

import com.softart.dfe.interfaces.internal.StorageKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NFStorageKey implements StorageKey {
    NF_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_authorization", "enviNFe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_authorization", "retEnviNFe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_authorization", "procNFe")),
    NF_EVENT(System.getProperty("com.softart.dfe.storage.key.nf.send_event", "envEventoNFe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_event", "retEnvEventoNFe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_event", "procEventoNFe")),
    NF_INUTILIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_inutilization", "inutNFe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_inutilization", "retInutNFe"), System.getProperty("com.softart.dfe.storage.key.nf.proc_inutilization", "procInutNFe")),
    NF_RETURN_AUTHORIZATION(System.getProperty("com.softart.dfe.storage.key.nf.send_return_authorization", "consReciNFe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_return_authorization", "retConsReciNFe"), null),
    NF_QUERY_PROTOCOL(System.getProperty("com.softart.dfe.storage.key.nf.send_query_protocol", "consSitNFe"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_protocol", "retConsSitNFe"), null),
    NF_QUERY_REGISTER(System.getProperty("com.softart.dfe.storage.key.nf.send_query_register", "ConsCad"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_register", "retConsCad"), null),
    NF_QUERY_STATUS_SERVICE(System.getProperty("com.softart.dfe.storage.key.nf.send_query_status_service", "consStatServ"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_status_service", "retConsStatServ"), null),
    NF_QUERY_GTIN(System.getProperty("com.softart.dfe.storage.key.nf.send_query_gtin", "consGTIN"), System.getProperty("com.softart.dfe.storage.key.nf.return_send_query_gtin", "retConsGTIN"), null),
    NF_DISTRIBUTION(System.getProperty("com.softart.dfe.storage.key.nf.distribution", "distDFeInt"), System.getProperty("com.softart.dfe.storage.key.nf.return_distribution", "retDistDFeInt"), null),
    ;
    private final String forSend;
    private final String forReturn;
    private final String forProcessed;

}
