package org.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
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
public class QueryReceiptNfe implements DFObject, XMLAdapter<QueryReceiptNfe, TConsReciNFe> {
    protected String tpAmb;
    protected String nRec;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();

}
