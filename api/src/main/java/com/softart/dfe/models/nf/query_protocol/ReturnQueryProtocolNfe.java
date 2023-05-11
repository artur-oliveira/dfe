package com.softart.dfe.models.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.SignatureType;
import br.inf.portalfiscal.nfe.send.TProcEvento;
import br.inf.portalfiscal.nfe.send.TRetCancNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.nf.authorization.NfProtocol;
import lombok.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReturnQueryProtocolNfe implements DFObject, XMLAdapter<ReturnQueryProtocolNfe, TRetConsSitNFe> {
    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected String dhRecbto;
    protected String chNFe;
    protected NfProtocol protNFe;
    protected RetCancNFe retCancNFe;
    protected List<ProcNfeEvent> procEventoNFe;
    protected String versao;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProcNfeEvent implements DFObject, XMLAdapter<ProcNfeEvent, TProcEvento> {
        protected TEvento evento;
        protected TRetEvento retEvento;
        protected String versao;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TEvento implements DFObject, XMLAdapter<TEvento, br.inf.portalfiscal.nfe.send.TEvento> {
            protected InfEvento infEvento;
            protected SignatureType signature;
            protected String versao;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.nfe.send.TEvento.InfEvento> {
                protected String cOrgao;
                protected String tpAmb;
                protected String cnpj;
                protected String cpf;
                protected String chNFe;
                protected String dhEvento;
                protected String tpEvento;
                protected String nSeqEvento;
                protected String verEvento;
                protected DetEvento detEvento;
                protected String id;

                @Getter
                @Setter
                @Builder
                @ToString
                @AllArgsConstructor
                @NoArgsConstructor
                public static class DetEvento implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.nfe.send.TEvento.InfEvento.DetEvento> {
                    @Builder.Default
                    protected Map<String, String> any = new HashMap<>();
                    @Builder.Default
                    protected Map<String, String> otherAttributes = new HashMap<>();

                    @Override
                    public DetEvento fromObject(br.inf.portalfiscal.nfe.send.TEvento.InfEvento.DetEvento o) {
                        o.getAny().forEach(element -> getAny().put(element.getNodeName(), element.getFirstChild().getNodeValue()));
                        o.getOtherAttributes().forEach((k, v) -> getOtherAttributes().put(k.getLocalPart(), v));

                        return this;
                    }
                }
            }
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TRetEvento implements DFObject, XMLAdapter<TRetEvento, br.inf.portalfiscal.nfe.send.TRetEvento> {
            protected InfEvento infEvento;
            protected SignatureType signature;
            protected String versao;

            @Getter
            @Setter
            @Builder
            @ToString
            @AllArgsConstructor
            @NoArgsConstructor
            public static class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.nfe.send.TRetEvento.InfEvento> {
                protected String tpAmb;
                protected String verAplic;
                protected String cOrgao;
                protected String cStat;
                protected String xMotivo;
                protected String chNFe;
                protected String tpEvento;
                protected String xEvento;
                protected String nSeqEvento;
                protected String cnpjDest;
                protected String cpfDest;
                protected String emailDest;
                protected String dhRegEvento;
                protected String nProt;
                protected String id;
            }
        }
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RetCancNFe implements DFObject, XMLAdapter<RetCancNFe, TRetCancNFe> {
        protected InfCanc infCanc;
        protected SignatureType signature;
        protected String versao;

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfCanc implements DFObject, XMLAdapter<InfCanc, TRetCancNFe.InfCanc> {
            protected String tpAmb;
            protected String verAplic;
            protected String cStat;
            protected String xMotivo;
            protected String cuf;
            protected String chNFe;
            protected XMLGregorianCalendar dhRecbto;
            protected String nProt;
            protected String id;
        }
    }


}
