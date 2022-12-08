package com.softart.dfe.interfaces.validation;

import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.interfaces.xml.XML;
import com.softart.dfe.models.internal.Validation;

public interface Validator<T extends XML> {

    void valid(Validation<T> o) throws ValidationException;

}
