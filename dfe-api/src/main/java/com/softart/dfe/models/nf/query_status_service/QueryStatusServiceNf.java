package com.softart.dfe.models.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import com.softart.dfe.enums.nf.NFEvent;
import com.softart.dfe.enums.nf.version.NFVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
