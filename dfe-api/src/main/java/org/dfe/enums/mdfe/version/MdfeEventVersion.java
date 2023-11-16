package org.dfe.enums.mdfe.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MdfeEventVersion {

    VERSION_300("3.00");

    private final String version;

    public static MdfeEventVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static MdfeEventVersion getDefault() {
        return valueOfVersion(System.getProperty("org.dfe.mdfe.event.version", "3.00"));
    }
}
