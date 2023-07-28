package com.softart.dfe.exceptions.services;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.DfeException;


/**
 * The NoProviderFound class is a custom exception that indicates a lack of implementation for a specific Brazilian state
 * (UF).
 */
public class NoProviderFound extends DfeException {
    public NoProviderFound() {
        super("Não foi implementado para esta UF");
    }

    public NoProviderFound(UF uf) {
        super("Não implementado na UF " + uf);
    }
}
