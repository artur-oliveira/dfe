package org.dfe.interfaces.validation;

import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.xml.generic.XML;
import org.dfe.models.internal.Validation;

public interface Validator<T extends XML> {

    /**
     * This function takes an object of type Validation and throws a ValidationException if the object is invalid.
     *
     * @param o The object to validate.
     */
    void valid(Validation<T> o) throws ValidationException;

}
