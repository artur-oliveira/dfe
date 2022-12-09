package com.softart.dfe.util;

import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public final class DateUtils {

    public final static String yyMM = "yyMM";
    public final static String ISO = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public final static String ISO_DATE = "yyyy-MM-dd";
    private final static Map<String, DateTimeFormatter> formatters = new HashMap<>();

    static {
        formatters.put(yyMM, DateTimeFormatter.ofPattern(yyMM));
        formatters.put(ISO, DateTimeFormatter.ofPattern(ISO));
        formatters.put(ISO_DATE, DateTimeFormatter.ofPattern(ISO_DATE));
    }

    private DateUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * Convert a string to a ZonedDateTime using the ISO_DATE_TIME formatter.
     *
     * @param d The date string to parse.
     * @return A ZonedDateTime object
     */
    public static ZonedDateTime zoned(String d) {
        return zoned(d, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    /**
     * Convert a string to a ZonedDateTime object using the specified formatter.
     *
     * @param d         The date string to parse.
     * @param formatter The formatter to use.
     * @return A ZonedDateTime object
     */
    public static ZonedDateTime zoned(String d, DateTimeFormatter formatter) {
        return ZonedDateTime.parse(d, formatter);
    }

    /**
     * Return the current month as a string.
     *
     * @return The current month as a String.
     */
    public static String currentMonth() {
        return month(YearMonth.now());
    }

    /**
     * Given a temporal, return the month as a string.
     *
     * @param temporal The temporal object to format.
     * @return The month of the year.
     */
    public static String month(Temporal temporal) {
        return String.valueOf(temporal.get(ChronoField.MONTH_OF_YEAR));
    }

    /**
     * It returns the current year.
     *
     * @return The current year
     */
    public static String currentyear() {
        return String.valueOf(YearMonth.now().get(ChronoField.YEAR));
    }


    /**
     * Given a Temporal object, return the year as a String.
     *
     * @param temporal The temporal object to format.
     * @return The year of the temporal object.
     */
    public static String year(Temporal temporal) {
        return String.valueOf(temporal.get(ChronoField.YEAR));
    }

    /**
     * It takes a date in the format of `yyyy-MM-dd HH:mm:ss.SSSZ` and returns the year in the format of `yy`
     *
     * @param date The date to be formatted.
     * @return The last two digits of the year.
     */
    public static String twoDigitsyear(String date) {
        return twoDigitsyear(zoned(date));
    }

    /**
     * "Given a temporal, return the last two digits of the year."
     * <p>
     *
     * @param temporal The temporal object to format.
     * @return The last two digits of the year.
     */
    public static String twoDigitsyear(Temporal temporal) {
        return DateUtils.year(temporal).substring(2, 4);
    }

    /**
     * "Given a date, return the month as a two digit string."
     * <p>
     *
     * @param date The date to be formatted.
     * @return The month of the date in two digits.
     */
    public static String twoDigitsMonth(String date) {
        return twoDigitsMonth(zoned(date));
    }

    /**
     * "Given a temporal, return the month as a two digit string."
     *
     * @param temporal The temporal object to format.
     * @return A string of the month in two digits.
     */
    public static String twoDigitsMonth(Temporal temporal) {
        return StringUtils.padZeroStart(month(temporal), 2);
    }

    /**
     * > It takes a date in the format of `yyyy-MM-dd HH:mm:ss.SSSZ` and returns a string in the format of `yyMM`
     *
     * @param zonedDate The date in the format of "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
     * @return The year and month of the date in the format yyMM.
     */
    public static String yyMM(String zonedDate) {
        return yyMM(zoned(zonedDate));
    }

    /**
     * > It returns a string representation of the given temporal object in the format of `yyMM`
     *
     * @param temporal The temporal object to format.
     * @return A string representation of the date in the format yyMM.
     */
    public static String yyMM(Temporal temporal) {
        return DateUtils.formatters.get(DateUtils.yyMM).format(temporal);
    }

    /**
     * Returns the current date and time in the system's default time zone.
     *
     * @return A ZonedDateTime object representing the current date and time.
     */
    public static ZonedDateTime now() {
        return ZonedDateTime.now();
    }

    /**
     * It returns a string representation of the current time in the ISO 8601 format.
     *
     * @return A string representation of the current date and time.
     */
    public static String nowString() {
        return format(now(), ISO);
    }

    /**
     * It returns a string representation of the current time in the ISO 8601 format.
     *
     * @return A string representation of the current date and time.
     */
    public static String nowStringDate() {
        return format(now(), ISO_DATE);
    }

    /**
     * > This function formats a temporal object into a string using the ISO-8601 extended offset date-time format
     *
     * @param temporal The temporal object to format.
     * @return A string representation of the date and time.
     */
    public static String format(TemporalAccessor temporal) {
        return format(temporal, ISO);
    }

    /**
     * > It formats a date-time object using the specified formatter
     *
     * @param temporal  The temporal object to format.
     * @param formatter The formatter to use.
     * @return A string representation of the date and time.
     */
    public static String format(TemporalAccessor temporal, String formatter) {
        return format(temporal, Optional.ofNullable(formatters.get(formatter)).orElseGet(() -> formatters.put(formatter, DateTimeFormatter.ofPattern(formatter))));
    }

    /**
     * > It formats a date-time object using the specified formatter
     *
     * @param temporal  The temporal object to format.
     * @param formatter The formatter to use.
     * @return A string representation of the date and time.
     */
    public static String format(TemporalAccessor temporal, DateTimeFormatter formatter) {
        return Objects.requireNonNull(formatter, "formatter cannot be null").format(temporal);
    }

    public static LocalDateTime localDateTime(FileTime f) {
        return f
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDateTime localDateTime(Date f) {
        return f
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static ZonedDateTime plusDays(int days) {
        return now().plusDays(days);
    }

    public static String plusDaysAsString(int days) {
        return format(now().plusDays(days));
    }

    public static String plusDaysAsString(int days, DateTimeFormatter formatter) {
        return format(now().plusDays(days), formatter);
    }

    public static String plusDaysAsString(int days, String formatter) {
        return format(now().plusDays(days), formatter);
    }
}
