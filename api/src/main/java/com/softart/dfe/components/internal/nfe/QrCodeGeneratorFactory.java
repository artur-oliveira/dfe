package com.softart.dfe.components.internal.nfe;

import com.softart.dfe.interfaces.internal.nf.QrCodeGenerator;

public abstract class QrCodeGeneratorFactory implements QrCodeGenerator {
    protected QrCodeGeneratorFactory() {
    }

    public static QrCodeGeneratorFactory getInstance() {
        return new QrCodeV2UrlGenerator();
    }
}
