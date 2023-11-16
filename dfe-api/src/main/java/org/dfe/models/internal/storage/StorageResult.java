package org.dfe.models.internal.storage;

import org.dfe.util.IOUtils;
import lombok.Builder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Builder
public record StorageResult(
        File file,
        String fileName,
        Map<String, Object> properties
) {

    public String read() throws IOException {
        return IOUtils.readFileToString(file());
    }

}
