package com.softart.dfe.models.internal.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class StorageResult {
    private File file;
    private String fileName;
    @Builder.Default
    private Map<String, Object> properties = new HashMap<>();
}
