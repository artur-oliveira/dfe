package org.dfe.enums.cte.version;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum CteVersion {

    VERSION_300("3.00") {
        @Override
        public String xsdRootPath() {
            return "xsds/cte/PL_CTe_300a_NT2022.001";
        }
    },
    VERSION_400("4.00") {
        @Override
        public String xsdRootPath() {
            return "xsds/cte/PL_CTe_400";
        }
    };

    private final String version;

    CteVersion(String version) {
        this.version = version;
    }

    public static CteVersion valueOfVersion(String version) {
        return Arrays.stream(values()).filter(it -> Objects.equals(it.getVersion(), version)).findFirst().orElseThrow(() -> new IllegalArgumentException("CteVersion " + version + " does not exists"));
    }

    public static CteVersion getDefault() {
        return valueOfVersion(System.getProperty("org.dfe.cte.version", "3.00"));
    }

    public abstract String xsdRootPath();

    public String getXsdPath(String xsdName) {
        return xsdRootPath() + "/" + xsdName + getVersion() + ".xsd";
    }
}
