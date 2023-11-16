package org.dfe.models.internal.xml;

import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.xml.generic.XML;
import lombok.Builder;

/**
 * XMLStore is a store of XML data.
 */
@Builder
public record XMLStore<T extends XML>(T data, Config config, String xml) implements Store<T> {
}
