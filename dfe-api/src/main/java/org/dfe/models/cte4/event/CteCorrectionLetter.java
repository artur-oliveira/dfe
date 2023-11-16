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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CteCorrectionLetter implements DFObject, XMLAdapter<CteCorrectionLetter, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = CteEventVersion.VERSION_400.getVersion();

    public static CteCorrectionLetter build(String accessKey, List<InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections, String sequence, CteConfig conf) {
        return CteCorrectionLetter
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
                                        .EvCCeCTe
                                        .builder()
                                        .infCorrecao(corrections)
                                        .build())
                                .build())
                        .build())
                .build();
    }

    public static CteCorrectionLetter build(String accessKey, InfEvento.DetEvento.EvCCeCTe.InfCorrecao correction, String sequence, CteConfig conf) {
        return build(accessKey, Collections.singletonList(correction), sequence, conf);
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
        private String tpEvento = CteEvent.CORRECTION_LETTER.getCode();
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

            private EvCCeCTe event;

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
                evento.setEvent(EvCCeCTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evCCeCTe400(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvCCeCTe implements DFObject, XMLAdapter<EvCCeCTe, br.inf.portalfiscal.cte.send400.EvCCeCTe> {
                @Builder.Default
                private String descEvento = CteEvent.CORRECTION_LETTER.getDescription();

                @Builder.Default
                private List<InfCorrecao> infCorrecao = new ArrayList<>();
                @Builder.Default
                private String xCondUso = "A Carta de Correção é disciplinada pelo Art. 58-B do CONVÊNIO/SINIEF 06/89: Fica permitida a utilização de carta de correção, para regularização de erro ocorrido na emissão de documentos fiscais relativos à prestação de serviço de transporte, desde que o erro não esteja relacionado com: I - as variáveis que determinam o valor do imposto tais como: base de cálculo, alíquota, diferença de preço, quantidade, valor da prestação;II - a correção de dados cadastrais que implique mudança do emitente, tomador, remetente ou do destinatário;III - a data de emissão ou de saída.";

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfCorrecao implements DFObject, XMLAdapter<InfCorrecao, br.inf.portalfiscal.cte.send400.EvCCeCTe.InfCorrecao> {
                    private String grupoAlterado;
                    private String campoAlterado;
                    private String valorAlterado;
                    private String nroItemAlterado;
                }
            }
        }
    }
}
