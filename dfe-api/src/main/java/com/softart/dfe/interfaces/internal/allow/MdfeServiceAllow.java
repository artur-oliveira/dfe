package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;

/**
 * The code is defining a Java interface named `MdfeServiceAllow` that extends another interface named `AllowUF`. This
 * means that `MdfeServiceAllow` inherits all the methods and constants from `AllowUF` in addition to any methods that are
 * defined within `MdfeServiceAllow`.
 */
public interface MdfeServiceAllow extends AllowUF {


    /**
     * The function checks if a given UF, environment, and MdfeEmissionType allow for emission.
     *
     * @param uf           "uf" is an abbreviation for "Unidade Federativa" which means "Federative Unit" in English. In Brazil, it
     *                     refers to the states and the Federal District. Therefore, "uf" is a parameter that represents the state or the
     *                     Federal District where the operation is taking place.
     * @param environment  The `environment` parameter is an object that represents the environment in which the MDF-e
     *                     (Manifesto Eletrônico de Documentos Fiscais) emission will take place. It contains information such as the company's
     *                     tax ID, the emission date and time, the type of operation being
     * @param emissionType The parameter "emissionType" is of type "MdfeEmissionType" and represents the type of MDF-e
     *                     (Manifesto Eletrônico de Documentos Fiscais) emission that is being allowed or not. MDF-e is a Brazilian electronic
     *                     document used for the transportation
     * @return The method `allow` is returning a boolean value.
     */
    boolean allow(UF uf, Environment environment, MdfeEmissionType emissionType);

}
