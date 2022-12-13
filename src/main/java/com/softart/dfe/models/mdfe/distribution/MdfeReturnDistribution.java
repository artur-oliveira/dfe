package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.RetDistDFeInt;
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
public class MdfeReturnDistribution implements DFObject, XMLAdapter<MdfeReturnDistribution, RetDistDFeInt> {

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
    public static class LoteDistDFeInt implements DFObject, XMLAdapter<LoteDistDFeInt, br.inf.portalfiscal.mdfe.classes.LoteDistDFeInt> {
        protected List<DocZip> docZip;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DocZip implements DFObject, XMLAdapter<DocZip, br.inf.portalfiscal.mdfe.classes.DocZip> {
            protected String value;
            protected String nsu;
            protected String schema;

            @Override
            public br.inf.portalfiscal.mdfe.classes.DocZip toObject() {
                br.inf.portalfiscal.mdfe.classes.DocZip docZip = new br.inf.portalfiscal.mdfe.classes.DocZip();

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
            public DocZip fromObject(br.inf.portalfiscal.mdfe.classes.DocZip o) {
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
