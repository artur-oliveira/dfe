package com.softart.dfe.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class OutputStreamUtils {

    private OutputStreamUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    public static ByteArrayOutputStream newByteArrayOutputStream() {
        return new ByteArrayOutputStream();
    }

    public static GZIPOutputStream newGzipOututStream(OutputStream outputStream) throws IOException {
        return new GZIPOutputStream(outputStream);
    }
}
