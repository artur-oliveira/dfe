package org.dfe.components.sefaz;

import org.dfe.components.sefaz.cte.CteAnService;
import org.dfe.components.sefaz.nfe.NfeAnService;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.cte.CteService;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.sefaz.mdfe.MdfeService;
import org.dfe.interfaces.sefaz.nf.nfce.NfceService;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.models.internal.reflection.PackageFinder;
import org.dfe.util.ReflectionUtils;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
final class DefaultDfeServiceImpl extends DfeServiceFactory {

    private final Collection<NfeService> nfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.nfe")).assignables(Collections.singleton(NfeService.class)).excludeClasses(Collections.singleton(NfeAnService.class)).build()).stream().map(it -> (NfeService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<NfceService> nfceServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.nfce")).assignables(Collections.singleton(NfceService.class)).build()).stream().map(it -> (NfceService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<CteService> cteServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.cte")).assignables(Collections.singleton(CteService.class)).excludeClasses(Collections.singleton(CteAnService.class)).build()).stream().map(it -> (CteService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<Cte4Service> cte4Services = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.cte4")).assignables(Collections.singleton(Cte4Service.class)).excludeClasses(Collections.singleton(org.dfe.components.sefaz.cte4.CteAnService.class)).build()).stream().map(it -> (Cte4Service) ReflectionUtils.newInstance(it)).toList();
    private final Collection<MdfeService> mdfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.mdfe")).assignables(Collections.singleton(MdfeService.class)).build()).stream().map(it -> (MdfeService) ReflectionUtils.newInstance(it)).toList();

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
    public Cte4Service getCte4Service(CteConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getCte4Services().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getCte4SoapService(config));
    }

    @Override
    public MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return Optional.ofNullable(ReflectionUtils.newInstance(getMdfeServices().stream().filter(it -> it.allow(config.webServiceUF(), config.environment(), config.emission())).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new).withSoapService(SoapService.getInstance().getMdfeSoapService(config));
    }
}
