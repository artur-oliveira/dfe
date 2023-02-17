package com.softart.dfe.enums.mdfe.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MdfeVersion {

    VERSION_300("3.00");

    private final String version;

    public static MdfeVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static MdfeVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.mdfe.version", "3.00"));
    }
}
