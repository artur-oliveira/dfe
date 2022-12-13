package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.xml.generic.XML;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * It's a simple data class that holds the request and the config
 */
@Getter
@AllArgsConstructor
@ToString
public final class Before<REQ extends XML> implements BeforeRequest<REQ> {
    private final REQ request;
    private final Config config;
}
