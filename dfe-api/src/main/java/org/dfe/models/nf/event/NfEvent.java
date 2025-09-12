package org.dfe.models.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEvento;
import lombok.*;
import org.dfe.enums.nf.NFEvent;
import org.dfe.enums.nf.version.NFEventVersion;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.DateUtils;
import org.dfe.util.XMLStringUtils;

import java.util.Optional;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NfEvent implements DFObject, XMLAdapter<NfEvent, TEvento> {

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
        protected String tpEvento;
        protected String cOrgao;
        protected String tpAmb;
        protected String cnpj;
        protected String cpf;
        protected String chNFe;
        protected String nSeqEvento;
        protected Object detEvento;
        protected String id;

        @Override
        public TEvento.InfEvento toObject() {
            TEvento.InfEvento evento = XMLAdapter.super.toObject();
            setId(XMLStringUtils.idEvento(getTpEvento(), getChNFe(), getNSeqEvento()));
            evento.setId(getId());
            return evento;
        }

        @Override
        public InfEvento fromObject(TEvento.InfEvento o) {
            InfEvento evento = XMLAdapter.super.fromObject(o);
            XMLAdapter<?, TEvento.InfEvento.DetEvento> det = switch (getTpEvento()) {
                case "110111" -> new DetCancelEvent();
                case "110112" -> new DetSubstituteCancelEvent();
                case "110110" -> new DetCorrectionLetterEvent();
                case "110140" -> new DetEpecEvent();
                case "110150" -> new DetInterestedActorEvent();
                case "210200", "210210", "210220", "210240" -> new DetManifestationEvent();
                default -> null;
            };
            Optional.ofNullable(det).map(it -> it.fromObject(o.getDetEvento())).ifPresent(evento::setDetEvento);
            return evento;
        }
    }

}
