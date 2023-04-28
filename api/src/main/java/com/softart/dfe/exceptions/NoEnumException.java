package com.softart.dfe.exceptions;

import com.softart.dfe.components.internal.DFEnum;

import java.util.Arrays;

/**
 * It's an unchecked exception that's thrown when a value doesn't match any of the values of an enum
 */
public class NoEnumException extends DfeUncheckedException {

    public NoEnumException(String val, DFEnum.Codeable[] values) {

        super("the value " + val + " does'nt match any of the following values: " + Arrays.asList(values));

    }

}
