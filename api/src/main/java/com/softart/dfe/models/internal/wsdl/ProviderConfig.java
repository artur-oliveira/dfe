package com.softart.dfe.models.internal.wsdl;

import com.softart.dfe.interfaces.internal.config.Config;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.ws.BindingProvider;

@Builder
public record ProviderConfig(
        BindingProvider port,
        Config config,
        String overridePortAddress
) {
}
