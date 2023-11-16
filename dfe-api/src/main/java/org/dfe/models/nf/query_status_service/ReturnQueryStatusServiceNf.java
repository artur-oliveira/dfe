package org.dfe.models.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnQueryStatusServiceNf implements DFObject, XMLAdapter<ReturnQueryStatusServiceNf, TRetConsStatServ> {

    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected String tMed;
    protected String dhRetorno;
    protected String xObs;
    protected String versao;

}
