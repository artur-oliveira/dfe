package org.dfe.models.internal.xml;

import jakarta.xml.bind.JAXBElement;
import lombok.Builder;

@Builder
public record NamespaceCleaner(
        String xml,
        String rootNamespace,
        JAXBElement<?> jaxbElement
) {
}
