package com.softart.dfe.models.internal.xml;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.xml.generic.XML;
import lombok.Builder;

/**
 * XMLStore is a store of XML data.
 */
@Builder
public record XMLStore<T extends XML>(T data, Config config, String xml) implements Store<T> {
}
