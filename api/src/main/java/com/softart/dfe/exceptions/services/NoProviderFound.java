package com.softart.dfe.exceptions.services;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.DfeException;

/**
 * This exception is thrown when a provider is not found for a given UF.
 */
public class NoProviderFound extends DfeException {
    public NoProviderFound() {
        super("Não foi implementado para esta UF");
    }

    public NoProviderFound(UF uf) {
        super("Não implementado na UF " + uf);
    }
}
