package org.dfe.enums.internal;


public enum KeyType {
    PFX("PKCS12"), JKS("JKS");

    private final String type;

    KeyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}