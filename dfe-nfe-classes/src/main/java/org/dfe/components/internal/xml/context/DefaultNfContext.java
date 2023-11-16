package org.dfe.components.internal.xml.context;

import jakarta.xml.bind.JAXBContext;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class DefaultNfContext extends NfContextFactory {

    public final JAXBContext nfeEventContext;
    public final JAXBContext nfeCancelContext;
    public final JAXBContext nfeSubstituteCancelContext;
    public final JAXBContext nfeSendContext;
    public final JAXBContext nfeDistributionContext;
    public final JAXBContext nfeManifestationContext;
    public final JAXBContext nfeEpecContext;
    public final JAXBContext nfeCorrectionLetterContext;
    public final JAXBContext nfeInterestedActorContext;
    public final JAXBContext nfeGtinContext;

    @SneakyThrows
    DefaultNfContext() {
        // EVENT

        this.nfeEventContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_generic");
        // CANCEL
        this.nfeCancelContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_cancel");

        // SUBSTITUTE CANCEL
        this.nfeSubstituteCancelContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_substitute_cancel");

        // SEND
        this.nfeSendContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.send");

        // DISTRIBUTION
        this.nfeDistributionContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.distribution");

        // MANIFESTATION
        this.nfeManifestationContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_manifestation");

        // EPEC
        this.nfeEpecContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_epec");

        // CORRECTION LETTER
        this.nfeCorrectionLetterContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_correction_letter");

        // INTERESTED ACTOR
        this.nfeInterestedActorContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_interested_actor");

        // GTIN
        this.nfeGtinContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.gtin");
    }

}