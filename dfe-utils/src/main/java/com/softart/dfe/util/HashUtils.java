package com.softart.dfe.util;

import jakarta.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public final class HashUtils {
    public static final String SHA1 = "SHA1";
    public static final String MD5 = "MD5";

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `HashUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private HashUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * `hashDeliveryReceipt` takes the access key and the base64 encoded image and returns the SHA1 hash of the
     * concatenation of the access key and the base64 encoded image
     *
     * @param accessKey   The access key of the user who is sending the message.
     * @param base64Image The base64 encoded image of the delivery receipt.
     * @return A byte array of the hash of the accessKey and base64Image.
     */
    public static byte[] hashDeliveryReceipt(String accessKey, String base64Image) throws GeneralSecurityException {
        return DatatypeConverter.parseHexBinary(sha1((accessKey + base64Image)));
    }

    /**
     * It takes a string, converts it to a byte array, and then calls the hex function that takes a byte array
     *
     * @param str The string to be converted to hexadecimal.
     * @return A string of hexadecimal characters.
     */
    public static String hex(final String str) {
        return hex(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * It takes a byte array and returns a string of hexadecimal characters
     *
     * @param str The string to be hashed.
     * @return A string of 40 hexadecimal characters.
     */
    public static String hex(final byte[] str) {
        return String.format("%040x", new BigInteger(1, str));
    }

    /**
     * Get the SHA1 hash of the given text, and return it as a hexadecimal string.
     *
     * @param text The text to hash
     * @return A string of the SHA1 hash of the input string.
     */
    public static String sha1(String text) throws GeneralSecurityException {
        final StringBuilder sb = new StringBuilder();
        for (final byte element : MessageDigest.getInstance(HashUtils.SHA1).digest(text.getBytes(StandardCharsets.UTF_8))) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    /**
     * It takes a string, converts it to bytes, and then uses the MessageDigest class to hash the bytes
     *
     * @param text The text to hash
     * @return A string of the hexadecimal representation of the MD5 hash of the input string.
     */
    public static String md5(String text) throws GeneralSecurityException {
        return md5(text.getBytes());
    }

    public static String md5(InputStream is) throws GeneralSecurityException, IOException {
        return md5(IOUtils.readAllBytes(is));
    }

    public static String md5(final byte[] bytes) throws GeneralSecurityException {
        MessageDigest md = MessageDigest.getInstance(HashUtils.MD5);
        md.update(bytes);
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
