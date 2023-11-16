package org.dfe.models.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import org.dfe.enums.cte.CteEvent;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteStatusService implements DFObject, XMLAdapter<CteStatusService, TConsStatServ> {

    protected String tpAmb;
    @Builder.Default
    protected String xServ = CteEvent.STATUS_SERVICE.getCode();
    @Builder.Default
    protected String versao = CteVersion.getDefault().getVersion();

}
