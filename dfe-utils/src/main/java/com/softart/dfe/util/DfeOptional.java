package com.softart.dfe.util;

import com.softart.dfe.exceptions.DfeOptionalException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * The DfeOptional class provides static methods to create Optional objects based on a condition or an empty value.
 */
public final class DfeOptional {

    /**
     * The `private DfeOptional()` constructor is throwing an `UnsupportedOperationException` with a message that indicates
     * that no instances of the `DfeOptional` class can be created. This is a common pattern used to create utility classes
     * that only contain static methods and should not be instantiated. By making the constructor private, it prevents
     * other classes from creating instances of the `DfeOptional` class. If any code attempts to create an instance of the
     * `DfeOptional` class, it will throw an exception with the specified message.
     */
    private DfeOptional() {
        throw new UnsupportedOperationException("No instances of " + this.getClass().getSimpleName());
    }

    /**
     * This function returns an Optional object containing the input object if it is not null or empty, otherwise it
     * returns an empty Optional object.
     *
     * @param o The parameter "o" is a generic type "T" object that is being passed as an argument to the method "ofEmpty".
     *          It represents the object that needs to be checked for null or empty values. The method returns an Optional object of
     *          type T, which may or may not contain the object
     * @return The method is returning an `Optional` object that may or may not contain the input object `o`. If the input
     * object is null or empty, the `Optional` object will be empty. Otherwise, the `Optional` object will contain the
     * input object.
     */
    public static <T> Optional<T> ofEmpty(T o) {
        return ofCondition(!Functions.isNullOrEmpty(o), o);
    }

    /**
     * This function returns an optional object of a given type if the length of the input object falls within a specified
     * range.
     *
     * @param o            The object whose length or size needs to be measured.
     * @param minInclusive The minimum length allowed (inclusive) for the object o.
     * @param maxInclusive The maximum length (inclusive) that the object can have.
     * @return The method is returning an Optional object of type T, which is the same type as the input object o.
     */
    public static <T> Optional<T> ofLengthRange(T o, long minInclusive, long maxInclusive) {
        if (Functions.isNullOrEmpty(o)) return Optional.empty();
        long currentLength = -1;
        if (o.getClass().isArray()) {
            currentLength = Array.getLength(o);
        } else if (o instanceof CharSequence charSeq) {
            currentLength = charSeq.length();
        } else if (o instanceof Collection<?> col) {
            currentLength = col.size();
        } else if (o instanceof Map<?, ?> map) {
            currentLength = map.size();
        }
        if (currentLength == -1) {
            throw new DfeOptionalException("cannot measure length of class " + o.getClass());
        }
        return ofCondition(currentLength >= minInclusive && currentLength <= maxInclusive, o);
    }

    /**
     * This function returns an Optional object containing a value of type T if the length of the object is equal to a
     * specified length.
     *
     * @param o      The parameter "o" is of type T, which means it can be any object type.
     * @param length The "length" parameter is a long value representing the desired length of the object "o". The method
     *               "ofLengthEq" returns an Optional object containing "o" if its length is equal to the specified length, and an empty
     *               Optional otherwise.
     * @return The method is returning an `Optional` object that contains a value of type `T`. The value is the same as the
     * input parameter `o` if its length is equal to the input parameter `length`. If the length is not equal, then an
     * empty `Optional` is returned.
     */
    public static <T> Optional<T> ofLengthEq(T o, long length) {
        return ofLengthRange(o, length, length);
    }

    /**
     * This function returns an Optional object of a given type if the length of the object is equal to a specified length.
     *
     * @param o      The parameter `o` is a generic type `T` which represents the object that we want to check the length of.
     * @param length The parameter "length" is of type "long" and represents the desired length of the object "o". The
     *               method "ofLength" returns an Optional object containing "o" if its length is equal to the specified length, or an
     *               empty Optional otherwise.
     * @return The method is returning an `Optional` object that contains a value of type `T`.
     */
    public static <T> Optional<T> ofLength(T o, long length) {
        return ofLengthEq(o, length);
    }

