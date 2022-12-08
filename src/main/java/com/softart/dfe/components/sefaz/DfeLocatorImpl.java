package com.softart.dfe.components.sefaz;

import com.softart.dfe.components.sefaz.cte.CteAnService;
import com.softart.dfe.components.sefaz.nfe.NfeAmService;
import com.softart.dfe.components.sefaz.nfe.NfeAnService;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.models.internal.reflection.PackageFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Getter
final class DfeLocatorImpl extends DfeFactory {

    private final Collection<NfeService> nfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.nfe")).assignables(Collections.singleton(NfeService.class)).excludeClasses(Collections.singleton(NfeAnService.class)).build()).stream().map(it -> (NfeService) ReflectionUtils.newInstance(it)).collect(Collectors.toList());

    private final Collection<NfceService> nfceServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.nfce")).assignables(Collections.singleton(NfceService.class)).build()).stream().map(it -> (NfceService) ReflectionUtils.newInstance(it)).collect(Collectors.toList());

    private final Collection<CteService> cteServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.cte")).assignables(Collections.singleton(CteService.class)).excludeClasses(Collections.singleton(CteAnService.class)).build()).stream().map(it -> (CteService) ReflectionUtils.newInstance(it)).collect(Collectors.toList());

    @Override
    public NfceService getNfceService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getNfceServices().stream().filter(it -> it.allow(config.uf(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass()).withSoapService(SoapServiceFactory.getInstance().getNfceSoapService(config));
    }

    @Override
    public NfeService getNfeService(NfConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getNfeServices().stream().filter(it -> it.allow(config.uf(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass()).withSoapService(SoapServiceFactory.getInstance().getNfeSoapService(config));
    }

    @Override
    public CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getCteServices().stream().filter(it -> it.allow(config.uf(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass()).withSoapService(SoapServiceFactory.getInstance().getCteSoapService(config));
    }
}
