package org.dfe.models.nf.inut;

import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnNfeInut implements DFObject, XMLAdapter<ReturnNfeInut, TRetInutNFe> {

    protected String versao;
    protected InfInut infInut;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfInut implements DFObject, XMLAdapter<InfInut, TRetInutNFe.InfInut> {
        protected String tpAmb;
        protected String verAplic;
        protected String cStat;
        protected String xMotivo;
        protected String cuf;
        protected String ano;
        protected String cnpj;
        protected String mod;
        protected String serie;
        protected String nnfIni;
        protected String nnfFin;
        protected String dhRecbto;
        protected String nProt;
        protected String id;
    }

}
