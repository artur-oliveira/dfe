package com.softart.dfe.models.cte4.query_situation;

import br.inf.portalfiscal.cte.send400.TConsSitCTe;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteQuerySituation implements DFObject, XMLAdapter<CteQuerySituation, TConsSitCTe> {

    protected String tpAmb;
    @Builder.Default
    protected String xServ = CteEvent.QUERY_SITUATION.getCode();
    protected String chCTe;
    @Builder.Default
    protected String versao = CteVersion.VERSION_400.getVersion();

    public static CteQuerySituation build(String accessKey, Config config) {
        return CteQuerySituation.builder().chCTe(accessKey).tpAmb(config.environment().getCode()).build();
    }

}
