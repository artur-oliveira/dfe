package com.softart.dfe.models.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.version.CteEventVersion;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteCancel implements DFObject, XMLAdapter<CteCancel, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.getDefault().getVersion();

    public static CteCancel build(String accessKey, String protocol, String motive, String sequence, CteConfig conf) {
        return CteCancel
                .builder()
                .infEvento(InfEvento
                        .builder()
                        .chCTe(accessKey)
                        .nSeqEvento(sequence)
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .cOrgao(conf.uf().getCode())
                        .tpAmb(conf.environment().getCode())
                        .detEvento(InfEvento
                                .DetEvento
                                .builder()
                                .event(InfEvento
                                        .DetEvento
                                        .EvCancCTe
                                        .builder()
                                        .nProt(protocol).xJust(motive)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.cte.send.InfEvento> {
        private String cOrgao;
        private String tpAmb;
        private String cnpj;
        private String cpf;
        private String chCTe;
        @Builder.Default
        private String dhEvento = DateUtils.nowString();
        @Builder.Default
        private String tpEvento = CteEvent.CANCEL.getCode();
        private String nSeqEvento;
        private DetEvento detEvento;
        private InfSolicNFF infSolicNFF;
        private String id;

        @Override
        public br.inf.portalfiscal.cte.send.InfEvento toObject() {
            br.inf.portalfiscal.cte.send.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChCTe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.cte.send.DetEvento> {

            private EvCancCTe event;

            @Builder.Default
            private String versaoEvento = CteEventVersion.getDefault().getVersion();

            @Override
            @SneakyThrows
            public br.inf.portalfiscal.cte.send.DetEvento toObject() {
                br.inf.portalfiscal.cte.send.DetEvento evento = new br.inf.portalfiscal.cte.send.DetEvento();
                evento.setVersaoEvento(getVersaoEvento());
                evento.setAny(CteMarshallerFactory.getInstance().toElement(getEvent().toObject()));
                return evento;
            }

            @Override
            public DetEvento fromObject(br.inf.portalfiscal.cte.send.DetEvento o) {
                DetEvento evento = DetEvento.builder().build();
                evento.setVersaoEvento(evento.getVersaoEvento());
                evento.setEvent(EvCancCTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evCancCTe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvCancCTe implements DFObject, XMLAdapter<EvCancCTe, br.inf.portalfiscal.cte.send.EvCancCTe> {
                @Builder.Default
                private String descEvento = CteEvent.CANCEL.getDescription();
                private String nProt;
                private String xJust;
            }
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class InfSolicNFF implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.cte.send.InfSolicNFF> {
            private String xSolic;
        }
    }
}
