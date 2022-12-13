package com.softart.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TConsReciNFe;
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
public class QueryReceiptNfe implements DFObject, XMLAdapter<QueryReceiptNfe, TConsReciNFe> {
    protected String tpAmb;
    protected String nRec;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();

}
