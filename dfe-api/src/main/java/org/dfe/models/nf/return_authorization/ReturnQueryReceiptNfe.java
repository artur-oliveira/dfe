package org.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.models.nf.authorization.NfProtocol;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnQueryReceiptNfe implements DFObject, XMLAdapter<ReturnQueryReceiptNfe, TRetConsReciNFe> {
    protected String tpAmb;
    protected String verAplic;
    protected String nRec;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected String cMsg;
    protected String xMsg;
    protected List<NfProtocol> protNFe;
    protected String versao;

}
