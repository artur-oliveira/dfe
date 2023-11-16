package org.dfe.models.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import org.dfe.enums.cte.version.CteVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class QueryReceipt implements DFObject, XMLAdapter<QueryReceipt, TConsReciCTe> {
    private String tpAmb;
    private String nRec;
    @Builder.Default
    private String versao = CteVersion.getDefault().getVersion();
}
