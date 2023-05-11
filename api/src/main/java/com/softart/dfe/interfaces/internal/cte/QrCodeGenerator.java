package com.softart.dfe.interfaces.internal.cte;

import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.models.internal.cte.CteOsQrCode;
import com.softart.dfe.models.internal.cte.CteQrCode;
import com.softart.dfe.models.internal.cte.GtveQrCode;

/**
 * Declaring a public interface named `QrCodeGenerator`. This interface defines three methods that can be implemented by
 * any class that implements this interface. The methods are used to generate QR codes for different types of Brazilian
 * Electronic Transport Documents (CT-e and CT-e OS) using different types of objects (CteQrCode and GtveQrCode). The
 * methods also throw a `NoProviderFound` exception if no provider is found.
 */
public interface QrCodeGenerator {


    /**
     * This Java function generates a QR code for a CteQrCode object and throws a NoProviderFound exception if no provider
     * is found.
     *
     * @param cteQrCode cteQrCode is an object of type CteQrCode which contains the necessary information to generate a QR
     *                  code for a Brazilian Electronic Transport Document (CT-e). This object may contain information such as the CT-e
     *                  number, issuer and recipient information, product and service details, taxes, and
     * @return The method `generate` is returning a `String` value.
     * @throws NoProviderFound if no provider is found.
     */
    String generate(CteQrCode cteQrCode) throws NoProviderFound;


    /**
     * This Java function generates a QR code for a given CTE (Conhecimento de Transporte Eletrônico) using a provider and
     * throws an exception if no provider is found.
     *
     * @param cteQrCode cteQrCode is an object of type GtveQrCode which is likely used to generate a QR code for a CTE
     *                  (Conhecimento de Transporte Eletrônico) in Brazil. The method generate() takes this object as a parameter and
     *                  returns a String. The
     * @return A String is being returned.
     */
    String generate(GtveQrCode cteQrCode) throws NoProviderFound;

    /**
     * The function generates a QR code for a CteOsQrCode object and throws a NoProviderFound exception if no provider is
     * found.
     *
     * @param cteQrCode cteQrCode is an object of type CteOsQrCode which contains the necessary information to generate a
     *                  QR code for a Brazilian Electronic Transport Document (CT-e OS). This object may contain information such as the
     *                  CT-e OS number, issuer and recipient information, product and service details,
     * @return The method `generate` returns a `String` value.
     * @throws NoProviderFound if no provider is found.
     */
    String generate(CteOsQrCode cteQrCode) throws NoProviderFound;
}
