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
public final class CteCancelDeliveryReceipt implements DFObject, XMLAdapter<CteCancelDeliveryReceipt, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.VERSION_400.getVersion();

    public static CteCancelDeliveryReceipt build(String accessKey, String protocol, String sequence, String protocolDeliveryReceipt, CteConfig conf) {
        return CteCancelDeliveryReceipt
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
                                        .EvCancCECTe
                                        .builder()
                                        .nProt(protocol)
                                        .nProtCE(protocolDeliveryReceipt)
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
        private String tpEvento = CteEvent.CANCEL_DELIVERY_RECEIPT.getCode();
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

            private EvCancCECTe event;

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
                evento.setEvent(EvCancCECTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evCancCECTe400(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvCancCECTe implements DFObject, XMLAdapter<EvCancCECTe, br.inf.portalfiscal.cte.send400.EvCancCECTe> {
                @Builder.Default
                private String descEvento = CteEvent.CANCEL_DELIVERY_RECEIPT.getDescription();
                private String nProt;
                private String nProtCE;
            }
        }

    }
}
