package com.softart.dfe.exceptions.services;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.DFException;

public class NoProviderFound extends DFException {
    public NoProviderFound() {
        super("Não foi implementado para esta UF");
    }

    public NoProviderFound(UF uf) {
        super("Não implementado na UF " + uf);
    }
}
