package org.dfe.models.internal;

import org.dfe.interfaces.xml.generic.XML;
import lombok.Builder;

/**
 * Validation is a class that holds a value of type T and a String.
 */
@Builder
public record Validation<T extends XML>(
        T value,
        String xml
) {
}
