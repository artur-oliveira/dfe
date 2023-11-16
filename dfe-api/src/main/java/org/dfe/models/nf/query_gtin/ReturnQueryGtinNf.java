package org.dfe.models.nf.query_gtin;

import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnQueryGtinNf implements DFObject, XMLAdapter<ReturnQueryGtinNf, TRetConsGTIN> {
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String dhResp;
    protected String gtin;
    protected String tpGTIN;
    protected String xProd;
    protected String ncm;
    protected List<String> cest;
    protected String versao;
}
