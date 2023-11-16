package org.dfe.models.internal.port;

import org.dfe.components.internal.DFEnum;
import org.dfe.enums.internal.Environment;
import org.dfe.util.StringUtils;

@SuppressWarnings("rawtypes")
public interface Finder {

    Enum authorizer();

    DFEnum.Codeable endpoint();

    Environment environment();


    /**
     * "If the class name contains the endpoint, return true."
     * <p>
     * The function is called from the following function:
     *
     * @param clsName The name of the class being loaded.
     * @return A boolean value.
     */
    default boolean matchEndpoint(String clsName) {
        return clsName.contains(StringUtils.concat(".", endpoint().getCode(), "."));
    }

    /**
     * It checks if the class name contains the authorizer name
     *
     * @param clsName The class name of the class being loaded.
     */
    default boolean matchAuthorizer(String clsName) {
        return clsName.contains(StringUtils.concat(".", StringUtils.lower(authorizer().name()), "."));
    }


    /**
     * It checks if the class name contains the environment name
     *
     * @param clsName The class name of the class being loaded.
     */
    default boolean matchEnvironment(String clsName) {
        return clsName.contains(StringUtils.concat(".", environment().getRootPath(), "."));
    }

    /**
     * "If the class name matches the endpoint, authorizer, and environment, then return true."
     * <p>
     * The `matchEndpoint` function is the most interesting. It's a simple regular expression match
     *
     * @param cls The class to be tested
     * @return A boolean value.
     */
    default boolean found(Class<?> cls) {
        return matchEndpoint(cls.getName()) && matchAuthorizer(cls.getName()) && matchEnvironment(cls.getName());
    }

}
