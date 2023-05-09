package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.models.internal.port.CteServiceFinder;
import com.softart.dfe.models.internal.port.MdfeServiceFinder;
import com.softart.dfe.models.internal.port.NfceServiceFinder;
import com.softart.dfe.models.internal.port.NfeServiceFinder;
import com.softart.dfe.models.internal.reflection.PackageFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.AccessLevel;
import lombok.Getter;

import javax.xml.ws.Service;
import java.util.Collections;
import java.util.Set;

/**
 * The type Soap service mapping.
 */
@Getter(AccessLevel.PROTECTED)
public final class SoapServiceMapping {

    private final static String PATH_NFE_WSDL = "br.inf.portalfiscal.nfe.wsdl";
    private final static String PATH_CTE_WSDL = "br.inf.portalfiscal.cte.wsdl";
    private final static String PATH_MDFE_WSDL = "br.inf.portalfiscal.mdfe.wsdl";
    private final static String PATTERN_NFCE = ".nfce.";

    private final Set<Class<?>> servicesNfe = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_NFE_WSDL)).assignables(Collections.singleton(Service.class)).packageAntMatcher(Collections.singleton(SoapServiceMapping.PATTERN_NFCE)).build());
    private final Set<Class<?>> servicesNfce = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_NFE_WSDL)).assignables(Collections.singleton(Service.class)).packageMatchers(Collections.singleton(SoapServiceMapping.PATTERN_NFCE)).build());
    private final Set<Class<?>> servicesCte = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_CTE_WSDL)).assignables(Collections.singleton(Service.class)).build());
    private final Set<Class<?>> servicesMdfe = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_MDFE_WSDL)).assignables(Collections.singleton(Service.class)).build());

    private SoapServiceMapping() {
    }

    /**
     * The function returns a static instance of the class
     *
     * @return The instance of the SoapServiceMapping class.
     */
    public static SoapServiceMapping getInstance() {
        return SoapServiceMappingHolder.INSTANCE;
    }


    /**
     * Return the first class that matches the given predicate, or null if none matches.
     *
     * @param finder A functional interface that receives a class and returns a boolean.
     * @return A list of classes that implement the NfeService interface.
     */
    public Class<?> getNfeServiceClassFor(NfeServiceFinder finder) {
        return getServicesNfe().stream().filter(finder::found).findFirst().orElse(null);
    }

    /**
     * "Return the first NFCe service class that matches the given finder."
     * <p>
     * The `NfceServiceFinder` interface is defined as follows:
     *
     * @param finder A functional interface that will be used to find the service class.
     * @return A class object.
     */
    public Class<?> getNfceServiceClassFor(NfceServiceFinder finder) {
        return getServicesNfce().stream().filter(finder::found).findFirst().orElse(null);
    }

    /**
     * Return the first CteService class that matches the given CteServiceFinder.
     *
     * @param finder a lambda expression that returns true if the service is found.
     * @return A class object.
     */
    public Class<?> getCteServiceClassFor(CteServiceFinder finder) {
        return getServicesCte().stream().filter(finder::found).findFirst().orElse(null);
    }

    /**
     * Return the first MdfeService class that matches the given MdfeServiceFinder.
     *
     * @param finder a lambda expression that receives a MdfeService and returns a boolean.
     * @return A class that implements the MdfeService interface.
     */
    public Class<?> getMdfeServiceClassFor(MdfeServiceFinder finder) {
        return getServicesMdfe().stream().filter(finder::found).findFirst().orElse(null);
    }

    private static class SoapServiceMappingHolder {
        /**
         * The Instance.
         */
        static final SoapServiceMapping INSTANCE = new SoapServiceMapping();
    }

}
