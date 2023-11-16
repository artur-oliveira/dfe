package org.dfe.components.internal.xml.context;

import jakarta.xml.bind.JAXBContext;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class DefaultCteContext extends CteContextFactory {
    public final JAXBContext cteSendContext;
    public final JAXBContext cte400SendContext;
    public final JAXBContext cteDistributionContext;

    @SneakyThrows
    DefaultCteContext() {
        this.cteSendContext = JAXBContext.newInstance("br.inf.portalfiscal.cte.send");
        this.cte400SendContext = JAXBContext.newInstance("br.inf.portalfiscal.cte.send400");
        this.cteDistributionContext = JAXBContext.newInstance("br.inf.portalfiscal.cte.distribution");
    }
}
