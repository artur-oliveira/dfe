package com.softart.dfe.util;

import java.math.BigInteger;
import java.util.Random;

public final class NumberUtils {

    public final static int DEFAULT_RANDOM_DIGIT = 15;

    private NumberUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * > Generates a random number with the specified number of digits
     *
     * @return A random number of the specified length.
     */
    public static Long random() {
        return random(NumberUtils.DEFAULT_RANDOM_DIGIT);
    }

    /**
     * It returns a random number of the specified length
     *
     * @param digCount The number of digits in the number.
     * @return A random number of the specified length.
     */
    public static Long random(int digCount) {
        return random(digCount, new Random());
    }


    /**
     * It generates a random number of length `digCount` using the `Random` object `rnd`
     *
     * @param digCount The number of digits in the number.
     * @param rnd      A random number generator.
     * @return A random number of length digCount
     */
    public static Long random(final int digCount, Random rnd) {
        final char[] ch = new char[digCount];
        for (int i = 0; i < digCount; i++) {
            ch[i] = (char) ('0' + (i == 0 ? rnd.nextInt(9) + 1 : rnd.nextInt(10)));
        }
        return new BigInteger(new String(ch)).longValueExact();
    }
}
