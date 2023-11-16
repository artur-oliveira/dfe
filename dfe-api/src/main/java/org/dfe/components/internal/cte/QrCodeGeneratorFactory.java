package org.dfe.components.internal.cte;

import org.dfe.interfaces.internal.cte.QrCodeGenerator;

/**
 * This is an abstract class that provides a static method to get an instance of a QR code generator factory.
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
     * The class defines a static final instance of a QrCodeGeneratorFactory implementation.
     */
    static final class Holder {
        static final QrCodeGeneratorFactory INSTANCE = new QrCodeUrlGenerator();
    }
}
