package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.xml.XML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * It's a container for a value of type `T` and a string that represents the XML that was used to create the value
 */
@Getter
@AllArgsConstructor
@ToString
public final class Validation<T extends XML> {
    private final T value;
    private final String xml;
}
