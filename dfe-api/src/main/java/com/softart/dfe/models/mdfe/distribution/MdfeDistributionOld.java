package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import com.softart.dfe.enums.mdfe.version.MdfeDistributionVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MdfeDistributionOld implements DFObject, XMLAdapter<MdfeDistributionOld, DistDFeInt> {

    protected String tpAmb;
    protected String cufAutor;
    protected String cnpj;
    protected String cpf;
    protected DistNSU distNSU;
    protected ConsNSU consNSU;
    @Builder.Default
    protected String versao = MdfeDistributionVersion.getDefault().getVersion();

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DistNSU implements DFObject, XMLAdapter<DistNSU, br.inf.portalfiscal.mdfe.distribution.DistNSU> {
        protected String ultNSU;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsNSU implements DFObject, XMLAdapter<ConsNSU, br.inf.portalfiscal.mdfe.distribution.ConsNSU> {
        protected String nsu;
    }


}
