package com.softart.dfe.interfaces.validation;

import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.xml.generic.XML;
import com.softart.dfe.models.internal.Validation;

public interface Validator<T extends XML> {

    /**
     * This function takes an object of type Validation and throws a ValidationException if the object is invalid.
     *
     * @param o The object to validate.
     */
    void valid(Validation<T> o) throws ValidationException;

}
