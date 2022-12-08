package com.softart.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TProtNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnNf implements DFObject, XMLAdapter<ReturnNf, TRetEnviNFe> {
    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected InfRec infRec;
    protected ProtNFe protNFe;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfRec implements DFObject, XMLAdapter<InfRec, TRetEnviNFe.InfRec> {
        protected String nRec;
        protected String tMed;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProtNFe implements DFObject, XMLAdapter<ProtNFe, TProtNFe> {
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

}
