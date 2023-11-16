package org.dfe.components.internal.xml.context;

import jakarta.xml.bind.JAXBContext;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class DefaultMdfeContext extends MdfeContextFactory {
    public final JAXBContext mdfeContext;
    public final JAXBContext mdfeDistributionContext;

    @SneakyThrows
    DefaultMdfeContext() {
        this.mdfeContext = JAXBContext.newInstance("br.inf.portalfiscal.mdfe.classes");
        this.mdfeDistributionContext = JAXBContext.newInstance("br.inf.portalfiscal.mdfe.distribution");
    }
}
