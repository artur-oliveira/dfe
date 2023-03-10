package com.softart.dfe.enums.cte.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum CteVersion {

    VERSION_300("3.00");

    private final String version;

    CteVersion(String version) {
        this.version = version;
    }

    public static CteVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static CteVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.cte.version", "3.00"));
    }
}
