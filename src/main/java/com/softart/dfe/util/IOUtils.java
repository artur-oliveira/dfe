package com.softart.dfe.util;

import com.softart.dfe.util.DateUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public final class IOUtils {

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

    public static byte[] readAllBytes(File f) throws IOException {
        if (Objects.isNull(f) || !f.exists()) return null;
        return Files.readAllBytes(f.toPath());
    }

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
     */
    public static void write(String fileName, byte[] bytes) throws IOException {
        final Path path = Paths.get(fileName);

        if (!path.getParent().toFile().exists()) Files.createDirectories(path.getParent());
        if (!path.toFile().exists()) Files.createFile(path);

        Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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

    public static String homeDir() {
        return System.getProperty("user.home");
    }

    public static String separator() {
        return File.separator;
    }
}
