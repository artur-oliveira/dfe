package org.dfe.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.SignatureType;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeReturnEvent implements DFObject, XMLAdapter<MdfeReturnEvent, TRetEvento> {

    private InfEvento infEvento;
    private SignatureType signature;
    private String versao;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static final class InfEvento implements DFObject, XMLAdapter<InfEvento, TRetEvento.InfEvento> {
        private String tpAmb;
        private String verAplic;
        private String cOrgao;
        private String cStat;
        private String xMotivo;
        private String chMDFe;
        private String tpEvento;
        private String xEvento;
        private String nSeqEvento;
        private String dhRegEvento;
        private String nProt;
        private String id;
    }
}
