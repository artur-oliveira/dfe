package com.softart.dfe.interfaces.internal;

import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.enums.internal.UF;

import java.time.YearMonth;

public interface AccessKeyParser {
    /**
     * It returns the emission of a given access key.
     *
     * @param accessKey The access key
     * @return A YearMonth object.
     */
    YearMonth emission(String accessKey);

    /**
     * Given an id, return the corresponding string.
     *
     * @param id The id of the object to be retrieved.
     * @return The id of the user who sent the message.
     */
    String fromId(String id);

    /**
     * Returns the prefix to use for the id attribute of the HTML element
     *
     * @return The idPrefix method is being returned.
     */
    String idPrefix();

    /**
     * It returns the month of the year.
     *
     * @param accessKey The access key
     * @return The number of the month of the year.
     */
    int month(String accessKey);

    /**
     * It returns the year of the date represented by the access key.
     *
     * @param accessKey The access key
     * @return The year of the date.
     */
    int year(String accessKey);

    /**
     * It returns the CNPJ of the company that owns the access key.
     *
     * @param accessKey The access key
     * @return CNPJ of the access key
     */
    String cnpj(String accessKey);

    /**
     * It returns a model object.
     *
     * @param accessKey The access key
     * @return A model object.
     */
    Model model(String accessKey);

    /**
     * It returns the serie number
     *
     * @param accessKey The access key
     * @return The serie number
     */
    int serie(String accessKey);

    /**
     * It returns the number of document
     *
     * @param accessKey The access key
     * @return The number of document
     */
    int number(String accessKey);

    /**
     * It returns the hash code of the accessKey.
     *
     * @param accessKey The access key
     * @return The code is being returned.
     */
    int code(String accessKey);

    /**
     * Given a string, return the digit that corresponds to the first character of the string
     *
     * @param accessKey The access key
     * @return The digit of the accessKey.
     */
    int digit(String accessKey);

    /**
     * It returns a UF object.
     *
     * @param accessKey The access key
     * @return A UF object.
     */
    UF uf(String accessKey);

    /**
     * It returns a string that is the accessKey parameter with the first character capitalized.
     *
     * @param accessKey The access key to be formatted.
     * @return A string.
     */
    String format(String accessKey);
}
