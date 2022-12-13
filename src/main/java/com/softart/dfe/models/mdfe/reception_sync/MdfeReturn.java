package com.softart.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MdfeReturn implements DFObject, XMLAdapter<MdfeReturn, TRetMDFe> {
    protected String tpAmb;
    protected String cuf;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected MdfeProtocol protMDFe;
    protected String versao;
}
