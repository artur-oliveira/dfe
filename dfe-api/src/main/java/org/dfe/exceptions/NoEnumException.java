package org.dfe.exceptions;

import org.dfe.components.internal.DFEnum;

import java.util.Arrays;


/**
 * The NoEnumException class extends DfeUncheckedException and throws an exception when a given value does not match any of
 * the specified values in an array.
 */
public class NoEnumException extends DfeUncheckedException {

    private final String value;

    public NoEnumException(String val, DFEnum.Codeable[] values) {
        super("the value " + val + " does'nt match any of the following values: " + Arrays.asList(values));
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
