package org.dfe.models.cte4.reception_sync;

import br.inf.portalfiscal.cte.send400.SignatureType;
import br.inf.portalfiscal.cte.send400.TProtCTe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public final class CteProtocol implements DFObject, XMLAdapter<CteProtocol, TProtCTe> {
    private InfProt infProt;
    private InfFisco infFisco;
    private SignatureType signature;
    private String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfProt implements DFObject, XMLAdapter<InfProt, TProtCTe.InfProt> {
        private String tpAmb;
        private String verAplic;
        private String chCTe;
        private String dhRecbto;
        private String nProt;
        private byte[] digVal;
        private String cStat;
        private String xMotivo;
        private String id;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfFisco implements DFObject, XMLAdapter<InfFisco, TProtCTe.InfFisco> {
        private String cMsg;
        private String xMsg;
    }
}
