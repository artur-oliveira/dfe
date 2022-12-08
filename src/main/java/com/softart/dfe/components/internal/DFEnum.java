package com.softart.dfe.components.internal;

import com.softart.dfe.exceptions.NoEnumException;

import java.util.Arrays;

public final class DFEnum {

    public static <T extends Codeable> T valueOfCode(T[] values, String code) {
        return Arrays.stream(values).filter(it -> it.getCode().equals(code)).findFirst().orElseThrow(() -> new NoEnumException(code, values));
    }

    public interface Codeable {
        String getCode();

        String getDescription();

        String name();

    }

}
