package org.dfe.models.mdfe.query_receipt;

import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.mdfe.reception_sync.MdfeProtocol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeReturnQueryReceipt implements DFObject, XMLAdapter<MdfeReturnQueryReceipt, TRetConsReciMDFe> {
    private String tpAmb;
    private String verAplic;
    private String nRec;
    private String cStat;
    private String xMotivo;
    private String cuf;
    private MdfeProtocol protMDFe;
    private String versao;

}
