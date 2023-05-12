package com.softart.dfe.models.internal.storage;

import lombok.Builder;

import java.io.File;
import java.util.Map;

@Builder
public record StorageResult(
        File file,
        String fileName,
        Map<String, Object> properties
) {
}
