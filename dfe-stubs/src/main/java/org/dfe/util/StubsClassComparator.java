package org.dfe.util;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
public final class StubsClassComparator {

    public static List<String> compare(Class<?> oldClass, Class<?> newClass, boolean ignoreFieldCase, boolean deepCompare, String... ignoreNames) {
        List<String> ignored = Arrays.stream(Optional.ofNullable(ignoreNames).orElse(new String[] {})).map(it -> ignoreFieldCase ? it.toLowerCase() : it).toList();
        Collection<Field> fields1 = Arrays.asList(oldClass.getDeclaredFields());
        Field[] fields2 = newClass.getDeclaredFields();
        Collection<String> fieldsNames1 = fields1.stream().map(it -> ignoreFieldCase ? it.getName().toLowerCase() : it.getName()).collect(Collectors.toSet());
        List<String> addedFields = new ArrayList<>();

        for (Field field : fields2) {
            String currentFieldName = ignoreFieldCase ? field.getName().toLowerCase() : field.getName();
            Field oldClassField = fields1.stream().filter(it -> ignoreFieldCase ? it.getName().toLowerCase().equals(currentFieldName) : it.getName().equals(currentFieldName)).findFirst().orElse(null);
            if (!fieldsNames1.contains(currentFieldName) && !ignored.contains(currentFieldName)) {
                addedFields.add(field.getDeclaringClass().getName() + "." + field.getName());
            }
            boolean isPrimitiveOrStringOrEnum = field.getType().isPrimitive() || Objects.equals(String.class, field.getType()) || field.getType().isEnum();

            if (deepCompare && !isPrimitiveOrStringOrEnum) {
                if (Objects.nonNull(oldClassField)) {
                    boolean isList = Collection.class.isAssignableFrom(oldClassField.getType());
                    if (isList) {
                        Class<?> realType1 = (Class<?>) ((ParameterizedType) oldClassField.getGenericType()).getActualTypeArguments()[0];
                        Class<?> realType2 = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                        addedFields.addAll(compare(realType1, realType2, ignoreFieldCase, deepCompare, ignoreNames));
                    } else {
                        addedFields.addAll(compare(oldClassField.getType(), field.getType(), ignoreFieldCase, deepCompare, ignoreNames));
                    }
                }
            }
        }
        if (!addedFields.isEmpty()) {
            System.out.println("ADDED FIELDS");
            System.out.println(addedFields);
        }

        return addedFields;
    }

    public static List<String> compare(Class<?> oldClass, Class<?> newClass, boolean ignoreFieldCase, boolean deepCompare) {
        return compare(oldClass, newClass, ignoreFieldCase, deepCompare, new String[] {});
    }

}
