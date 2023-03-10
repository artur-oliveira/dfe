package com.softart.dfe.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.GZIPOutputStream;

@SuppressWarnings("unused")
public final class GZIPUtils {

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
     * It takes a byte array, compresses it, and returns a base64 encoded string
     *
     * @param o The byte array to compress
     * @return A byte array
     */
    public static byte[] compress(final byte[] o) throws Exception {
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
    public static byte[] compress(String o) throws Exception {
        return compress(o.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * "compressToString" takes a string, compresses it, and returns the compressed string as a string
     *
     * @param o The string to compress
     * @return A string that is the compressed version of the input string.
     */
    public static String compressToString(String o) throws Exception {
        return new String(compress(o), StandardCharsets.UTF_8);
    }

}
