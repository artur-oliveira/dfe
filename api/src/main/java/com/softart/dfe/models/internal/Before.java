package com.softart.dfe.models.internal;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.xml.generic.XML;

public record Before<REQ extends XML>(REQ request, Config config) implements BeforeRequest<REQ> {
}
