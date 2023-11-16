package org.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.GZIPUtils;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MdfeReturnDistributionOld implements DFObject, XMLAdapter<MdfeReturnDistributionOld, RetDistDFeInt> {

    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String dhResp;
    protected String ultNSU;
    protected String maxNSU;
    protected MdfeReturnDistributionOld.LoteDistDFeInt loteDistDFeInt;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoteDistDFeInt implements DFObject, XMLAdapter<MdfeReturnDistributionOld.LoteDistDFeInt, br.inf.portalfiscal.mdfe.distribution.LoteDistDFeInt> {
        protected List<MdfeReturnDistributionOld.LoteDistDFeInt.DocZip> docZip;


        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DocZip implements DFObject, XMLAdapter<MdfeReturnDistributionOld.LoteDistDFeInt.DocZip, br.inf.portalfiscal.mdfe.distribution.DocZip> {
            protected String value;
            protected String nsu;
            protected String schema;

            @Override
            public br.inf.portalfiscal.mdfe.distribution.DocZip toObject() {
                br.inf.portalfiscal.mdfe.distribution.DocZip docZip = new br.inf.portalfiscal.mdfe.distribution.DocZip();

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
            public MdfeReturnDistributionOld.LoteDistDFeInt.DocZip fromObject(br.inf.portalfiscal.mdfe.distribution.DocZip o) {
                MdfeReturnDistributionOld.LoteDistDFeInt.DocZip docZip = MdfeReturnDistributionOld.LoteDistDFeInt.DocZip.builder().build();
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
