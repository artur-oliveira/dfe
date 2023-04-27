package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.xml.generic.XML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * It's a data class that holds the request, response, and config
 */
@Getter
@AllArgsConstructor
@ToString
public final class After<REQ extends XML, RES extends XML> implements AfterRequest<REQ, RES> {
    private final REQ request;
    private final RES response;
    private final Config config;
}
