package com.softart.dfe.models.internal.reflection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

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

    public boolean matchExcludeClasses(Class<?> cls) {
        return excludeClasses.isEmpty() || excludeClasses.stream().noneMatch(cls::equals);
    }

    public boolean matchPackagerMatchers(Class<?> cls) {
        return packageMatchers.isEmpty() || packageMatchers.stream().anyMatch(it -> cls.getName().contains(it));
    }

    public boolean matchAntMatchers(Class<?> cls) {
        return packageAntMatcher.isEmpty() || packageAntMatcher.stream().noneMatch(it -> cls.getName().contains(it));
    }

    public boolean matchAssignables(Class<?> cls) {
        return assignables.stream().anyMatch(it -> it.isAssignableFrom(cls));
    }

    public boolean matchClass(Class<?> cls) {
        return matchAssignables(cls) && matchAntMatchers(cls) && matchPackagerMatchers(cls) && matchExcludeClasses(cls);
    }

}
