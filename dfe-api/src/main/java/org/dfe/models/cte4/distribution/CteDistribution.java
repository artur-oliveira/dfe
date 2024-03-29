package org.dfe.models.cte4.distribution;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import org.dfe.enums.cte.version.CteDistributionVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteDistribution implements DFObject, XMLAdapter<CteDistribution, DistDFeInt> {

    protected String tpAmb;
    protected String cufAutor;
    protected String cnpj;
    protected String cpf;
    protected DistNSU distNSU;
    protected ConsNSU consNSU;
    @Builder.Default
    protected String versao = CteDistributionVersion.getDefault().getVersion();

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DistNSU implements DFObject, XMLAdapter<DistNSU, br.inf.portalfiscal.cte.distribution.DistNSU> {
        protected String ultNSU;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsNSU implements DFObject, XMLAdapter<ConsNSU, br.inf.portalfiscal.cte.distribution.ConsNSU> {
        protected String nsu;
    }

}
