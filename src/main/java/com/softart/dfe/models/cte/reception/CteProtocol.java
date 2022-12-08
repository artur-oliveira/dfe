package com.softart.dfe.models.cte.reception;

import br.inf.portalfiscal.cte.send.SignatureType;
import br.inf.portalfiscal.cte.send.TProtCTe;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteProtocol implements DFObject, XMLAdapter<CteProtocol, TProtCTe> {
    protected InfProt infProt;
    protected InfFisco infFisco;
    protected SignatureType signature;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfProt implements DFObject, XMLAdapter<InfProt, TProtCTe.InfProt> {
        protected String tpAmb;
        protected String verAplic;
        protected String chCTe;
        protected String dhRecbto;
        protected String nProt;
        protected byte[] digVal;
        protected String cStat;
        protected String xMotivo;
        protected String id;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfFisco implements DFObject, XMLAdapter<InfFisco, TProtCTe.InfFisco> {
        protected String cMsg;
        protected String xMsg;
    }
}
