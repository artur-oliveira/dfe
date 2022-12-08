package com.softart.dfe.models.nf.return_authorization;

import br.inf.portalfiscal.nfe.send.TRetConsReciNFe;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.models.nf.authorization.ReturnNf;
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
    protected List<ReturnNf.ProtNFe> protNFe;
    protected String versao;

}
