package com.softart.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TProtMDFe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class MdfeProtocol implements DFObject, XMLAdapter<MdfeProtocol, TProtMDFe> {
    private InfProt infProt;
    private InfFisco infFisco;
    private String versao;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfProt implements DFObject, XMLAdapter<InfProt, TProtMDFe.InfProt> {
        private String tpAmb;
        private String verAplic;
        private String chMDFe;
        private String dhRecbto;
        private String nProt;
        private byte[] digVal;
        private String cStat;
        private String xMotivo;
        private String id;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static final class InfFisco implements DFObject, XMLAdapter<InfFisco, TProtMDFe.InfFisco> {
        private String cMsg;
        private String xMsg;
    }

}
