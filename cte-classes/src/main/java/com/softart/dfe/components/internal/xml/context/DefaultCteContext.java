package com.softart.dfe.components.internal.xml.context;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import jakarta.xml.bind.JAXBContext;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class DefaultCteContext extends CteContextFactory {
    public final JAXBContext cteSendContext;
    public final JAXBContext cteDistributionContext;

    @SneakyThrows
    DefaultCteContext() {
        this.cteSendContext = JAXBContext.newInstance("br.inf.portalfiscal.cte.send");
        this.cteDistributionContext = JAXBContext.newInstance("br.inf.portalfiscal.cte.distribution");
    }
}
