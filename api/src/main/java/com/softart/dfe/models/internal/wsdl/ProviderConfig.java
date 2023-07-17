package com.softart.dfe.models.internal.wsdl;

import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.xml.XMLNodeCleaner;
import jakarta.xml.ws.BindingProvider;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
public record ProviderConfig(
        BindingProvider port,
        Config config,
        String overridePortAddress,
        List<XMLNodeCleaner> customResponseNodeCleaners
) {
    public List<XMLNodeCleaner> customResponseNodeCleaners() {
        return Optional.ofNullable(this.customResponseNodeCleaners).orElseGet(ArrayList::new);
    }

}
