package org.dfe.models.cte4.event;

import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TUf;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.enums.cte.CteEvent;
import org.dfe.enums.cte.version.CteEventVersion;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.XMLStringUtils;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteGtv implements DFObject, XMLAdapter<CteGtv, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.VERSION_400.getVersion();

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
    public static final class InfEvento implements DFObject, XMLAdapter<InfEvento, TEvento.InfEvento> {
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
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEventoCte400(getTpEvento(), getChCTe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, TEvento.InfEvento.DetEvento> {

            private EvGTV event;

            @Builder.Default
            private String versaoEvento = CteEventVersion.VERSION_400.getVersion();

            @Override
            @SneakyThrows
            public TEvento.InfEvento.DetEvento toObject() {
                TEvento.InfEvento.DetEvento evento = new TEvento.InfEvento.DetEvento();
                evento.setVersaoEvento(getVersaoEvento());
                evento.setAny(CteMarshallerFactory.getInstance().toElement(getEvent().toObject()));
                return evento;
            }

            @Override
            public DetEvento fromObject(TEvento.InfEvento.DetEvento o) {
                DetEvento evento = DetEvento.builder().build();
                evento.setVersaoEvento(evento.getVersaoEvento());
                evento.setEvent(EvGTV.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evGTV400(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvGTV implements DFObject, XMLAdapter<EvGTV, br.inf.portalfiscal.cte.send400.EvGTV> {

                @Builder.Default
                private String descEvento = CteEvent.INFO_GTV.getDescription();
                private List<InfGTV> infGTV;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfGTV implements DFObject, XMLAdapter<InfGTV, br.inf.portalfiscal.cte.send400.EvGTV.InfGTV> {
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
                    public static final class InfEspecie implements DFObject, XMLAdapter<InfEspecie, br.inf.portalfiscal.cte.send400.EvGTV.InfGTV.InfEspecie> {
                        private String tpEspecie;
                        private String vEspecie;
                    }

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class Rem implements DFObject, XMLAdapter<Rem, br.inf.portalfiscal.cte.send400.EvGTV.InfGTV.Rem> {
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
                    public static final class Dest implements DFObject, XMLAdapter<Dest, br.inf.portalfiscal.cte.send400.EvGTV.InfGTV.Dest> {
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
