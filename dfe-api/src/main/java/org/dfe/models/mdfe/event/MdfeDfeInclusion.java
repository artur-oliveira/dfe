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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class MdfeDfeInclusion implements DFObject, XMLAdapter<MdfeDfeInclusion, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = MdfeEventVersion.getDefault().getVersion();

    public static MdfeDfeInclusion build(String accessKey, String protocol, String cityLoadingCode, String cityLoadingDescription, List<InfEvento.DetEvento.EvIncDFeMDFe.InfDoc> documents, String sequence, MdfeConfig conf) {
        return MdfeDfeInclusion
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
                                        .EvIncDFeMDFe
                                        .builder()
                                        .nProt(protocol)
                                        .cMunCarrega(cityLoadingCode)
                                        .xMunCarrega(cityLoadingDescription)
                                        .infDoc(documents)
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
        private String tpEvento = MdfeEvent.DFE_INCLUSION.getCode();
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

            private EvIncDFeMDFe event;

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
                evento.setEvent(EvIncDFeMDFe.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().evIncDFeMDFe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvIncDFeMDFe implements DFObject, XMLAdapter<EvIncDFeMDFe, br.inf.portalfiscal.mdfe.classes.EvIncDFeMDFe> {
                @Builder.Default
                private String descEvento = MdfeEvent.DFE_INCLUSION.getDescription();
                private String nProt;
                private String cMunCarrega;
                private String xMunCarrega;
                private List<InfDoc> infDoc;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfDoc implements DFObject, XMLAdapter<InfDoc, br.inf.portalfiscal.mdfe.classes.EvIncDFeMDFe.InfDoc> {
                    private String cMunDescarga;
                    private String xMunDescarga;
                    private String chNFe;
                }
            }
        }

    }
}
