package com.softart.dfe.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public final class IOUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `IOUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private IOUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * Reads the contents of a file into a string.
     *
     * @param f The file to read from.
     * @return A String
     */
    public static String readFileToString(File f) throws IOException {
        if (Objects.isNull(f) || !f.exists()) return null;
        return String.join("", Files.readAllLines(f.toPath()));
    }

    /**
     * Reads all bytes from a file into a byte array.
     *
     * @param f The file to read from.
     * @return A byte array of the file contents.
     */
    public static byte[] readAllBytes(File f) throws IOException {
        if (Objects.isNull(f) || !f.exists()) return null;
        return Files.readAllBytes(f.toPath());
    }

    public static byte[] readAllBytes(InputStream is) throws IOException {
        try (ByteArrayOutputStream bao = OutputStreamUtils.newByteArrayOutputStream()) {
            try (InputStream ois = is) {
                final byte[] dataBytes = new byte[2098];

                int nread;
                while ((nread = ois.read(dataBytes)) != -1) {
                    bao.write(dataBytes, 0, nread);
                }

                return bao.toByteArray();
            }
        }
    }

    /**
     * If the file exists, return the creation date, otherwise return null.
     *
     * @param f The file to get the creation date of.
     * @return A LocalDateTime object
     */
    public static LocalDateTime creationDate(File f) throws IOException {
        if (Objects.isNull(f) || !f.exists()) return null;

        BasicFileAttributes attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);

        return DateUtils.localDateTime(attr.creationTime());
    }

    /**
     * If the parent directory of the file doesn't exist, create it. If the file doesn't exist, create it. Then write the
     * bytes to the file.
     *
     * @param fileName The name of the file to write to.
     * @param bytes    The bytes to write to the file.
     * @return A File object
     */
    public static File write(String fileName, byte[] bytes) throws IOException {
        final Path path = Paths.get(fileName);

        if (!path.getParent().toFile().exists()) Files.createDirectories(path.getParent());
        if (!path.toFile().exists()) Files.createFile(path);

        return Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING).toFile();
    }

    public static File writeTemp(String fileName, byte[] bytes) throws IOException {
        final Path path = Files.createTempFile(fileName.substring(0, fileName.indexOf(".") - 1), fileName.substring(fileName.indexOf(".")));

        if (!path.getParent().toFile().exists()) Files.createDirectories(path.getParent());
        if (!path.toFile().exists()) Files.createFile(path);

        return Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING).toFile();
    }

    /**
     * "Given a base path, find all files in the same folder that start with the same name."
     * <p>
     * The function is pretty straightforward. It takes a base path, finds the folder path and the file name, then finds
     * all files in the folder that start with the file name
     *
     * @param bPath The base path of the file.
     * @return A collection of files that start with the fileName.
     */
    public static Collection<File> findFilesByBasePath(String bPath) {
        int idx = bPath.lastIndexOf(File.separator);
        String folderPath = bPath.substring(0, idx);
        String fileName = bPath.substring(idx + 1);

        File[] files = new File(folderPath).listFiles();
        if (Objects.isNull(files)) return Collections.emptyList();

        return Arrays.stream(files).filter(it -> it.getName().startsWith(fileName)).collect(Collectors.toList());
    }

    /**
     * It returns the last file in the directory specified by the base path
     *
     * @param bPath The base path of the file.
     * @return The last file in the directory.
     */
    public static File findLastFileByBasePath(String bPath) {
        return findFilesByBasePath(bPath).stream().max(Comparator.naturalOrder()).orElse(null);
    }

    /**
     * Return the user's home directory.
     *
     * @return The home directory of the user.
     */
    public static String homeDir() {
        return System.getProperty("user.home");
    }

    /**
     * The separator() function returns the file separator for the current platform.
     *
     * @return The file separator character.
     */
    public static String separator() {
        return File.separator;
    }
}
