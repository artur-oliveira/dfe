package org.dfe.models.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import org.dfe.enums.mdfe.MdfeEvent;
import org.dfe.enums.mdfe.version.MdfeEventVersion;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.XMLStringUtils;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class MdfeDriverInclusion implements DFObject, XMLAdapter<MdfeDriverInclusion, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = MdfeEventVersion.getDefault().getVersion();

    public static MdfeDriverInclusion build(String accessKey, String name, String cpf, String sequence, MdfeConfig conf) {
        return build(accessKey, InfEvento.DetEvento.EvIncCondutorMDFe.Condutor.builder().xNome(name).cpf(cpf).build(), sequence, conf);
    }

    public static MdfeDriverInclusion build(String accessKey, InfEvento.DetEvento.EvIncCondutorMDFe.Condutor condutor, String sequence, MdfeConfig conf) {
        return MdfeDriverInclusion
                .builder()
                .infEvento(InfEvento
                        .builder()
                        .chMDFe(accessKey)
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
                                        .EvIncCondutorMDFe
                                        .builder()
                                        .condutor(condutor)
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
        private String tpEvento = MdfeEvent.DRIVER_INCLUSION.getCode();
        private String nSeqEvento;
        private DetEvento detEvento;
        private String id;

        @Override
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChMDFe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static final class DetEvento implements DFObject, XMLAdapter<DetEvento, TEvento.InfEvento.DetEvento> {

            private EvIncCondutorMDFe event;

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
                evento.setEvent(EvIncCondutorMDFe.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().evIncCondutorMDFe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvIncCondutorMDFe implements DFObject, XMLAdapter<EvIncCondutorMDFe, br.inf.portalfiscal.mdfe.classes.EvIncCondutorMDFe> {
                @Builder.Default
                private String descEvento = MdfeEvent.DRIVER_INCLUSION.getDescription();
                private Condutor condutor;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class Condutor implements DFObject, XMLAdapter<Condutor, br.inf.portalfiscal.mdfe.classes.EvIncCondutorMDFe.Condutor> {
                    private String xNome;
                    private String cpf;
                }

            }
        }

    }
}
