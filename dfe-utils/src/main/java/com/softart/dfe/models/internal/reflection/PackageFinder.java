package com.softart.dfe.models.internal.reflection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;


/**
 * It's a class that finds classes in packages
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PackageFinder {

    private Collection<String> packages;

    @Builder.Default
    private Collection<Class<?>> assignables = Collections.singleton(Object.class);
    @Builder.Default
    private Collection<String> packageAntMatcher = Collections.emptySet();
    @Builder.Default
    private Collection<String> packageMatchers = Collections.emptySet();
    @Builder.Default
    private Collection<Class<?>> excludeClasses = Collections.emptySet();

    /**
     * "If the excludeClasses list is empty, return true, otherwise return true if none of the excludeClasses match the
     * given class."
     *
     * @param cls The class to check
     * @return A boolean value.
     */
    public boolean matchExcludeClasses(Class<?> cls) {
        return excludeClasses.isEmpty() || excludeClasses.stream().noneMatch(cls::equals);
    }

    /**
     * "If the list of package matchers is empty, return true. Otherwise, return true if any of the package matchers are
     * contained in the class name."
     *
     * @param cls The class to be checked
     * @return A boolean value.
     */
    public boolean matchPackagerMatchers(Class<?> cls) {
        return packageMatchers.isEmpty() || packageMatchers.stream().anyMatch(it -> cls.getName().contains(it));
    }

    /**
     * If the packageAntMatcher is empty, return true. Otherwise, return true if none of the packageAntMatcher strings
     * are contained in the class name
     *
     * @param cls The class to be scanned
     * @return A boolean value.
     */
    public boolean matchAntMatchers(Class<?> cls) {
        return packageAntMatcher.isEmpty() || packageAntMatcher.stream().noneMatch(it -> cls.getName().contains(it));
    }

    /**
     * Return true if any of the assignables are assignable from the given class
     *
     * @param cls The class to check
     * @return A boolean value.
     */
    public boolean matchAssignables(Class<?> cls) {
        return assignables.stream().anyMatch(it -> it.isAssignableFrom(cls));
    }

    /**
     * If the class is assignable to the class we're looking for, and it matches the ant matchers, and it matches the
     * package matchers, and it doesn't match the excluded classes, then return true
     *
     * @param cls The class to be matched
     * @return A boolean value.
     */
    public boolean matchClass(Class<?> cls) {
        return matchAssignables(cls) && matchAntMatchers(cls) && matchPackagerMatchers(cls) && matchExcludeClasses(cls);
    }

}
