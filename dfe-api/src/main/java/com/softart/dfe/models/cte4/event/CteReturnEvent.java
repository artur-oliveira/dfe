package com.softart.dfe.models.cte4.event;

import br.inf.portalfiscal.cte.send400.TRetEvento;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CteReturnEvent implements DFObject, XMLAdapter<CteReturnEvent, br.inf.portalfiscal.cte.send400.TRetEvento> {
    private RetInfEvento infEvento;
    private String versao;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public final static class RetInfEvento implements DFObject, XMLAdapter<RetInfEvento, TRetEvento.InfEvento> {
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
