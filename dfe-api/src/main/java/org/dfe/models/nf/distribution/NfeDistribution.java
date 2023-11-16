package org.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfeDistribution implements DFObject, XMLAdapter<NfeDistribution, TDistDFeInt> {

    protected String tpAmb;
    protected String cufAutor;
    protected String cnpj;
    protected String cpf;
    protected DistNSU distNSU;
    protected ConsNSU consNSU;
    protected ConsChNFe consChNFe;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DistNSU implements DFObject, XMLAdapter<DistNSU, br.inf.portalfiscal.nfe.distribution.DistNSU> {
        protected String ultNSU;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsNSU implements DFObject, XMLAdapter<ConsNSU, br.inf.portalfiscal.nfe.distribution.ConsNSU> {
        protected String nsu;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsChNFe implements DFObject, XMLAdapter<ConsChNFe, br.inf.portalfiscal.nfe.distribution.ConsChNFe> {
        protected String chNFe;
    }

}
