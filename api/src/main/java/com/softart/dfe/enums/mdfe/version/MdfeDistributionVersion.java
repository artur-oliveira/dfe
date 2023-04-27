package com.softart.dfe.enums.mdfe.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MdfeDistributionVersion {

    VERSION_300("3.00");

    private final String version;

    public static MdfeDistributionVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static MdfeDistributionVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.mdfe.distribution.version", "3.00"));
    }
}
