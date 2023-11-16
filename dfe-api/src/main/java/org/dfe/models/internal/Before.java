package org.dfe.models.internal;

import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.xml.generic.XML;
import lombok.Builder;

@Builder
public record Before<REQ extends XML>(
        REQ request,
        Config config
) implements BeforeRequest<REQ> {
}
