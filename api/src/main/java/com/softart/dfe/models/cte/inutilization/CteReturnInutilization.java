package com.softart.dfe.models.cte.inutilization;

import br.inf.portalfiscal.cte.send.SignatureType;
import br.inf.portalfiscal.cte.send.TRetInutCTe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteReturnInutilization implements DFObject, XMLAdapter<CteReturnInutilization, TRetInutCTe> {
    protected InfInut infInut;
    protected SignatureType signature;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfInut implements DFObject, XMLAdapter<InfInut, br.inf.portalfiscal.cte.send.RetInfInut> {
        protected String tpAmb;
        protected String verAplic;
        protected String cStat;
        protected String xMotivo;
        protected String cuf;
        protected Short ano;
        protected String cnpj;
        protected String mod;
        protected String serie;
        protected String nctIni;
        protected String nctFin;
        protected String dhRecbto;
        protected String nProt;
        protected String id;
    }
}
