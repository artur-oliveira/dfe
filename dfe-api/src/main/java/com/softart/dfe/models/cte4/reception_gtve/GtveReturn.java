package com.softart.dfe.models.cte4.reception_gtve;

import br.inf.portalfiscal.cte.send400.TRetGTVe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class GtveReturn implements DFObject, XMLAdapter<GtveReturn, TRetGTVe> {
    private String tpAmb;
    private String cuf;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private GtveProtocol protCTe;
    private String versao;
}
