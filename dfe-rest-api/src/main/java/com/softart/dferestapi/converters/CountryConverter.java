package com.softart.dferestapi.converters;

import com.softart.dfe.enums.general.Country;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter(autoApply = true)
public final class CountryConverter implements AttributeConverter<Country, String> {
    @Override
    public String convertToDatabaseColumn(Country country) {
        return Objects.isNull(country) ? null : country.getCode();
    }

    @Override
    public Country convertToEntityAttribute(String s) {
        return Objects.isNull(s) ? null : Country.valueOfCode(s);
    }
}
