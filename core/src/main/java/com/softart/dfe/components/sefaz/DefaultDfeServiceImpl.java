package com.softart.dfe.components.sefaz;

import com.softart.dfe.components.sefaz.cte.CteAnService;
import com.softart.dfe.components.sefaz.nfe.NfeAnService;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfceConfig;
import com.softart.dfe.interfaces.internal.config.NfeConfig;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.models.internal.reflection.PackageFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
final class DefaultDfeServiceImpl extends DfeServiceFactory {

    private final Collection<NfeService> nfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.nfe")).assignables(Collections.singleton(NfeService.class)).excludeClasses(Collections.singleton(NfeAnService.class)).build()).stream().map(it -> (NfeService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<NfceService> nfceServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.nfce")).assignables(Collections.singleton(NfceService.class)).build()).stream().map(it -> (NfceService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<CteService> cteServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.cte")).assignables(Collections.singleton(CteService.class)).excludeClasses(Collections.singleton(CteAnService.class)).build()).stream().map(it -> (CteService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<MdfeService> mdfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("com.softart.dfe.components.sefaz.mdfe")).assignables(Collections.singleton(MdfeService.class)).build()).stream().map(it -> (MdfeService) ReflectionUtils.newInstance(it)).toList();

    @Override
    public NfceService getNfceService(NfceConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getNfceServices().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getNfceSoapService(config));
    }

    @Override
    public NfeService getNfeService(NfeConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getNfeServices().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getNfeSoapService(config));
    }

    @Override
    public CteService getCteService(CteConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getCteServices().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getCteSoapService(config));
    }

    @Override
    public MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getMdfeServices().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getMdfeSoapService(config));
    }
}
