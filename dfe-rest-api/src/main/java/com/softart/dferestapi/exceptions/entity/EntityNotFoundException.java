package com.softart.dferestapi.exceptions.entity;

import com.softart.dferestapi.exceptions.DfeRestApiException;

public final class EntityNotFoundException extends DfeRestApiException {

    public EntityNotFoundException(Long id) {
        super("entity with id " + id + " not found");
    }

}
