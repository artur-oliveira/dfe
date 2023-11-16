package org.dfe.models.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEvento;
import br.inf.portalfiscal.nfe.event_epec.TUf;
import org.dfe.components.internal.ProjectProperties;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.NFAuthor;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
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
public class NfeEpec implements DFObject, XMLAdapter<NfeEpec, TEvento> {

    @Builder.Default
    protected String versao = NFEventVersion.getDefault().getVersion();
    protected InfEvento infEvento;

    @ToString
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InfEvento implements DFObject, XMLAdapter<InfEvento, br.inf.portalfiscal.nfe.event_epec.InfEvento> {

        @Builder.Default
        protected String dhEvento = DateUtils.nowString();

        @Builder.Default
        protected String verEvento = NFEventVersion.getDefault().getVersion();
        @Builder.Default
        protected String tpEvento = NFEvent.EPEC.getCode();
        @Builder.Default
        protected String cOrgao = UF.RFB.getCode();
        protected String tpAmb;
        protected String cnpj;
        protected String cpf;
        protected String chNFe;
        protected String nSeqEvento;
        protected DetEvento detEvento;
        protected String id;

        @Override
        public br.inf.portalfiscal.nfe.event_epec.InfEvento toObject() {
            br.inf.portalfiscal.nfe.event_epec.InfEvento evento = XMLAdapter.super.toObject();
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
        public static class DetEvento implements DFObject, XMLAdapter<DetEvento, br.inf.portalfiscal.nfe.event_epec.DetEvento> {
            @Builder.Default
            protected String versao = NFEventVersion.getDefault().getVersion();
            @Builder.Default
            protected String descEvento = NFEvent.EPEC.getDescription();
            protected String cOrgaoAutor;
            @Builder.Default
            protected String tpAutor = NFAuthor.ISSUER.getCode();
            @Builder.Default
            protected String verAplic = ProjectProperties.projectVersion;
            protected String dhEmi;
            protected String tpNF;
            protected String ie;
            protected Dest dest;

            @ToString
            @Getter
            @Setter
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Dest implements DFObject, XMLAdapter<Dest, br.inf.portalfiscal.nfe.event_epec.EpecDest> {
                protected TUf uf;
                protected String cnpj;
                protected String cpf;
                protected String idEstrangeiro;
                protected String ie;
                protected String vnf;
                protected String vicms;
                protected String vst;
            }
        }
    }

}
