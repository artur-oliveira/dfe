package com.softart.dfe.models.mdfe.query_unclosed;

import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeReturnQueryUnclosed implements DFObject, XMLAdapter<MdfeReturnQueryUnclosed, TRetConsMDFeNaoEnc> {

    private String tpAmb;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private String cuf;
    private List<InfMDFe> infMDFe;
    private String versao;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfMDFe implements DFObject, XMLAdapter<InfMDFe, TRetConsMDFeNaoEnc.InfMDFe> {
        private String chMDFe;
        private String nProt;
    }
}
