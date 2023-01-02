package com.softart.dfe.models.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
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
public class QueryProtocolNfe implements DFObject, XMLAdapter<QueryProtocolNfe, TConsSitNFe> {
    protected final String xServ = NFEvent.QUERY_PROTOCOL.getCode();
    protected String tpAmb;
    protected String chNFe;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();

}
