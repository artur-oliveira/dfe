package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.xml.generic.XML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Validation is a class that holds a value of type T and a String.
 */
@Getter
@AllArgsConstructor
@ToString
public final class Validation<T extends XML> {
    private final T value;
    private final String xml;
}
