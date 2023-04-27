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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteGtv implements DFObject, XMLAdapter<CteGtv, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.getDefault().getVersion();

    public static CteGtv build(String accessKey, String sequence, List<InfEvento.DetEvento.EvGTV.InfGTV> infoGtv, CteConfig conf) {
        return CteGtv
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
                                        .EvGTV
                                        .builder()
                                        .infGTV(infoGtv)
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
        private String tpEvento = CteEvent.INFO_GTV.getCode();
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

            private EvGTV event;

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
                evento.setEvent(EvGTV.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evGTV(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvGTV implements DFObject, XMLAdapter<EvGTV, br.inf.portalfiscal.cte.send.EvGTV> {

                @Builder.Default
                private String descEvento = CteEvent.INFO_GTV.getDescription();
                private List<InfGTV> infGTV;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfGTV implements DFObject, XMLAdapter<InfGTV, br.inf.portalfiscal.cte.send.InfGTV> {
                    private String nDoc;
                    private String id;
                    private String serie;
                    private String subserie;
                    private String dEmi;
                    private String ndv;
                    private String qCarga;
                    private List<InfEspecie> infEspecie;
                    private Rem rem;
                    private Dest dest;
                    private String placa;
                    private TUf uf;
                    private String rntrc;

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class InfEspecie implements DFObject, XMLAdapter<InfEspecie, br.inf.portalfiscal.cte.send.InfEspecie> {
                        private String tpEspecie;
                        private String vEspecie;
                    }

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class Rem implements DFObject, XMLAdapter<Rem, br.inf.portalfiscal.cte.send.InfGTV.Rem> {
                        private String cnpj;
                        private String cpf;
                        private String ie;
                        private TUf uf;
                        private String xNome;
                    }

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class Dest implements DFObject, XMLAdapter<Dest, br.inf.portalfiscal.cte.send.InfGTV.Dest> {
                        private String cnpj;
                        private String cpf;
                        private String ie;
                        private TUf uf;
                        private String xNome;
                    }
                }
            }
        }

    }
}
