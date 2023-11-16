package org.dfe.models.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import org.dfe.enums.nf.version.NFGtinVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryGtinNf implements DFObject, XMLAdapter<QueryGtinNf, TConsGTIN> {
    protected String gtin;
    @Builder.Default
    protected String versao = NFGtinVersion.getDefault().getVersion();

}
