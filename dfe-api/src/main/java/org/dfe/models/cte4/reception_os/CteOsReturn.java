package org.dfe.models.cte4.reception_os;

import br.inf.portalfiscal.cte.send400.TRetCTeOS;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class CteOsReturn implements DFObject, XMLAdapter<CteOsReturn, TRetCTeOS> {
    private String tpAmb;
    private String cuf;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private CteOsProtocol protCTe;
    private String versao;
}
