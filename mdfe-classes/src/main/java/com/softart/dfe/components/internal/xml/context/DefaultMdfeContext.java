package com.softart.dfe.components.internal.xml.context;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import jakarta.xml.bind.JAXBContext;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
final class DefaultMdfeContext extends MdfeContextFactory {
    public final JAXBContext mdfeContext;

    @SneakyThrows
    DefaultMdfeContext() {
        this.mdfeContext = JAXBContext.newInstance("br.inf.portalfiscal.mdfe.classes");
    }
}
