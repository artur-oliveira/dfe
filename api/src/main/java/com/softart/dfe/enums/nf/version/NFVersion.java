package com.softart.dfe.enums.nf.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum NFVersion {

    VERSION_400("4.00");

    private final String version;

    NFVersion(String version) {
        this.version = version;
    }

    public static NFVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFEventVersion " + version + " does not exists"));
    }

    public static NFVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.nf.version", "4.00"));
    }
}
