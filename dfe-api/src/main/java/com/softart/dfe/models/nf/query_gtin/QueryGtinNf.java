package com.softart.dfe.models.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import com.softart.dfe.enums.nf.version.NFGtinVersion;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
