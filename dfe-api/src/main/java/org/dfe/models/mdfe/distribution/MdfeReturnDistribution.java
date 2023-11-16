package org.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TLoteDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;
import org.w3c.dom.Element;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MdfeReturnDistribution implements DFObject, XMLAdapter<MdfeReturnDistribution, TRetDistDFe> {

    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String ultNSU;
    protected byte[] loteDistMDFeComp;
    protected TLoteDistDFe loteDistMDFe;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoteDistDFeInt implements DFObject, XMLAdapter<LoteDistDFeInt, br.inf.portalfiscal.mdfe.classes.TLoteDistDFe> {
        protected List<Proc> docZip;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Proc implements DFObject, XMLAdapter<Proc, TLoteDistDFe.Proc> {
            protected Element any;
            protected String schema;
            protected String nsu;
            protected String ipTransmissor;

        }
    }

}
