package com.softart.dfe.util;

import com.softart.dfe.models.internal.reflection.PackageFinder;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
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
        return cls.newInstance();
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
     * > Find all classes in the given package finder
     *
     * @param packageFinder This is the package finder object that we created earlier.
     * @return A set of all classes in the packages specified in the packageFinder.
     */
    @SneakyThrows
    public static Set<Class<?>> findAllClasses(PackageFinder packageFinder) {
        Set<Class<?>> allClasses = new HashSet<>();

        for (String packageName : packageFinder.getPackages()) {
            try (InputStream is = RequireUtils.nonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/")), packageName)) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                    Collection<String> lines = reader.lines().collect(Collectors.toList());

                    for (String line : lines) {
                        if (isClassFile(line)) {
                            Class<?> cls = getClass(line, packageName);
                            if (Objects.isNull(cls)) continue;
                            if (packageFinder.matchClass(cls)) allClasses.add(cls);

                        } else {
                            allClasses.addAll(findAllClasses(PackageFinder
                                    .builder()
                                    .assignables(packageFinder.getAssignables())
                                    .packages(Collections.singletonList(packageName + "." + line))
                                    .packageAntMatcher(packageFinder.getPackageAntMatcher())
                                    .packageMatchers(packageFinder.getPackageMatchers())
                                    .excludeClasses(packageFinder.getExcludeClasses())
                                    .build()));
                        }
                    }
                }
            }
        }

        return Collections.unmodifiableSet(allClasses);
    }

    /**
     * It takes a class name and a package name, and returns the class object
     *
     * @param className   The name of the class to be loaded.
     * @param packageName The package name of the class to be loaded.
     * @return A Class object.
     */
    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException ex) {
            log.error(String.join(" ", "ERROR:", ex.getMessage(), className, packageName));
        }
        return null;
    }

}
