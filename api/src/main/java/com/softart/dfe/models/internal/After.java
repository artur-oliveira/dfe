package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.xml.generic.XML;
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
