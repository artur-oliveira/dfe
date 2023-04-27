package com.softart.dferestapi.exceptions.entity;

import com.softart.dferestapi.exceptions.DfeRestApiException;
import lombok.Getter;

@Getter
public final class EntityAlreadyExistsException extends DfeRestApiException {

    private final Long id;

    public EntityAlreadyExistsException(Long id) {
        super("entity with this info already exists");
        this.id = id;
    }

}
