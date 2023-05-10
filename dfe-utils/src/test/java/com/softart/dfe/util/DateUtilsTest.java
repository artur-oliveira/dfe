package com.softart.dfe.util;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void testZoned() {
        assertEquals(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2023, 5, 9), LocalTime.of(9, 18, 25)), ZoneId.of("-03:00")), DateUtils.zoned("2023-05-09T09:18:25-03:00"));
    }

    @Test
    void testCurrentMonth() {
        assertEquals(Objects.toString(LocalDate.now().get(ChronoField.MONTH_OF_YEAR)), DateUtils.currentMonth());
    }

    @Test
    void testMonth() {
        assertEquals("5", DateUtils.month(YearMonth.of(2022, 5)));
    }

    @Test
    void testCurrentYear() {
        assertEquals(Objects.toString(LocalDate.now().get(ChronoField.YEAR)), DateUtils.currentyear());
    }

    @Test
    void testYear() {
        assertEquals("2022", DateUtils.year(YearMonth.of(2022, 5)));
    }

    @Test
    void testTwoDigitsyear() {
        assertEquals("22", DateUtils.twoDigitsyear(YearMonth.of(2022, 5)));
        assertEquals("99", DateUtils.twoDigitsyear(YearMonth.of(2099, 5)));
    }

    @Test
    void testTwoDigitsyear2() {
        assertEquals("23", DateUtils.twoDigitsyear("2023-05-09T09:18:25-03:00"));
    }

    @Test
    void testTwoDigitsMonth() {
        assertEquals("06", DateUtils.twoDigitsMonth(LocalDate.of(2023, 6, 7)));
        assertEquals("12", DateUtils.twoDigitsMonth(LocalDate.of(2023, 12, 7)));
    }

    @Test
    void testTwoDigitsMonth2() {
        assertEquals("05", DateUtils.twoDigitsMonth("2023-05-09T09:18:25-03:00"));
    }

    @Test
    void testYyMM() {
        assertEquals("2312", DateUtils.yyMM(LocalDate.of(2023, 12, 7)));
        assertEquals("9912", DateUtils.yyMM(LocalDate.of(2099, 12, 7)));
    }

    @Test
    void testYyMM2() {
        assertEquals("2305", DateUtils.yyMM("2023-05-09T09:18:25-03:00"));
        assertEquals("2305", DateUtils.yyMM("2023-05-09T09:18:25-03:00"));
    }


    @Test
    void testFormat() {
        assertEquals("2023-05-09T09:18:25-03:00", DateUtils.format(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2023, 5, 9), LocalTime.of(9, 18, 25)), ZoneId.of("-03:00"))));
        assertEquals("2023-05-09T09:18:25-04:00", DateUtils.format(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2023, 5, 9), LocalTime.of(9, 18, 25)), ZoneId.of("-04:00"))));
    }
}