package com.softart.dfe.util;

import java.util.*;

public final class Functions {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `Functions` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private Functions() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * If the object is null, or if it's an array, collection, enumeration, iterable, iterator, map, or string, and it's
     * empty, then it's null or empty
     *
     * @param o The object to check.
     * @return A boolean value.
     */
    public static boolean isNullOrEmpty(Object o) {
        if (Objects.isNull(o)) return true;
        if (o instanceof Object[]) return ((Object[]) o).length == 0;
        else if (o instanceof CharSequence) return o.toString().isEmpty();
        else if (o instanceof Collection) return ((Collection<?>) o).isEmpty();
        else if (o instanceof Enumeration) return ((Enumeration<?>) o).hasMoreElements();
        else if (o instanceof Iterable) return ((Iterable<?>) o).iterator().hasNext();
        else if (o instanceof Iterator) return ((Iterator<?>) o).hasNext();
        else if (o instanceof Map) return ((Map<?, ?>) o).size() == 0;
        return o.toString().isEmpty();
    }

    /**
     * Return the first non-null argument, or null if all arguments are null.
     *
     * @param <T>  Generic Type
     * @param args Any Arguments
     * @return The first non-null value in the array.
     */
    @SafeVarargs
    public static <T> T coalesce(T... args) {
        return Arrays.stream(args).filter(Objects::nonNull).findFirst().orElse(null);
    }
}
