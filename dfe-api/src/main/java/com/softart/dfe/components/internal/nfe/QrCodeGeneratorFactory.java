package com.softart.dfe.components.internal.nfe;

import com.softart.dfe.interfaces.internal.nf.QrCodeGenerator;

/**
 * This is an abstract class that serves as a factory for generating QR codes and returns an instance of the
 * QrCodeV2UrlGenerator.
 */
public abstract class QrCodeGeneratorFactory implements QrCodeGenerator {
    protected QrCodeGeneratorFactory() {
    }

    /**
     * The function returns an instance of the QrCodeGeneratorFactory class using the Singleton design pattern.
     *
     * @return An instance of the QrCodeGeneratorFactory class is being returned. This method uses the Singleton design
     * pattern to ensure that only one instance of the QrCodeGeneratorFactory class is created and returned.
     */
    public static QrCodeGeneratorFactory getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * The class defines a static final instance of a QR code generator factory.
     */
    static final class Holder {
        static final QrCodeGeneratorFactory INSTANCE = new QrCodeV2UrlGenerator();
    }
}
