package com.softart.dfe.models.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TRetConsReciCTe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.cte.reception.CteProtocol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnQueryReceipt implements DFObject, XMLAdapter<ReturnQueryReceipt, TRetConsReciCTe> {
    private String tpAmb;
    private String verAplic;
    private String nRec;
    private String cStat;
    private String xMotivo;
    private String cuf;
    private List<CteProtocol> protCTe;
    private String versao;
}
