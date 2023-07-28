package com.softart.dfe.models.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeReturnStatusService implements DFObject, XMLAdapter<MdfeReturnStatusService, TRetConsStatServ> {
    private String tpAmb;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private String cuf;
    private String dhRecbto;
    private BigInteger tMed;
    private String dhRetorno;
    private String xObs;
    private String versao;
}
