package org.dfe.models.internal;

import org.dfe.interfaces.internal.config.Config;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.xml.generic.XML;
import lombok.Builder;

/**
 * It's a data class that holds the request, response, and config
 */
@Builder
public record After<REQ extends XML, RES extends XML>(
        REQ request,
        RES response,
        Config config
) implements AfterRequest<REQ, RES> {
}
