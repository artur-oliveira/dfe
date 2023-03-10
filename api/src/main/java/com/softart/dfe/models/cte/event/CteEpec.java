package com.softart.dfe.models.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TUf;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
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
public final class CteEpec implements DFObject, XMLAdapter<CteEpec, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.getDefault().getVersion();


    @SneakyThrows
    public static CteEpec build(String accessKey, String sequence, InfEvento.DetEvento.EvEPECCTe evEPECCTe, CteConfig conf) {
        return CteEpec
                .builder()
                .infEvento(InfEvento
                        .builder()
                        .chCTe(accessKey)
                        .nSeqEvento(sequence)
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf())
                        .cOrgao(conf.environment().getCode())
                        .tpAmb(conf.environment().getCode())
                        .detEvento(InfEvento
                                .DetEvento
                                .builder()
                                .event(evEPECCTe)
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
        private String tpEvento = CteEvent.EPEC.getCode();
        private String nSeqEvento;
        private DetEvento detEvento;
        private String id;

        @Override
        public br.inf.portalfiscal.cte.send.InfEvento toObject() {
            br.inf.portalfiscal.cte.send.InfEvento evento = XMLAdapter.super.toObject();
            evento.setId(XMLStringUtils.idEvento(getTpEvento(), getChCTe(), getNSeqEvento()));
            evento.setCNPJ(AccessKeyParserFactory.cte().cnpj(getChCTe()));
            evento.setCOrgao(AccessKeyParserFactory.cte().uf(getChCTe()).getCode());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.cte.send.DetEvento> {

            private EvEPECCTe event;

            @Builder.Default
            private String versaoEvento = CteEventVersion.getDefault().getVersion();

            @Override
            @SneakyThrows
            public br.inf.portalfiscal.cte.send.DetEvento toObject() {
                br.inf.portalfiscal.cte.send.DetEvento evento = new br.inf.portalfiscal.cte.send.DetEvento();
                evento.setVersaoEvento(getVersaoEvento());
                evento.setAny(CteUnmarshallerFactory.getInstance().toElement(getEvent().toObject()));
                return evento;
            }

            @Override
            public DetEvento fromObject(br.inf.portalfiscal.cte.send.DetEvento o) {
                DetEvento evento = DetEvento.builder().build();
                evento.setVersaoEvento(evento.getVersaoEvento());
                evento.setEvent(EvEPECCTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evEPECCTe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvEPECCTe implements DFObject, XMLAdapter<EvEPECCTe, br.inf.portalfiscal.cte.send.EvEPECCTe> {

                @Builder.Default
                private String descEvento = CteEvent.EPEC.getDescription();
                private String xJust;
                private String vicms;
                private String vicmsst;
                private String vtPrest;
                private String vCarga;
                private Toma4 toma4;
                private String modal;
                private TUf ufIni;
                private TUf ufFim;
                private String tpCTe;
                private String dhEmi;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class Toma4 implements DFObject, XMLAdapter<Toma4, br.inf.portalfiscal.cte.send.EvEPECCTe.Toma4> {
                    private String toma;
                    private TUf uf;
                    private String cnpj;
                    private String cpf;
                    private String ie;
                }
            }
        }

    }
}
