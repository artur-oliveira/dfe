package org.dfe.util;

import org.dfe.exceptions.DfeUncheckedException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public final class StringUtils {

    private static final String EMPTY = "";

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `StringUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
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
        return EMPTY;
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
     * It takes a string, and pads it with zeros on the left until it reaches the desired length
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
     *
     * @return A random number of the specified length as a string
     * @see NumberUtils
     */
    public static String random() {
        return String.valueOf(NumberUtils.random());
    }

    /**
     * It returns a random number of the specified length as a string
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
        Optional.ofNullable(text).orElseThrow(() -> new DfeUncheckedException("cannot padStart null sequence"));
        if (len < 0) throw new DfeUncheckedException("length is less than zero.");
        if (len <= text.length()) return text.subSequence(0, text.length()).toString();

        return String.valueOf(padChar).repeat(Math.max(0, len - text.length())) + text;
    }

    /**
     * The function "normalize" takes a string input and returns a normalized version of the string using the NFKD
     * normalization form, or null if the input is null.
     *
     * @param input The input parameter is a string that you want to normalize.
     * @return The method is returning a normalized version of the input string.
     */
    private static String normalize(String input) {
        return Optional.ofNullable(input).map((it) -> Normalizer.normalize(it, Normalizer.Form.NFKD)).orElse(null);
    }

    /**
     * The function converts a string to its ASCII representation by removing any diacritical marks.
     *
     * @param input The input parameter is a string that represents the text that you want to convert to ASCII.
     * @return The method is returning a String.
     */
    public static String toAscii(String input) {
        return Optional.ofNullable(normalize(input)).map(it -> it.replaceAll("\\p{M}", "")).orElse(null);
    }


}
