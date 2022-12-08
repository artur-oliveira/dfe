package com.softart.dfe.exceptions;

import com.softart.dfe.components.internal.DFEnum;

import java.util.Arrays;

public class NoEnumException extends DFUncheckedException {

    public NoEnumException(String val, DFEnum.Codeable[] values) {

        super("the value " + val + " does'nt match any of the following values: " + Arrays.asList(values));

    }

}
