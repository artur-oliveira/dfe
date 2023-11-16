package org.dfe.models.internal.storage;

import org.dfe.interfaces.internal.config.Config;

public record RootPath(
        Config config,
        String key
) {
}
