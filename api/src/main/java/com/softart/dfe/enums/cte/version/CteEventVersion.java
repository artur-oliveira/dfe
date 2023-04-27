package com.softart.dfe.enums.cte.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum CteEventVersion {

    VERSION_300("3.00");

    private final String version;

    CteEventVersion(String version) {
        this.version = version;
    }

    public static CteEventVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFEventVersion " + version + " does not exists"));
    }

    public static CteEventVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.cte.event.version", "3.00"));
    }
}
