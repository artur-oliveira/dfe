package com.softart.dfe.models.cte.query_receipt;

import br.inf.portalfiscal.cte.send.TConsReciCTe;
import com.softart.dfe.enums.cte.version.CteVersion;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
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
