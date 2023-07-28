package com.softart.dfe.enums.cte.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum CteDistributionVersion {

    VERSION_100("1.00");

    private final String version;

    CteDistributionVersion(String version) {
        this.version = version;
    }

    public static CteDistributionVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static CteDistributionVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.cte.distribution.version", "1.00"));
    }
}
