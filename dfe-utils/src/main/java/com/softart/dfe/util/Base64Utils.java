package com.softart.dfe.util;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class Base64Utils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `Base64Utils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private Base64Utils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }


    /**
     * It takes a string, converts it to a byte array, and then calls the encode function that takes a byte array
     *
     * @param s The string to be encoded.
     * @return A byte array
     */
    public static byte[] encode(String s) {
        return encode(s.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * It takes a byte array and returns a byte array.
     *
     * @param s The string to be encoded.
     * @return A byte array
     */
    public static byte[] encode(byte[] s) {
        return Base64.getEncoder().encode(s);
    }

    /**
     * It takes a ByteArrayOutputStream, converts it to a byte array, and then calls the encode function that takes a byte
     * array as an argument
     *
     * @param byteOutputStream The ByteArrayOutputStream object that contains the data to be encoded.
     * @return The encoded byte array.
     */
    public static byte[] encode(ByteArrayOutputStream byteOutputStream) {
        return encode(byteOutputStream.toByteArray());
    }

    /**
     * It takes a string, converts it to a byte array, and then calls the encodeToString function that takes a byte array
     * as an argument
     *
     * @param s The string to be encoded.
     * @return A string that is encoded in base64.
     */
    public static String encodeToString(String s) {
        return encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * It encodes a byte array into a string.
     *
     * @param s The string to be encoded.
     * @return A string
     */
    public static String encodeToString(byte[] s) {
        return Base64.getEncoder().encodeToString(s);
    }

    /**
     * It takes a ByteArrayOutputStream and returns a String
     *
     * @param byteOutputStream The ByteArrayOutputStream object that you want to encode.
     * @return A string
     */
    public static String encodeToString(ByteArrayOutputStream byteOutputStream) {
        return encodeToString(byteOutputStream.toByteArray());
    }

    /**
     * Decode the given bytes using the Base64 decoder and return the result as a String.
     *
     * @param bytes The byte array to decode.
     * @return A string
     */
    public static String decodeBinary(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }

    /**
     * Decode the given string using the Base64 decoder.
     *
     * @param string The string to be decoded.
     * @return A byte array
     */
    public static byte[] decode(String string) {
        return Base64.getDecoder().decode(string);
    }
}
