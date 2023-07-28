package com.softart.dfe.enums.nf.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum NFDistributionVersion {

    VERSION_1_01("1.01");

    private final String version;

    NFDistributionVersion(String version) {
        this.version = version;
    }

    public static NFDistributionVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFDistributionVersion " + version + " does not exists"));
    }

    public static NFDistributionVersion getDefault() {
        return valueOfVersion(System.getProperty("com.softart.dfe.nf.distribution.version", "1.01"));
    }
}
