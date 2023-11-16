package org.dfe.interfaces.internal.cte;

import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.models.internal.cte.*;

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
     * @param o cteQrCode is an object of type CteQrCode which contains the necessary information to generate a QR
     *          code for a Brazilian Electronic Transport Document (CT-e). This object may contain information such as the CT-e
     *          number, issuer and recipient information, product and service details, taxes, and
     * @return The method `generate` is returning a `String` value.
     * @throws NoProviderFound if no provider is found.
     */
    String generate(CteQrCode o) throws NoProviderFound;

    /**
     * The function "generate" takes an object of type Cte4QrCode and generates a QR code, throwing a NoProviderFound
     * exception if no provider is found.
     *
     * @param o An object of type Cte4QrCode.
     * @return The method is returning a String.
     */
    String generate(Cte4QrCode o) throws NoProviderFound;


    /**
     * This Java function generates a QR code for a given CTE (Conhecimento de Transporte Eletrônico) using a provider and
     * throws an exception if no provider is found.
     *
     * @param o cteQrCode is an object of type GtveQrCode which is likely used to generate a QR code for a CTE
     *          (Conhecimento de Transporte Eletrônico) in Brazil. The method generate() takes this object as a parameter and
     *          returns a String. The
     * @return A String is being returned.
     */
    String generate(GtveQrCode o) throws NoProviderFound;

    /**
     * The function "generate" takes an object of type Gtve4QrCode and generates a QR code, throwing a NoProviderFound
     * exception if no provider is found.
     *
     * @param o An object of type Gtve4QrCode.
     * @return The method is returning a String.
     */
    String generate(Gtve4QrCode o) throws NoProviderFound;

    /**
     * The function generates a QR code for a CteOsQrCode object and throws a NoProviderFound exception if no provider is
     * found.
     *
     * @param o cteQrCode is an object of type CteOsQrCode which contains the necessary information to generate a
     *          QR code for a Brazilian Electronic Transport Document (CT-e OS). This object may contain information such as the
     *          CT-e OS number, issuer and recipient information, product and service details,
     * @return The method `generate` returns a `String` value.
     * @throws NoProviderFound if no provider is found.
     */
    String generate(CteOsQrCode o) throws NoProviderFound;

    /**
     * The function "generate" takes an object of type CteOs4QrCode and returns a String, while also potentially throwing a
     * NoProviderFound exception.
     *
     * @param o An object of type CteOs4QrCode.
     * @return The method is returning a String.
     */
    String generate(CteOs4QrCode o) throws NoProviderFound;
}
