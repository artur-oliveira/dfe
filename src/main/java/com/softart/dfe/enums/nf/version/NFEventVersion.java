package com.softart.dfe.enums.nf.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum NFEventVersion {

    VERSION_100("1.00");

    private final String version;

    NFEventVersion(String version) {
        this.version = version;
    }

    public static NFEventVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFEventVersion " + version + " does not exists"));
    }

    public static NFEventVersion getDefault() {
        return valueOfVersion(System.getProperty("DEFAULT_NFE_EVENT_VERSION", "1.00"));
    }
}
