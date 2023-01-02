package com.softart.dfe.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class OutputStreamUtils {

    private OutputStreamUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * This function creates a new ByteArrayOutputStream object.
     *
     * @return A new ByteArrayOutputStream object.
     */
    public static ByteArrayOutputStream newByteArrayOutputStream() {
        return new ByteArrayOutputStream();
    }

    /**
     * This function creates a new GZIPOutputStream object, which is a type of OutputStream object, and returns it.
     *
     * @param outputStream The output stream to write the compressed data to.
     * @return A GZIPOutputStream object.
     */
    public static GZIPOutputStream newGzipOututStream(OutputStream outputStream) throws IOException {
        return new GZIPOutputStream(outputStream);
    }
}
