package com.softart.dfe.models.internal.xml;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.xml.generic.XML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * XMLStore is a store of XML data.
 */
@Getter
@AllArgsConstructor
@ToString
public final class XMLStore<T extends XML> implements Store<T> {
    private final T data;
    private final Config config;
    private final String xml;
}
