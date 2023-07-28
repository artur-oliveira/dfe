package com.softart.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TProtNFe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfProtocol implements DFObject, XMLAdapter<NfProtocol, TProtNFe> {
    protected InfProt infProt;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfProt implements DFObject, XMLAdapter<InfProt, TProtNFe.InfProt> {
        protected String tpAmb;
        protected String verAplic;
        protected byte[] digVal;
        protected String chNFe;
        protected String dhRecbto;
        protected String nProt;
        protected String cStat;
        protected String xMotivo;
        protected String cMsg;
        protected String xMsg;
        protected String id;
    }
}
