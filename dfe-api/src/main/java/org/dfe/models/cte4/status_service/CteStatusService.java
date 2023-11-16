package org.dfe.models.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
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
    protected String cuf;
    @Builder.Default
    protected String xServ = CteEvent.STATUS_SERVICE.getCode();
    @Builder.Default
    protected String versao = CteVersion.VERSION_400.getVersion();

}
