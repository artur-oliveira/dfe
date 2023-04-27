package com.softart.dfe.models.nf.distribution;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
    public static class DistNSU implements DFObject, XMLAdapter<DistNSU, TDistDFeInt.DistNSU> {
        protected String ultNSU;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsNSU implements DFObject, XMLAdapter<ConsNSU, TDistDFeInt.ConsNSU> {
        protected String nsu;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsChNFe implements DFObject, XMLAdapter<ConsChNFe, TDistDFeInt.ConsChNFe> {
        protected String chNFe;
    }

}
