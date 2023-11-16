package org.dfe.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DecimalUtils {
    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `DecimalUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private DecimalUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static String format(BigDecimal o, int scale) {
        return format(o, scale, RoundingMode.HALF_EVEN);
    }

    public static String format(BigDecimal o, int scale, RoundingMode mode) {
        return o.setScale(scale, mode).toString();
    }

}
