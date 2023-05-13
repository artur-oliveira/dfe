package com.softart.dfe.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.enums.mdfe.MdfeEvent;
import com.softart.dfe.enums.mdfe.version.MdfeEventVersion;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.XMLStringUtils;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class MdfeClose implements DFObject, XMLAdapter<MdfeClose, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = MdfeEventVersion.getDefault().getVersion();

    public static MdfeClose build(String accessKey, String protocol, String ufCode, String cityCode, String sequence, MdfeConfig conf) {
        return MdfeClose
                .builder()
                .infEvento(InfEvento
                        .builder()
                        .chMDFe(accessKey)
                        .nSeqEvento(sequence)
                        .cnpj(conf.cnpj())
                        .cpf(conf.cpf()).cOrgao(conf.uf().getCode()).tpAmb(conf.environment().getCode()).detEvento(InfEvento.DetEvento
                                .builder()
                                .event(InfEvento.DetEvento.EvEncMDFe
                                        .builder()
                                        .nProt(protocol)
                                        .cuf(ufCode)
                                        .cMun(cityCode)
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
        private String chMDFe;
        @Builder.Default
        private String dhEvento = DateUtils.nowString();
        @Builder.Default
        private String tpEvento = MdfeEvent.CLOSE.getCode();
        private String nSeqEvento;
        private DetEvento detEvento;
        private String id;

        @Override
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChMDFe(), getNSeqEvento()));
            setCnpj(AccessKeyParserFactory.mdfe().cnpj(getChMDFe()));
            setCOrgao(AccessKeyParserFactory.mdfe().uf(getChMDFe()).getCode());

            evento.setId(getId());
            evento.setCNPJ(getCnpj());
            evento.setCOrgao(getCOrgao());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, TEvento.InfEvento.DetEvento> {

            private EvEncMDFe event;

            @Builder.Default
            private String versaoEvento = MdfeEventVersion.getDefault().getVersion();

            @Override
            @SneakyThrows
            public TEvento.InfEvento.DetEvento toObject() {
                TEvento.InfEvento.DetEvento evento = new TEvento.InfEvento.DetEvento();
                evento.setVersaoEvento(getVersaoEvento());
                evento.setAny(MdfeMarshallerFactory.getInstance().toElement(getEvent().toObject()));
                return evento;

            }

            @Override
            public DetEvento fromObject(TEvento.InfEvento.DetEvento o) {
                DetEvento evento = DetEvento.builder().build();
                evento.setVersaoEvento(evento.getVersaoEvento());
                evento.setEvent(EvEncMDFe.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().evEncMDFe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvEncMDFe implements DFObject, XMLAdapter<EvEncMDFe, br.inf.portalfiscal.mdfe.classes.EvEncMDFe> {
                @Builder.Default
                private String dtEnc = DateUtils.nowStringDate();
                private String cuf;
                private String cMun;
                @Builder.Default
                private String descEvento = MdfeEvent.CLOSE.getDescription();
                private String nProt;
            }
        }

    }
}
