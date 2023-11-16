package org.dfe.models.mdfe.distribution;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.mdfe.distribution.MdfeDfeCompression;
import org.dfe.enums.mdfe.distribution.MdfeDfeSolicitation;
import org.dfe.enums.mdfe.version.MdfeDistributionVersion;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.StringUtils;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MdfeDistribution implements DFObject, XMLAdapter<MdfeDistribution, TDistDFe> {

    protected String tpAmb;
    @Builder.Default
    protected String verAplic = ProjectProperties.displayVersion();
    protected long indDFe;
    protected long indCompRet;
    protected String ultNSU;
    @Builder.Default
    protected String versao = MdfeDistributionVersion.getDefault().getVersion();


    public static MdfeDistribution build(Number nsu, MdfeDfeSolicitation solicitation, MdfeDfeCompression compression, MdfeConfig config) {
        return MdfeDistribution
                .builder()
                .tpAmb(config.environment().getCode())
                .indDFe(solicitation.getCodeAsLong())
                .indCompRet(compression.getCodeAsLong())
                .ultNSU(StringUtils.padZeroStart(nsu, 15))
                .build();
    }


}
