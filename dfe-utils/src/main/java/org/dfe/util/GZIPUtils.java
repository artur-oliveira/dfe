package org.dfe.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.GZIPOutputStream;

@SuppressWarnings("unused")
public final class GZIPUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `GZIPUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private GZIPUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * It takes a byte array, decompresses it, and returns the decompressed string
     *
     * @param o The byte array to decompress
     * @return A string
     */
    public static String decompress(byte[] o) throws Exception {
        if (Functions.isNullOrEmpty(o)) return "";

        try (InputStream gis = InputStreamUtils.newGZIPInputStream(InputStreamUtils.newByteArrayInputStream(o))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                return bf.lines().collect(Collectors.joining(""));
            }
        }
    }

    /**
     * This Java function decompresses a Base64-encoded byte array using GZIP and returns the resulting string.
     *
     * @param o The parameter "o" is a byte array that contains compressed data in Base64 encoding format. This method
     *          decompresses the data using GZIP algorithm and returns the decompressed string.
     * @return The method is returning a String that is the result of decompressing and decoding a byte array using GZIP
     * and Base64 algorithms, respectively. The decompressed and decoded String is then read using a BufferedReader and
     * returned as a single String by joining all the lines using the Collectors.joining() method. If the input byte array
     * is null or empty, an empty String is returned.
     */
    public static String decompressWithBase64(byte[] o) throws Exception {
        if (Functions.isNullOrEmpty(o)) return "";

        try (InputStream gis = InputStreamUtils.newGZIPInputStream(InputStreamUtils.newByteArrayInputStream(Base64Utils.decode(o)))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                return bf.lines().collect(Collectors.joining(""));
            }
        }
    }

    /**
     * It takes a string, converts it to a byte array, and then passes it to the decompress function that takes a byte
     * array
     *
     * @param o The string to be decompressed.
     * @return A string
     */
    public static String decompress(String o) throws Exception {
        return decompress(o.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * This Java function decompresses a Base64-encoded string.
     *
     * @param o The parameter "o" is a String that represents the compressed data in Base64 encoding. The method
     *          "decompressWithBase64" takes this parameter and returns the decompressed data as a String.
     * @return The method `decompressWithBase64` is returning a `String` value.
     */
    public static String decompressWithBase64(String o) throws Exception {
        return decompressWithBase64(o.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * It takes a byte array, compresses it, and returns a base64 encoded string
     *
     * @param o The byte array to compress
     * @return A byte array
     */
    public static byte[] compress(final byte[] o) throws IOException {
        if (Functions.isNullOrEmpty(o)) return "".getBytes(StandardCharsets.UTF_8);

        try (ByteArrayOutputStream byteArrayOutputStream = OutputStreamUtils.newByteArrayOutputStream()) {
            try (GZIPOutputStream gos = OutputStreamUtils.newGzipOututStream(byteArrayOutputStream)) {
                gos.write(o);
                gos.finish();
                return Base64Utils.encode(byteArrayOutputStream);
            }
        }
    }

    /**
     * It takes a string, converts it to a byte array, and then compresses that byte array
     *
     * @param o The string to compress
     * @return A byte array
     */
    public static byte[] compress(String o) throws IOException {
        return compress(o.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * "compressToString" takes a string, compresses it, and returns the compressed string as a string
     *
     * @param o The string to compress
     * @return A string that is the compressed version of the input string.
     */
    public static String compressToString(String o) throws IOException {
        return new String(compress(o), StandardCharsets.UTF_8);
    }

}
