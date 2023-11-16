package org.dfe.models.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteReturnStatusService implements DFObject, XMLAdapter<CteReturnStatusService, TRetConsStatServ> {

    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected BigInteger tMed;
    protected String dhRetorno;
    protected String xObs;
    protected String versao;

}
