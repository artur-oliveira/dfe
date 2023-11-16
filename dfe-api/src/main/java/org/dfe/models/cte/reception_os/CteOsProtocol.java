package org.dfe.models.cte.reception_os;

import br.inf.portalfiscal.cte.send.TProtCTeOS;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CteOsProtocol implements DFObject, XMLAdapter<CteOsProtocol, TProtCTeOS> {
    private InfProt infProt;
    private InfFisco infFisco;
    private String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfProt implements DFObject, XMLAdapter<InfProt, TProtCTeOS.InfProt> {
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
    public static class InfFisco implements DFObject, XMLAdapter<InfFisco, TProtCTeOS.InfFisco> {
        private String cMsg;
        private String xMsg;
    }
}
