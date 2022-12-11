package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.interfaces.internal.mdfe.QrCodeGenerator;

public abstract class QrCodeGeneratorFactory implements QrCodeGenerator {

    protected QrCodeGeneratorFactory() {
    }

    public static QrCodeGeneratorFactory getInstance() {
        return Holder.INSTANCE;
    }

    static final class Holder {
        static final QrCodeGeneratorFactory INSTANCE = new QrCodeUrlGenerator();
    }
}
