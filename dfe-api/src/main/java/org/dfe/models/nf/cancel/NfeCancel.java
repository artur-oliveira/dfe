package org.dfe.models.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEvento;
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
public class NfeCancel implements DFObject, XMLAdapter<NfeCancel, TEvento> {

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
        protected String tpEvento = NFEvent.CANCEL.getCode();
        protected String cOrgao;
        protected String tpAmb;
        protected String cnpj;
        protected String cpf;
        protected String chNFe;
        protected String nSeqEvento;
        protected DetEvento detEvento;
        protected String id;

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
            protected String descEvento = NFEvent.CANCEL.getDescription();
            protected String nProt;
            protected String xJust;
        }
    }

}
