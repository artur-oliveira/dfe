package com.softart.dfe.models.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.cte.version.CteEventVersion;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.HashUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteDeliveryReceipt implements DFObject, XMLAdapter<CteDeliveryReceipt, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.getDefault().getVersion();

    public static CteDeliveryReceipt build(String accessKey, String protocol, String sequence, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey, CteConfig conf) {
        return build(accessKey, protocol, "", sequence, document, name, lat, lon, deliveryAcessKey, conf);
    }

    @SneakyThrows
    public static CteDeliveryReceipt build(String accessKey, String protocol, String base64Image, String sequence, String document, String name, String lat, String lon, Collection<String> deliveryAcessKey, CteConfig conf) {
        return CteDeliveryReceipt
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
                                .event(InfEvento
                                        .DetEvento
                                        .EvCECTe
                                        .builder()
                                        .nProt(protocol)
                                        .nDoc(document)
                                        .xNome(name)
                                        .latitude(lat)
                                        .longitude(lon)
                                        .infEntrega(deliveryAcessKey.stream().map(it -> InfEvento.DetEvento.EvCECTe.InfEntrega.builder().chNFe(it).build()).collect(Collectors.toList()))
                                        .hashEntrega(HashUtils.hashDeliveryReceipt(accessKey, base64Image))
                                        .dhHashEntrega(DateUtils.nowString())
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
        private String tpEvento = CteEvent.DELIVERY_RECEIPT.getCode();
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

            private EvCECTe event;

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
                evento.setEvent(EvCECTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evCECTe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvCECTe implements DFObject, XMLAdapter<EvCECTe, br.inf.portalfiscal.cte.send.EvCECTe> {
                @Builder.Default
                private String descEvento = CteEvent.DELIVERY_RECEIPT.getDescription();
                private String nProt;
                @Builder.Default
                private String dhEntrega = DateUtils.nowString();
                private String nDoc;
                private String xNome;
                private String latitude;
                private String longitude;
                private byte[] hashEntrega;
                @Builder.Default
                private String dhHashEntrega = DateUtils.nowString();
                private List<InfEntrega> infEntrega;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfEntrega implements DFObject, XMLAdapter<InfEntrega, br.inf.portalfiscal.cte.send.InfEntrega> {
                    private String chNFe;
                }
            }
        }

    }
}
