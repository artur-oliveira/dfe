package org.dfe.models.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryStatusServiceNf implements DFObject, XMLAdapter<QueryStatusServiceNf, TConsStatServ> {
    @Builder.Default
    protected String xServ = NFEvent.QUERY_STATUS_SERVICE.getCode();
    protected String tpAmb;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();
    protected String cuf;

}