    public static <T> Optional<T> ofLengthIn(T o, Number... lengths) {
        return Arrays.stream(lengths).filter(it -> ofLength(o, it.longValue()).isPresent()).findFirst().flatMap(it -> ofLength(o, it.longValue()));
    }

    /**
     * This function returns an Optional object containing a value if the length of the input object is greater than a
     * specified length.
     *
     * @param o      The parameter `o` is of type `T`, which means it can be any object of any class. It represents the object
     *               whose length needs to be checked.
     * @param length The "length" parameter represents the minimum length that the object "o" should have in order for the
     *               method to return a non-empty Optional object. In the method implementation, this parameter is used to call the
     *               "ofLengthRange" method with a minimum length of "length + 1" and
     * @return The method `ofLengthGt` returns an `Optional` object that contains a value of type `T` if the length of the
     * input object `o` is greater than the specified `length`. If the length is not greater than the specified value, an
     * empty `Optional` is returned.
     */
    public static <T> Optional<T> ofLengthGt(T o, long length) {
        return ofLengthRange(o, length + 1, Long.MAX_VALUE);
    }

    /**
     * This function returns an Optional object containing a value of type T if the length of the object is greater than or
     * equal to a specified length.
     *
     * @param o      The parameter "o" is a generic type "T" which represents the object whose length is being checked.
     * @param length The "length" parameter represents the minimum length that the object "o" should have. The method
     *               "ofLengthGte" returns an Optional object containing "o" if its length is greater than or equal to "length",
     *               otherwise it returns an empty Optional.
     * @return The method `ofLengthGte` returns an `Optional` object that contains a value of type `T` if the length of the
     * input object `o` is greater than or equal to the specified `length`. If the length is less than the specified
     * length, an empty `Optional` is returned.
     */
    public static <T> Optional<T> ofLengthGte(T o, long length) {
        return ofLengthRange(o, length, Long.MAX_VALUE);
    }


    /**
     * This Java function returns an Optional object of type T if the length of the input object is less than a specified
     * value.
     *
     * @param o      The parameter `o` is of type `T` and represents an object of any class.
     * @param length The length parameter represents the maximum length allowed for the object o. The method checks if the
     *               length of the object is less than the specified length and returns an Optional object containing the object if it
     *               satisfies the condition, otherwise it returns an empty Optional.
     * @return The method is returning an `Optional` object that contains a value of type `T`. The value is the same as the
     * input object `o` if its length is less than `length`, otherwise the `Optional` object is empty.
     */
    public static <T> Optional<T> ofLengthLt(T o, long length) {
        return ofLengthRange(o, 0, length - 1);
    }

    /**
     * This function returns an Optional object of type T if the length of the input object is less than or equal to a
     * specified length.
     *
     * @param o      o is a generic type parameter representing the object whose length is being checked. It can be any type of
     *               object.
     * @param length The maximum length allowed for the object "o". The method checks if the length of "o" is less than or
     *               equal to this value.
     * @return The method is returning an `Optional` object that contains a value of type `T` if the length of the input
     * object `o` is less than or equal to the specified `length`. If the length is greater than the specified value, an
     * empty `Optional` is returned.
     */
    public static <T> Optional<T> ofLengthLte(T o, long length) {
        return ofLengthRange(o, 0, length);
    }

    /**
     * This function returns an Optional object containing a value if a given condition is true, otherwise it returns an
     * empty Optional.
     *
     * @param condition A boolean value that determines whether the Optional should contain the given object or be empty.
     * @param o         The parameter `o` is of type `T` and represents the object that we want to wrap in an `Optional` if the
     *                  condition is true.
     * @return The method `ofCondition` returns an `Optional` object that contains the value `o` if the `condition` is
     * `true`, or an empty `Optional` if the `condition` is `false`.
     */
    public static <T> Optional<T> ofCondition(boolean condition, T o) {
        return condition ? Optional.ofNullable(o) : Optional.empty();
    }
}
