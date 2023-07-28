package com.softart.dfe.interfaces.internal.allow;

import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;

/**
 * The code is defining a Java interface named `CteServiceAllow` that extends another interface named `AllowUF`. This means
 * that `CteServiceAllow` inherits all the methods and constants from `AllowUF` in addition to any methods that are defined
 * within `CteServiceAllow`.
 */
public interface CteServiceAllow extends AllowUF {


    /**
     * The function "allow" takes in parameters and returns a boolean value indicating whether a certain action is allowed
     * or not.
     *
     * @param uf           The "uf" parameter is likely an abbreviation for "Unit Federations" and refers to a geographical region or
     *                     state in Brazil. It is commonly used in Brazilian tax and legal systems to determine tax rates and regulations for
     *                     businesses operating in that region.
     * @param environment  The `environment` parameter is an object that represents the environment in which the CTE
     *                     (Conhecimento de Transporte Eletrônico) emission is being requested. It contains information such as the company's
     *                     tax ID, the state in which the company is registered, the type of operation being performed
     * @param emissionType The emissionType parameter is a variable of type CteEmissionType, which represents the type of
     *                     CT-e (Conhecimento de Transporte Eletrônico) emission. CT-e is a Brazilian electronic document used for the
     *                     transportation of goods. The CteEmissionType variable can have one
     * @return A boolean value is being returned.
     */
    boolean allow(UF uf, Environment environment, CteEmissionType emissionType);

}
