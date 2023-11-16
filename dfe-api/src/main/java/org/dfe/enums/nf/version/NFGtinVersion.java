package org.dfe.enums.nf.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum NFGtinVersion {

    VERSION_100("1.00");

    private final String version;

    NFGtinVersion(String version) {
        this.version = version;
    }

    public static NFGtinVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFEventVersion " + version + " does not exists"));
    }

    public static NFGtinVersion getDefault() {
        return valueOfVersion(System.getProperty("org.dfe.nf.gtin.version", "1.00"));
    }
}
