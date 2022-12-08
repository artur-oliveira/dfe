package com.softart.dfe.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

class DateUtilsTest {

    @Test
    void month() {
        ZonedDateTime d = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"));
        Assertions.assertEquals("1", DateUtils.month(d));
    }

    @Test
    void year() {
        Assertions.assertEquals("2022", DateUtils.year(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"))));
    }

    @Test
    void twoDigitsyear() {
        Assertions.assertEquals("22", DateUtils.twoDigitsyear(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"))));
        Assertions.assertEquals("22", DateUtils.twoDigitsyear("2022-01-01T12:00:00-03:00"));
    }

    @Test
    void twoDigitsMonth() {
        Assertions.assertEquals("01", DateUtils.twoDigitsMonth(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"))));
        Assertions.assertEquals("01", DateUtils.twoDigitsMonth("2022-01-01T12:00:00-03:00"));
        Assertions.assertEquals("12", DateUtils.twoDigitsMonth(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 12, 31), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"))));
        Assertions.assertEquals("12", DateUtils.twoDigitsMonth("2022-12-31T12:00:00-03:00"));
    }

    @Test
    void yyMM() {
        Assertions.assertEquals("2201", DateUtils.yyMM("2022-01-31T12:00:00-03:00"));
        Assertions.assertEquals("2201", DateUtils.yyMM(ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 31), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"))));
    }

    @Test
    void format() {
        ZonedDateTime d = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(2022, 1, 1), LocalTime.of(12, 0)), ZoneId.of("America/Sao_Paulo"));
        Assertions.assertEquals("2022-01-01T12:00:00-03:00[America/Sao_Paulo]", DateUtils.format(d, DateTimeFormatter.ISO_ZONED_DATE_TIME));
        Assertions.assertEquals("2022-01-01T12:00:00-03:00[America/Sao_Paulo]", DateUtils.format(d, DateTimeFormatter.ISO_DATE_TIME));
        Assertions.assertEquals("2022-01-01T12:00:00-03:00", DateUtils.format(d));
    }
}