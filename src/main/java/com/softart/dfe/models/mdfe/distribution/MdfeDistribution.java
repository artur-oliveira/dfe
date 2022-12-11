package com.softart.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import com.softart.dfe.enums.mdfe.version.MdfeDistributionVersion;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.util.StringUtils;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MdfeDistribution implements DFObject, XMLAdapter<MdfeDistribution, DistDFeInt> {

    protected String tpAmb;
    protected String cufAutor;
    protected String cnpj;
    protected String cpf;
    protected DistNSU distNSU;
    protected ConsNSU consNSU;
    @Builder.Default
    protected String versao = MdfeDistributionVersion.getDefault().getVersion();

    public static MdfeDistribution distributionUniqueNsu(Number nsu, MdfeConfig config) {
        return MdfeDistribution
                .builder()
                .tpAmb(config.environment().getCode())
                .cnpj(config.cnpj())
                .cpf(config.cpf())
                .cufAutor(config.uf().getCode())
                .distNSU(DistNSU.builder().ultNSU(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build();
    }

    public static MdfeDistribution distributionUltNsu(Number nsu, MdfeConfig config) {
        return MdfeDistribution
                .builder()
                .tpAmb(config.environment().getCode())
                .cnpj(config.cnpj())
                .cpf(config.cpf())
                .cufAutor(config.uf().getCode())
                .consNSU(ConsNSU.builder().nsu(StringUtils.padZeroStart(String.valueOf(nsu), 15)).build())
                .build();
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DistNSU implements DFObject, XMLAdapter<DistNSU, br.inf.portalfiscal.mdfe.classes.DistNSU> {
        protected String ultNSU;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ConsNSU implements DFObject, XMLAdapter<ConsNSU, br.inf.portalfiscal.mdfe.classes.ConsNSU> {
        protected String nsu;
    }

}
