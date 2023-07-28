package com.softart.dfe.models.cte.status_service;

import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
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
