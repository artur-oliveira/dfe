package com.softart.dfe.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ClassUtils {

    /**
     * This is a private constructor that throws an exception if it is ever called. It is used to prevent instances of the
     * `ClassUtils` class from being created, as all the methods in the class are static and there is no need to create an
     * instance of the class.
     */
    private ClassUtils() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * It returns a list of all the properties of a class
     *
     * @param clz The class to introspect
     * @return A collection of PropertyDescriptor objects.
     */
    private static Collection<PropertyDescriptor> propertyDescriptors(Class<?> clz) throws IntrospectionException {
        return Arrays.asList(Introspector.getBeanInfo(clz).getPropertyDescriptors());
    }

    /**
     * "Get all the properties of a class, except for the 'class' property."
     * <p>
     * The function uses the JavaBeans API to get all the properties of a class. It then filters out the 'class' property,
     * which is a property of all Java classes
     *
     * @param clz The class to get the fields from
     * @return A collection of PropertyDescriptors for the given class.
     */
    public static Collection<PropertyDescriptor> fields(Class<?> clz) {
        try {
            return propertyDescriptors(clz).stream().filter(it -> !it.getName().equals("class")).collect(Collectors.toList());
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * "Return the first property descriptor whose name matches the given field name, or null if none is found."
     * <p>
     * The first thing we do is call the `fields` function we defined earlier. This returns a list of all the property
     * descriptors for the given class
     *
     * @param clz   The class to get the field from
     * @param field The name of the field you want to get the PropertyDescriptor for.
     * @return A property descriptor for the field.
     */
    public static PropertyDescriptor field(Class<?> clz, String field) {
        return fields(clz).stream().filter(it -> Objects.equals(it.getName().toLowerCase(), field.toLowerCase())).findFirst().orElse(null);
    }

    /**
     * "Given a class, return the BeanInfo for that class."
     * <p>
     * The function is a static method on the BeanInfoUtils class. It takes a single parameter, a Class object. The
     * function returns a BeanInfo object
     *
     * @param clz The class to be introspected.
     * @return A BeanInfo object.
     */
    public static BeanInfo info(Class<?> clz) {
        try {
            return Introspector.getBeanInfo(clz);
        } catch (IntrospectionException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * It creates a new instance of the class passed as parameter
     *
     * @param entityClass The class of the entity to be instantiated.
     * @return A new instance of the class passed as parameter.
     */
    public static <T> T newInstance(Class<T> entityClass) {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Class " + entityClass.getSimpleName() + " cannot be instanciated");
        }
    }

    /**
     * It takes a getter method and an instance of the class that the getter belongs to, and returns the value of the field
     * that the getter gets
     *
     * @param getter       The getter method to invoke
     * @param thisInstance The instance of the class that the getter is being called on.
     * @return The value of the field that the getter method is accessing.
     */
    public static <I> Object get(Method getter, I thisInstance) {
        try {
            getter.setAccessible(true);
            return getter.invoke(thisInstance);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal get on method " + getter + " on instance " + thisInstance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * It takes a method, an instance of the class that the method belongs to, and a value, and it sets the value of the
     * method on the instance
     *
     * @param method       The method to invoke
     * @param thisInstance The instance of the class you want to set the field on.
     * @param val          The value to set the field to.
     */
    public static <I> void set(Method method, I thisInstance, Object val) {
        try {
            method.setAccessible(true);
            method.invoke(thisInstance, val);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Illegal get on method " + method + " on instance " + thisInstance + " with val " + val);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

