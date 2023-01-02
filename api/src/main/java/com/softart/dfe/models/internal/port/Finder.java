package com.softart.dfe.models.internal.port;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.util.StringUtils;

@SuppressWarnings("rawtypes")
public abstract class Finder {

    public abstract Enum getAuthorizer();

    public abstract DFEnum.Codeable getEndpoint();

    public abstract Environment getEnvironment();


    /**
     * "If the class name contains the endpoint, return true."
     * <p>
     * The function is called from the following function:
     *
     * @param clsName The name of the class being loaded.
     * @return A boolean value.
     */
    public boolean matchEndpoint(String clsName) {
        return clsName.contains(StringUtils.concat(".", getEndpoint().getCode(), "."));
    }

    /**
     * > It checks if the class name contains the authorizer name
     *
     * @param clsName The class name of the class being loaded.
     */
    public boolean matchAuthorizer(String clsName) {
        return clsName.contains(StringUtils.concat(".", StringUtils.lower(getAuthorizer().name()), "."));
    }


    /**
     * > It checks if the class name contains the environment name
     *
     * @param clsName The class name of the class being loaded.
     */
    public boolean matchEnvironment(String clsName) {
        return clsName.contains(StringUtils.concat(".", getEnvironment().getRootPath(), "."));
    }

    /**
     * "If the class name matches the endpoint, authorizer, and environment, then return true."
     * <p>
     * The `matchEndpoint` function is the most interesting. It's a simple regular expression match
     *
     * @param cls The class to be tested
     * @return A boolean value.
     */
    public boolean found(Class<?> cls) {
        return matchEndpoint(cls.getName()) && matchAuthorizer(cls.getName()) && matchEnvironment(cls.getName());
    }

}
