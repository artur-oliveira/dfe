package com.softart.dfe.models.internal.wsdl;

import com.softart.dfe.interfaces.internal.config.Config;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.xml.ws.BindingProvider;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class ProviderConfig {
    private BindingProvider port;
    private Config config;
    private String overridePortAddress;
}
