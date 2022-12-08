package com.softart.dfe.components.internal.cte;

import com.softart.dfe.interfaces.internal.cte.QrCodeGenerator;

public abstract class QrCodeGeneratorFactory implements QrCodeGenerator {
    protected QrCodeGeneratorFactory() {
    }

    public static QrCodeGeneratorFactory getInstance() {
        return new QrCodeUrlGenerator();
    }
}
