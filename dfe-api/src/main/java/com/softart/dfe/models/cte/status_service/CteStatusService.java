package com.softart.dfe.models.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
