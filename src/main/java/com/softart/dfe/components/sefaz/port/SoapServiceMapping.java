package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.models.internal.port.CteServiceFinder;
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
    private final static String PATTERN_NFCE = ".nfce.";

    private final Set<Class<?>> servicesNfe = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_NFE_WSDL)).assignables(Collections.singleton(Service.class)).packageAntMatcher(Collections.singleton(SoapServiceMapping.PATTERN_NFCE)).build());
    private final Set<Class<?>> servicesNfce = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_NFE_WSDL)).assignables(Collections.singleton(Service.class)).packageMatchers(Collections.singleton(SoapServiceMapping.PATTERN_NFCE)).build());
    private final Set<Class<?>> servicesCte = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singletonList(SoapServiceMapping.PATH_CTE_WSDL)).assignables(Collections.singleton(Service.class)).build());

    private SoapServiceMapping() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static SoapServiceMapping getInstance() {
        return SoapServiceMappingHolder.INSTANCE;
    }

    /**
     * Gets nfe service class for.
     *
     * @param finder the finder
     * @return the nfe service class for
     */
    public Class<?> getNfeServiceClassFor(NfeServiceFinder finder) {
        return getServicesNfe().stream().filter(finder::found).findFirst().orElse(null);
    }

    /**
     * Gets nfce service class for.
     *
     * @param finder the finder
     * @return the nfce service class for
     */
    public Class<?> getNfceServiceClassFor(NfceServiceFinder finder) {
        return getServicesNfce().stream().filter(finder::found).findFirst().orElse(null);
    }

    /**
     * Gets nfce service class for.
     *
     * @param finder the finder
     * @return the nfce service class for
     */
    public Class<?> getCteServiceClassFor(CteServiceFinder finder) {
        return getServicesCte().stream().filter(finder::found).findFirst().orElse(null);
    }

    private static class SoapServiceMappingHolder {
        /**
         * The Instance.
         */
        static final SoapServiceMapping INSTANCE = new SoapServiceMapping();
    }

}
