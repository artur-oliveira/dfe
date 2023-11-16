package org.dfe.enums.mdfe.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MdfeModalVersion {

    VERSION_300("3.00");

    private final String version;

    public static MdfeModalVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static MdfeModalVersion getDefault() {
        return valueOfVersion(System.getProperty("org.dfe.mdfe.modal.version", "3.00"));
    }
}
