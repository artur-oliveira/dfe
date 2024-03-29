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
public final class MdfePaymentModification implements DFObject, XMLAdapter<MdfePaymentModification, TEvento> {
    private InfEvento infEvento;

    @Builder.Default
    private String versao = MdfeEventVersion.getDefault().getVersion();

    public static MdfePaymentModification build(String accessKey, String protocol, String sequence, List<InfEvento.DetEvento.EvAlteracaoPagtoServMDFe.InfPag> infoPayments, MdfeConfig conf) {
        return MdfePaymentModification
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
                                        .EvAlteracaoPagtoServMDFe
                                        .builder()
                                        .nProt(protocol)
                                        .infPag(infoPayments)
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
        private String tpEvento = MdfeEvent.PAYMENT_MODIFICATION.getCode();
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

            private EvAlteracaoPagtoServMDFe event;

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
                evento.setEvent(EvAlteracaoPagtoServMDFe.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().evAlteracaoPagtoServMDFe(o.getAny()).getValue()));
                return evento;
            }

            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            @Builder
            public static final class EvAlteracaoPagtoServMDFe implements DFObject, XMLAdapter<EvAlteracaoPagtoServMDFe, br.inf.portalfiscal.mdfe.classes.EvAlteracaoPagtoServMDFe> {
                private List<InfPag> infPag;
                @Builder.Default
                private String descEvento = MdfeEvent.PAYMENT_MODIFICATION.getDescription();
                private String nProt;

                @Data
                @AllArgsConstructor
                @NoArgsConstructor
                @Builder
                public static final class InfPag implements DFObject, XMLAdapter<InfPag, br.inf.portalfiscal.mdfe.classes.EvAlteracaoPagtoServMDFe.InfPag> {
                    private String xNome;
                    private String cpf;
                    private String cnpj;
                    private String idEstrangeiro;
                    private List<Comp> comp;
                    private String vContrato;
                    private String indPag;
                    private String vAdiant;
                    private String indAntecipaAdiant;
                    private List<InfPrazo> infPrazo;
                    private String tpAntecip;
                    private InfBanc infBanc;


                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class Comp implements DFObject, XMLAdapter<Comp, br.inf.portalfiscal.mdfe.classes.EvAlteracaoPagtoServMDFe.InfPag.Comp> {
                        private String tpComp;
                        private String vComp;
                        private String xComp;
                    }

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class InfPrazo implements DFObject, XMLAdapter<InfPrazo, br.inf.portalfiscal.mdfe.classes.EvAlteracaoPagtoServMDFe.InfPag.InfPrazo> {
                        private String nParcela;
                        private String dVenc;
                        private String vParcela;
                    }

                    @Data
                    @AllArgsConstructor
                    @NoArgsConstructor
                    @Builder
                    public static final class InfBanc implements DFObject, XMLAdapter<InfBanc, br.inf.portalfiscal.mdfe.classes.EvAlteracaoPagtoServMDFe.InfPag.InfBanc> {
                        private String codBanco;
                        private String codAgencia;
                        private String cnpjipef;
                        private String pix;
                    }
                }

            }
        }

    }
}
