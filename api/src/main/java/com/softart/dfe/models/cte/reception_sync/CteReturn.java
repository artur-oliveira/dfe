package com.softart.dfe.models.cte.reception_sync;

import br.inf.portalfiscal.cte.send.TRetCTe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.cte.reception.CteProtocol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CteReturn implements DFObject, XMLAdapter<CteReturn, TRetCTe> {
    private String tpAmb;
    private String cuf;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private CteProtocol protCTe;
    private String versao;
}
