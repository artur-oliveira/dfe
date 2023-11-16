package org.dfe.models.cte4.event;

import br.inf.portalfiscal.cte.send400.TEvento;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteProvisionDisagreement implements DFObject, XMLAdapter<CteProvisionDisagreement, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.VERSION_400.getVersion();

    public static CteProvisionDisagreement build(String accessKey, String sequence, String observation, CteConfig conf) {
        return CteProvisionDisagreement
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
                                        .EvPrestDesacordo
                                        .builder()
                                        .xObs(observation)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.cte.send400.TEvento.InfEvento> {
        private String cOrgao;
        private String tpAmb;
        private String cnpj;
        private String cpf;
        private String chCTe;
        @Builder.Default
        private String dhEvento = DateUtils.nowString();
        @Builder.Default
        private String tpEvento = CteEvent.PROVISION_IN_DISAGREEMENT.getCode();
        private String nSeqEvento;
        private DetEvento detEvento;
        private String id;

        @Override
        public br.inf.portalfiscal.cte.send400.TEvento.InfEvento toObject() {
            br.inf.portalfiscal.cte.send400.TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEventoCte400(getTpEvento(), getChCTe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.cte.send400.TEvento.InfEvento.DetEvento> {

            private EvPrestDesacordo event;

            @Builder.Default
            private String versaoEvento = CteEventVersion.VERSION_400.getVersion();

            @Override
            @SneakyThrows
            public br.inf.portalfiscal.cte.send400.TEvento.InfEvento.DetEvento toObject() {
                br.inf.portalfiscal.cte.send400.TEvento.InfEvento.DetEvento evento = new br.inf.portalfiscal.cte.send400.TEvento.InfEvento.DetEvento();
                evento.setVersaoEvento(getVersaoEvento());
                evento.setAny(CteMarshallerFactory.getInstance().toElement(getEvent().toObject()));
                return evento;
            }

            @Override
            public DetEvento fromObject(br.inf.portalfiscal.cte.send400.TEvento.InfEvento.DetEvento o) {
                DetEvento evento = DetEvento.builder().build();
                evento.setVersaoEvento(evento.getVersaoEvento());
                evento.setEvent(EvPrestDesacordo.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evPrestDesacordo400(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvPrestDesacordo implements DFObject, XMLAdapter<EvPrestDesacordo, br.inf.portalfiscal.cte.send400.EvPrestDesacordo> {
                @Builder.Default
                private String descEvento = CteEvent.PROVISION_IN_DISAGREEMENT.getDescription();
                @Builder.Default
                private String indDesacordoOper = "1";
                private String xObs;
            }
        }

    }
}
