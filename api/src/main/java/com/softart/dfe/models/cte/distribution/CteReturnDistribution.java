package com.softart.dfe.models.cte.distribution;

import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
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
public class CteReturnDistribution implements DFObject, XMLAdapter<CteReturnDistribution, RetDistDFeInt> {

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
    public static class LoteDistDFeInt implements DFObject, XMLAdapter<LoteDistDFeInt, RetDistDFeInt.LoteDistDFeInt> {
        protected List<DocZip> docZip;


        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DocZip implements DFObject, XMLAdapter<DocZip, RetDistDFeInt.LoteDistDFeInt.DocZip> {
            protected String value;
            protected String nsu;
            protected String schema;

            @Override
            public RetDistDFeInt.LoteDistDFeInt.DocZip toObject() {
                RetDistDFeInt.LoteDistDFeInt.DocZip docZip = new RetDistDFeInt.LoteDistDFeInt.DocZip();

                docZip.setNSU(getNsu());
                docZip.setSchema(getSchema());
                try {
                    docZip.setValue(GZIPUtils.compress(getValue()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                return docZip;
            }

            @Override
            public DocZip fromObject(RetDistDFeInt.LoteDistDFeInt.DocZip o) {
                DocZip docZip = DocZip.builder().build();
                docZip.setNsu(o.getNSU());
                docZip.setSchema(o.getSchema());
                try {
                    docZip.setValue(GZIPUtils.decompress(o.getValue()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                return docZip;
            }
        }
    }

}
