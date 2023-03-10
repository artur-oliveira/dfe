package com.softart.dferestapi.exceptions.entity;

import com.softart.dferestapi.exceptions.DfeRestException;

public final class EntityNotFoundException extends DfeRestException {

    public EntityNotFoundException(Long id) {
        super("entity with id " + id + " not found");
    }

}
