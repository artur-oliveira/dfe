package com.softart.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.GZIPUtils;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeReturnDistribution implements DFObject, XMLAdapter<NfeReturnDistribution, TRetDistDFeInt> {

    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String dhResp;
    protected String ultNSU;
    protected String maxNSU;
    protected LoteDistDFeInt loteDistDFeInt;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoteDistDFeInt implements DFObject, XMLAdapter<LoteDistDFeInt, TRetDistDFeInt.LoteDistDFeInt> {
        protected List<DocZip> docZip;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DocZip implements DFObject, XMLAdapter<DocZip, TRetDistDFeInt.LoteDistDFeInt.DocZip> {
            protected String value;
            protected String nsu;
            protected String schema;

            @Override
            public TRetDistDFeInt.LoteDistDFeInt.DocZip toObject() {
                TRetDistDFeInt.LoteDistDFeInt.DocZip d = new TRetDistDFeInt.LoteDistDFeInt.DocZip();
                d.setNSU(getNsu());
                d.setSchema(getSchema());
                try {
                    d.setValue(GZIPUtils.compress(getValue()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return d;
            }

            @Override
            public DocZip fromObject(TRetDistDFeInt.LoteDistDFeInt.DocZip o) {
                DocZip d = DocZip.builder().build();
                d.setNsu(o.getNSU());
                d.setSchema(o.getSchema());
                try {
                    d.setValue(GZIPUtils.decompress(o.getValue()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return d;
            }
        }
    }
}
