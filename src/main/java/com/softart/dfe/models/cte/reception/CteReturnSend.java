package com.softart.dfe.models.cte.reception;

import br.inf.portalfiscal.cte.send.TRetEnviCTe;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CteReturnSend implements DFObject, XMLAdapter<CteReturnSend, TRetEnviCTe> {

    private String tpAmb;
    private String cuf;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private InfRec infRec;
    private String versao;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfRec implements DFObject, XMLAdapter<InfRec, br.inf.portalfiscal.cte.send.TRetEnviCTe.InfRec> {
        private String nRec;
        private String dhRecbto;
        private BigInteger tMed;
    }
}
