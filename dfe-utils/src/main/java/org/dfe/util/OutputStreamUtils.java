package org.dfe.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class OutputStreamUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `OutputStreamUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
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
