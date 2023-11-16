package org.dfe.models.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEvento;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.nf.NFAuthor;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.XMLStringUtils;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfceSubstituteCancel implements DFObject, XMLAdapter<NfceSubstituteCancel, TEvento> {

    @Builder.Default
    protected String versao = NFEventVersion.getDefault().getVersion();
    protected InfEvento infEvento;

    @ToString
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfEvento implements DFObject, XMLAdapter<InfEvento, TEvento.InfEvento> {

        @Builder.Default
        protected String dhEvento = DateUtils.nowString();

        @Builder.Default
        protected String verEvento = NFEventVersion.getDefault().getVersion();
        @Builder.Default
        protected String tpEvento = NFEvent.SUBSTITUTE_CANCEL.getCode();
        protected String cOrgao;
        protected String tpAmb;
        protected String cnpj;
        protected String cpf;
        protected String chNFe;
        protected String nSeqEvento;
        protected DetEvento detEvento;
        protected String id;

        public static NfceSubstituteCancel.InfEvento build(String accessKey, String accessKeyRef, String protocol, String justification, String sequence, Config conf) {
            return NfceSubstituteCancel
                    .InfEvento
                    .builder()
                    .chNFe(accessKey)
                    .nSeqEvento(sequence)
                    .cnpj(conf.cnpj())
                    .cpf(conf.cpf())
                    .cOrgao(conf.uf().getCode())
                    .tpAmb(conf.environment().getCode())
                    .detEvento(NfceSubstituteCancel.InfEvento.DetEvento
                            .builder()
                            .chNFeRef(accessKeyRef)
                            .cOrgaoAutor(conf.uf().getCode())
                            .nProt(protocol)
                            .xJust(justification)
                            .build())
                    .build();
        }

        @Override
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChNFe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @ToString
        @Getter
        @Setter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class DetEvento implements DFObject, XMLAdapter<DetEvento, TEvento.InfEvento.DetEvento> {
            @Builder.Default
            protected String versao = NFEventVersion.getDefault().getVersion();
            @Builder.Default
            protected String descEvento = NFEvent.SUBSTITUTE_CANCEL.getDescription();
            protected String cOrgaoAutor;
            @Builder.Default
            protected String tpAutor = NFAuthor.ISSUER.getCode();
            @Builder.Default
            protected String verAplic = ProjectProperties.displayVersion();
            protected String nProt;
            protected String xJust;
            protected String chNFeRef;
        }
    }

}
