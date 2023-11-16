package org.dfe.models.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
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
public class QueryProtocolNfe implements DFObject, XMLAdapter<QueryProtocolNfe, TConsSitNFe> {
    protected final String xServ = NFEvent.QUERY_PROTOCOL.getCode();
    protected String tpAmb;
    protected String chNFe;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();

}
