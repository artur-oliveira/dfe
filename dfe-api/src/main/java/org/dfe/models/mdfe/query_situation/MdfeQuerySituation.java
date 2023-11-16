package org.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import org.dfe.enums.mdfe.MdfeEvent;
import org.dfe.enums.mdfe.version.MdfeVersion;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeQuerySituation implements DFObject, XMLAdapter<MdfeQuerySituation, TConsSitMDFe> {

    private String tpAmb;

    @Builder.Default
    private String xServ = MdfeEvent.QUERY_SITUATION.getCode();

    private String chMDFe;

    @Builder.Default
    private String versao = MdfeVersion.getDefault().getVersion();

    public static MdfeQuerySituation build(String accessKey, MdfeConfig config) {
        return MdfeQuerySituation.builder().tpAmb(config.environment().getCode()).chMDFe(accessKey).build();
    }
}
