package org.dfe.models.cte.event;

import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CteReturnEvent implements DFObject, XMLAdapter<CteReturnEvent, br.inf.portalfiscal.cte.send.TRetEvento> {
    private RetInfEvento infEvento;
    private String versao;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public final static class RetInfEvento implements DFObject, XMLAdapter<RetInfEvento, br.inf.portalfiscal.cte.send.RetInfEvento> {
        private String tpAmb;
        private String verAplic;
        private String cOrgao;
        private String cStat;
        private String xMotivo;
        private String chCTe;
        private String tpEvento;
        private String xEvento;
        private String nSeqEvento;
        private String dhRegEvento;
        private String nProt;
        private String id;
    }
}
