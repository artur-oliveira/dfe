package org.dfe.util;

import org.dfe.models.internal.reflection.PackageFinder;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

@Log4j2
public final class ReflectionUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `ReflectionUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private ReflectionUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * Create a new instance of the given class.
     *
     * @param cls The class to instantiate
     * @return A new instance of the class.
     */
    @SneakyThrows
    public static <T> T newInstance(Class<T> cls) {
        if (Objects.isNull(cls)) return null;
        return cls.getDeclaredConstructor().newInstance();
    }

    /**
     * If the class is null, return null, otherwise return a new instance of the class.
     *
     * @param cls The class to be instantiated.
     * @return A new instance of the class passed in.
     */
    public static <T> T safeNewInstance(Class<T> cls) {
        try {
            if (Objects.isNull(cls)) return null;
            return newInstance(cls);
        } catch (Exception e) {
            log.warn("error on create instance of class " + cls.getName());
            return null;
        }
    }

    /**
     * Find all classes in the given package.
     *
     * @param packageName The package name to search for classes in.
     * @return A set of classes.
     */
    public static Set<Class<?>> findAllClasses(String packageName) {
        return findAllClasses(PackageFinder.builder().packages(Collections.singletonList(packageName)).build());
    }

    /**
     * If the file ends with .class or .java, return true.
     *
     * @param file The file to check.
     * @return The file extension of the file.
     */
    private static boolean isClassFile(String file) {
        return file.endsWith(".class") || file.endsWith(".java");
    }

    /**
     * This function retrieves all classes from a given directory and package name in Java.
     *
     * @param directory   The directory from which to retrieve the classes.
     * @param packageName The name of the package to search for classes in.
     * @return The method is returning a Set of Class objects.
     */
    private static Set<Class<?>> getClassesFromDirectory(File directory, String packageName) throws ClassNotFoundException {
        File tmpDirectory;
        Set<Class<?>> classes = new HashSet<>();
        if (directory.exists() && directory.isDirectory()) {
            final String[] files = directory.list();

            if (Objects.nonNull(files)) {
                for (final String file : files) {
                    if (isClassFile(file)) {
                        try {
                            classes.add(Class.forName(packageName + '.' + file.substring(0, file.length() - 6)));
                        } catch (final NoClassDefFoundError ignored) {
                        }
                    } else if ((tmpDirectory = new File(directory, file)).isDirectory()) {
                        classes.addAll(getClassesFromDirectory(tmpDirectory, packageName + "." + file));
                    }
                }
            }
        }

        return classes;
    }

    /**
     * This function retrieves all classes from a JAR file that belong to a specified package.
     *
     * @param connection  The JarURLConnection object representing the JAR file from which to extract the classes.
     * @param packageName The name of the package to search for classes in the JAR file.
     * @return The method is returning a Set of Class objects that are found in a JAR file and belong to a specific
     * package.
     */
    private static Set<Class<?>> getClassesFromJarFile(JarURLConnection connection, String packageName) throws ClassNotFoundException, IOException {
        final JarFile jarFile = connection.getJarFile();
        final Enumeration<JarEntry> entries = jarFile.entries();
        String name;
        final Set<Class<?>> classes = new HashSet<>();

        for (JarEntry jarEntry; entries.hasMoreElements() && ((jarEntry = entries.nextElement()) != null); ) {
            name = jarEntry.getName();
            if (isClassFile(name)) {
                name = name.substring(0, name.length() - 6).replace('/', '.');

                if (name.contains(packageName)) {
                    classes.add(Class.forName(name));
                }
            }
        }
        return classes;
    }

    /**
     * Find all classes in the given package finder
     *
     * @param packageFinder This is the package finder object that we created earlier.
     * @return A set of all classes in the packages specified in the packageFinder.
     */
    @SneakyThrows
    public static Set<Class<?>> findAllClasses(PackageFinder packageFinder) {
        Set<Class<?>> allClasses = new HashSet<>();
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        for (String packageName : packageFinder.getPackages()) {
            final Enumeration<URL> resources = classLoader.getResources(packageName.replace('.', '/'));

            for (URL url; resources.hasMoreElements() && ((url = resources.nextElement()) != null); ) {
                URLConnection connection = Objects.requireNonNull(url.openConnection());

                Set<Class<?>> tempClasses = new HashSet<>();

                if (connection instanceof JarURLConnection) {
                    tempClasses.addAll(getClassesFromJarFile((JarURLConnection) connection, packageName));
                } else {
                    tempClasses.addAll(getClassesFromDirectory(new File(URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8)), packageName));
                }

                allClasses.addAll(tempClasses.stream().filter(Objects::nonNull).filter(packageFinder::matchClass).collect(Collectors.toSet()));
            }
        }

        return Collections.unmodifiableSet(allClasses);
    }

}
