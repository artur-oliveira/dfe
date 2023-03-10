package com.softart.dfe.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * If the text is null, return null, otherwise return the text with all non-digits removed.
     *
     * @param text The text to extract the digits from.
     * @return A string with all non-digit characters removed.
     */
    public static String extractDigits(Object text) {
        if (Objects.isNull(text)) return null;
        return text.toString().replaceAll("\\D+", empty());
    }

    /**
     * It returns an empty string
     *
     * @return An empty string.
     */
    public static String empty() {
        return "";
    }

    /**
     * "Concatenate the string representations of the given arguments."
     * <p>
     * The @SafeVarargs annotation is a compile-time annotation that tells the compiler that the annotated method is safe
     * to use with generics
     *
     * @return A String
     */
    @SafeVarargs
    public static <T extends CharSequence> String concat(T... args) {
        return Arrays.stream(args).map(Objects::toString).collect(Collectors.joining(""));
    }

    /**
     * > It takes a string, and pads it with zeros on the left until it reaches the desired length
     *
     * @param text The text to be padded.
     * @param len  The length of the string you want to return.
     * @return A string with the text padded with zeros to the left.
     */
    public static String padZeroStart(Object text, int len) {
        return padStart(text.toString(), len, '0');
    }

    /**
     * Return the string '0'.
     *
     * @return A string of "0"
     */
    public static String zero() {
        return "0";
    }

    /**
     * If you want to create a BigDecimal with a value of zero, you can use the zero() function.
     *
     * @param scale The number of digits to the right of the decimal point.
     * @return A string representation of a BigDecimal with a value of 0 and a scale of the value passed in.
     */
    public static String zero(int scale) {
        return BigDecimal.valueOf(0L).setScale(scale, RoundingMode.HALF_EVEN).toString();
    }

    /**
     * "If the text is null, return null, otherwise return the text in upper case."
     * <p>
     *
     * @param text The text to convert to upper case.
     * @return A string that is the uppercase version of the text.
     */
    public static String upper(Object text) {
        if (Objects.isNull(text)) return null;
        return text.toString().toUpperCase(Locale.ROOT);
    }

    /**
     * "If the text is null, return null, otherwise return the text in lower case."
     * <p>
     *
     * @param text The text to convert to lower case.
     * @return A string that is the lowercase version of the text.
     */
    public static String lower(Object text) {
        if (Objects.isNull(text)) return null;
        return text.toString().toLowerCase(Locale.ROOT);
    }


    /**
     * Generates a random number with the specified number of digits
     * <p>
     *
     * @return A random number of the specified length as a string
     * @see NumberUtils
     */
    public static String random() {
        return String.valueOf(NumberUtils.random());
    }

    /**
     * It returns a random number of the specified length as a string
     * <p>
     *
     * @param digCount The number of digits in the random number.
     * @return A random number of the specified length as a string
     * @see NumberUtils
     */
    public static String random(int digCount) {
        return String.valueOf(NumberUtils.random(digCount));
    }

    /**
     * If the length of the text is less than the length of the string, pad the start of the string with the pad character
     * until the length of the string is equal to the length of the text.
     *
     * @param text    The text to pad.
     * @param len     The length of the resulting string.
     * @param padChar The character to pad with.
     * @return A string
     */
    public static <T extends CharSequence> String padStart(T text, int len, Character padChar) {
        Objects.requireNonNull(text, "cannot padStart null sequence");
        if (len < 0) throw new IllegalArgumentException("length is less than zero.");
        if (len <= text.length()) return text.subSequence(0, text.length()).toString();

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len - text.length(); i++) sb.append(padChar);
        sb.append(text);

        return sb.toString();
    }


}
