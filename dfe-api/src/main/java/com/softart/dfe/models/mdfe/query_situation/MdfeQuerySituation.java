package com.softart.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.enums.mdfe.version.MdfeVersion;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
