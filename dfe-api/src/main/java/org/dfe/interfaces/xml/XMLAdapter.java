package org.dfe.interfaces.xml;

import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.xml.generic.XML;
import org.dfe.util.ClassUtils;
import jakarta.xml.bind.JAXBElement;

import javax.xml.datatype.XMLGregorianCalendar;
import java.beans.PropertyDescriptor;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings({"unchecked", "rawtypes"})
public interface XMLAdapter<T extends XML, I extends XML> {

    /**
     * It takes the first class, and the second class, and it creates an instance of the second class, and it copies all
     * the values from the first class to the second class
     *
     * @return The object that is being returned is the object that is being converted to.
     */
    default I toObject() {
        Class<T> thisClass = firstClass();
        Class<I> toClass = secondClass();

        T thisInstance = (T) this;
        I toInstance = ClassUtils.newInstance(toClass);

        Collection<PropertyDescriptor> fields = ClassUtils.fields(thisClass);

        fields.forEach(f -> {
            PropertyDescriptor toField = ClassUtils.field(toClass, f.getName());
            Object val = ClassUtils.get(f.getReadMethod(), thisInstance);
            if (Objects.nonNull(toField) && Objects.nonNull(val)) {
                if (val instanceof XMLAdapter) {
                    ClassUtils.set(toField.getWriteMethod(), toInstance, ((XMLAdapter<?, ?>) val).toObject());
                } else if (val instanceof Collection) {
                    Collection conv = (Collection<?>) val;
                    if (conv.isEmpty()) return;
                    Object firstItem = conv
                            .stream()
                            .findFirst()
                            .orElse(null);

                    Collection addColection;

                    if (firstItem instanceof XMLAdapter) {
                        addColection = (Collection) conv.stream().map(it -> ((XMLAdapter<?, ?>) it).toObject()).collect(Collectors.toList());
                    } else {
                        addColection = conv;
                    }

                    List instanceVal = (List) ClassUtils.get(toField.getReadMethod(), toInstance);
                    instanceVal.addAll(addColection);
                } else {
                    ClassUtils.set(toField.getWriteMethod(), toInstance, val);
                }
            }
        });
        return toInstance;
    }

    /**
     * It returns the first generic interface of the current class that is a ParameterizedType
     *
     * @return The ParameterizedType of the class that is calling this method.
     */
    default ParameterizedType thisType() {
        return (ParameterizedType) Arrays.stream(this.getClass().getGenericInterfaces()).filter(ParameterizedType.class::isInstance).findFirst().orElse(null);
    }

    /**
     * Return the first type argument of the class that called this function.
     *
     * @return The first type argument of the class that implements this interface.
     */
    default Class<T> firstClass() {
        return (Class<T>) thisType().getActualTypeArguments()[0];
    }

    /**
     * Return the second type argument of the class that is the first type argument of this class
     *
     * @return The second type parameter of the class that implements this interface.
     */
    default Class<I> secondClass() {
        return (Class<I>) thisType().getActualTypeArguments()[1];
    }

    /**
     * Convert a pair of an object and its index to a pair of the object and its index in the new list.
     *
     * @param o The object to convert
     * @return A new instance of the class.
     */
    default T fromObject(Pair<?, I> o) {
        return fromObject(o.second());
    }

    /**
     * It takes an object of type I and returns an object of type T
     *
     * @param o The object to be converted
     * @return The instance of the class that is being converted.
     */
    default T fromObject(JAXBElement<I> o) {
        return fromObject(o.getValue());
    }

    default T fromObject(I o) {
        Class<T> instanceClass = firstClass();
        Class<I> fromClass = secondClass();

        T instance = (T) this;

        Collection<PropertyDescriptor> fields = ClassUtils.fields(fromClass);

        fields.forEach(field -> {
            Object value = ClassUtils.get(field.getReadMethod(), o);

            PropertyDescriptor descriptor = ClassUtils.field(instanceClass, field.getName());

            if (Objects.nonNull(descriptor) && Objects.nonNull(value)) {
                if (value instanceof String || value instanceof Enum || value instanceof Number || value instanceof byte[] || value instanceof XMLGregorianCalendar) {
                    ClassUtils.set(descriptor.getWriteMethod(), instance, value);
                } else if (value instanceof List<?> listValue) {

                    if (!listValue.isEmpty() && !(listValue.get(0) instanceof String) && !(listValue.get(0) instanceof Enum)) {
                        Class<?> objInstanceClass = (Class<?>) ((ParameterizedType) descriptor.getWriteMethod().getGenericParameterTypes()[0]).getActualTypeArguments()[0];
                        ClassUtils.set(descriptor.getWriteMethod(), instance, listValue.stream().map(it -> (((XMLAdapter) ClassUtils.newInstance(objInstanceClass)).fromObject((XML) it))).collect(Collectors.toList()));
                    } else {
                        ClassUtils.set(descriptor.getWriteMethod(), instance, value);
                    }

                } else {
                    Object currentObject = ClassUtils.newInstance(descriptor.getWriteMethod().getParameterTypes()[0]);

                    if (currentObject instanceof XMLAdapter) {
                        Object converted = ((XMLAdapter) currentObject).fromObject((XML) value);
                        ClassUtils.set(descriptor.getWriteMethod(), instance, converted);
                    }
                }
            }
        });

        return instance;
    }
}
