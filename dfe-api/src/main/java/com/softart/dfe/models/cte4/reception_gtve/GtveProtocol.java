package com.softart.dfe.models.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TProtGTVe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class GtveProtocol implements DFObject, XMLAdapter<GtveProtocol, TProtGTVe> {
    private InfProt infProt;
    private InfFisco infFisco;
    private String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfProt implements DFObject, XMLAdapter<InfProt, TProtGTVe.InfProt> {
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
    public static class InfFisco implements DFObject, XMLAdapter<InfFisco, TProtGTVe.InfFisco> {
        private String cMsg;
        private String xMsg;
    }
}
