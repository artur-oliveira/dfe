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
    public final JAXBContext nfeSendContext;
    public final JAXBContext nfeDistributionContext;
    public final JAXBContext nfeGtinContext;

    @SneakyThrows
    DefaultNfContext() {
        // EVENT

        this.nfeEventContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.event_generic");
        // SEND
        this.nfeSendContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.send");

        // DISTRIBUTION
        this.nfeDistributionContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.distribution");
        // GTIN
        this.nfeGtinContext = JAXBContext.newInstance("br.inf.portalfiscal.nfe.gtin");
    }

}
