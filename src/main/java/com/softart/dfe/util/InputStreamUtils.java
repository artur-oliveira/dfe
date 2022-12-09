package com.softart.dfe.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

public final class InputStreamUtils {
    private InputStreamUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * "If the file exists, open it and return the stream, otherwise throw an exception."
     * <p>
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @param p The path to the file to open.
     * @return An InputStream
     */
    public static InputStream newFileInputStream(Path p) {
        try {
            return Files.newInputStream(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function creates a new InputStream object from a byte array.
     *
     * @param bytes the byte array to read from
     * @return A new ByteArrayInputStream object.
     */
    public static InputStream newByteArrayInputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    /**
     * This function takes an InputStream and returns a GZIPInputStream.
     *
     * @param is The input stream to be compressed.
     * @return A new GZIPInputStream object.
     */
    public static InputStream newGZIPInputStream(InputStream is) throws IOException {
        return new GZIPInputStream(is);
    }

    /**
     * This function takes a File object and returns an InputStream object.
     *
     * @param f The file to open.
     * @return An InputStream
     */
    public static InputStream newFileInputStream(File f) {
        return newFileInputStream(f.toPath());
    }

    /**
     * Given a path, return an input stream for that path.
     *
     * @param path The path to the file.
     * @return A new InputStream object.
     */
    public static InputStream newFileInputStream(String path) {
        return newFileInputStream(Paths.get(path));
    }
}
