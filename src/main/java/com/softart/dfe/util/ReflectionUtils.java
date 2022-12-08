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

    private ReflectionUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    @SneakyThrows
    public static <T> T newInstance(Class<T> cls) {
        return cls.newInstance();
    }

    public static <T> T safeNewInstance(Class<T> cls) {
        try {
            if (Objects.isNull(cls)) return null;
            return cls.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public static Set<Class<?>> findAllClasses(String packageName) {
        return findAllClasses(PackageFinder.builder().packages(Collections.singletonList(packageName)).build());
    }

    private static boolean isClassFile(String file) {
        return file.endsWith(".class") || file.endsWith(".java");
    }

    @SneakyThrows
    public static Set<Class<?>> findAllClasses(PackageFinder packageFinder) {
        Set<Class<?>> allClasses = new HashSet<>();

        for (String packageName : packageFinder.getPackages()) {
            try (InputStream is = RequireUtils.nonNull(ReflectionUtils.class.getClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/")), packageName)) {
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
                                    .build()));
                        }
                    }
                }
            }
        }

        return Collections.unmodifiableSet(allClasses);
    }

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
