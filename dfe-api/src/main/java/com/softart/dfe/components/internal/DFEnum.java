package com.softart.dfe.components.internal;

import com.softart.dfe.exceptions.NoEnumException;

import java.util.Arrays;

public final class DFEnum {

    /**
     * If the code is found in the array of values, return the value, otherwise throw an exception.
     *
     * @param values The array of enum values
     * @param code   The code to be matched
     * @return A stream of the values array.
     */
    public static <T extends Codeable> T valueOfCode(T[] values, String code) {
        return Arrays.stream(values).filter(it -> it.getCode().equals(code) || it.name().equals(code)).findFirst().orElseThrow(() -> new NoEnumException(code, values));
    }

    public interface Codeable {
        /**
         * Returns the code of the object.
         *
         * @return The code of the current object.
         */
        String getCode();

        /**
         * Returns a description of the object.
         *
         * @return A string.
         */
        String getDescription();

        /**
         * Returns the name of the current object.
         *
         * @return The name of the object.
         */
        String name();

        /**
         * Returns the code as a long.
         *
         * @return The code as a long.
         */
        default long getCodeAsLong() {
            return Long.parseLong(getCode());
        }

        /**
         * Returns the code as an integer.
         *
         * @return The code as an integer.
         */
        default int getCodeAsInt() {
            return Integer.parseInt(getCode());
        }

    }

}
