package org.dfe.util;

import org.dfe.exceptions.DfeOptionalException;

/**
 * The type Require utils.
 */
public final class RequireUtils {
    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `RequireUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
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
        return DfeOptional.ofCondition(obj != null, obj).orElseThrow(() -> new DfeOptionalException(msg));
    }

}
