package org.dfe.enums.nf.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum NFQueryRegisterVersion {

    VERSION_200("2.00");

    private final String version;

    public static NFQueryRegisterVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("NFQueryRegisterVersion " + version + " does not exists"));
    }

    public static NFQueryRegisterVersion getDefault() {
        return valueOfVersion(System.getProperty("org.dfe.nf.query_register.version", "2.00"));
    }
}
