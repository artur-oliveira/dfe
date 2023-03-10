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
import com.softart.dfe.util.XMLStringUtils;
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
    private String versao = CteEventVersion.getDefault().getVersion();

    public static CteCorrectionLetter build(String accessKey, List<InfEvento.DetEvento.EvCCeCTe.InfCorrecao> corrections, String sequence, CteConfig conf) {
        return CteCorrectionLetter
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
    public static final class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.cte.send.InfEvento> {
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

            private EvCCeCTe event;

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
                evento.setEvent(EvCCeCTe.builder().build().fromObject(CteUnmarshallerFactory.getInstance().evCCeCTe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvCCeCTe implements DFObject, XMLAdapter<EvCCeCTe, br.inf.portalfiscal.cte.send.EvCCeCTe> {
                @Builder.Default
                private String descEvento = CteEvent.CORRECTION_LETTER.getDescription();

                @Builder.Default
                private List<InfCorrecao> infCorrecao = new ArrayList<>();
                @Builder.Default
                private String xCondUso = "A Carta de Corre????o ?? disciplinada pelo Art. 58-B do CONV??NIO/SINIEF 06/89: Fica permitida a utiliza????o de carta de corre????o, para regulariza????o de erro ocorrido na emiss??o de documentos fiscais relativos ?? presta????o de servi??o de transporte, desde que o erro n??o esteja relacionado com: I - as vari??veis que determinam o valor do imposto tais como: base de c??lculo, al??quota, diferen??a de pre??o, quantidade, valor da presta????o;II - a corre????o de dados cadastrais que implique mudan??a do emitente, tomador, remetente ou do destinat??rio;III - a data de emiss??o ou de sa??da.";

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfCorrecao implements DFObject, XMLAdapter<InfCorrecao, br.inf.portalfiscal.cte.send.InfCorrecao> {
                    private String grupoAlterado;
                    private String campoAlterado;
                    private String valorAlterado;
                    private String nroItemAlterado;
                }
            }
        }
    }
}
