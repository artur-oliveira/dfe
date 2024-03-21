package org.dfe.interfaces.internal.cte;

import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.models.internal.cte.Cte4QrCode;
import org.dfe.models.internal.cte.CteOs4QrCode;
import org.dfe.models.internal.cte.Gtve4QrCode;

/**
 * Declaring a public interface named `QrCodeGenerator`. This interface defines three methods that can be implemented by
 * any class that implements this interface. The methods are used to generate QR codes for different types of Brazilian
 * Electronic Transport Documents (CT-e and CT-e OS) using different types of objects (CteQrCode and GtveQrCode). The
 * methods also throw a `NoProviderFound` exception if no provider is found.
 */
public interface QrCodeGenerator {


    /**
     * The function "generate" takes an object of type Cte4QrCode and generates a QR code, throwing a NoProviderFound
     * exception if no provider is found.
     *
     * @param o An object of type Cte4QrCode.
     * @return The method is returning a String.
     */
    String generate(Cte4QrCode o) throws NoProviderFound;


    /**
     * The function "generate" takes an object of type Gtve4QrCode and generates a QR code, throwing a NoProviderFound
     * exception if no provider is found.
     *
     * @param o An object of type Gtve4QrCode.
     * @return The method is returning a String.
     */
    String generate(Gtve4QrCode o) throws NoProviderFound;


    /**
     * The function "generate" takes an object of type CteOs4QrCode and returns a String, while also potentially throwing a
     * NoProviderFound exception.
     *
     * @param o An object of type CteOs4QrCode.
     * @return The method is returning a String.
     */
    String generate(CteOs4QrCode o) throws NoProviderFound;
}
