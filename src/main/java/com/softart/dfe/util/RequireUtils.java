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
     * Non null t.
     *
     * @param <T> the type parameter
     * @param obj the obj
     * @return the t
     */
    public static <T> T nonNull(T obj) {
        return nonNull(obj, "Object is required");
    }

    /**
     * Non null t.
     *
     * @param <T> the type parameter
     * @param obj the obj
     * @return the t
     */
    public static <T> T nonNull(T obj, String msg) {
        try {
            return Objects.requireNonNull(obj);
        } catch (NullPointerException e) {
            throw new RequiredException(msg, e);
        }
    }

}
