package com.softart.dfe.util;

import com.softart.dfe.exceptions.RequiredException;

import java.util.Objects;

/**
 * The type Require utils.
 */
public final class RequireUtils {
    private RequireUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * If the object is null, throw an exception, otherwise return the object.
     *
     * @param obj The object to check
     * @return A non-null object.
     */
    public static <T> T nonNull(T obj) {
        return nonNull(obj, "Object is required");
    }

    /**
     * If the object is null, throw a RequiredException with the given message, otherwise return the object.
     *
     * @param obj The object to check for null
     * @param msg The message to be displayed when the exception is thrown.
     * @return A non-null object.
     */
    public static <T> T nonNull(T obj, String msg) {
        try {
            return Objects.requireNonNull(obj);
        } catch (NullPointerException e) {
            throw new RequiredException(msg, e);
        }
    }

}
