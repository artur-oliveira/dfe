package org.dfe.components.sefaz;

import lombok.Getter;
import org.dfe.components.sefaz.nfe.NfeAnService;
import org.dfe.enums.internal.nf.NfeAuthorizer;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.internal.config.NfeConfig;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.sefaz.mdfe.MdfeService;
import org.dfe.interfaces.sefaz.nf.nfce.NfceService;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import org.dfe.interfaces.sefaz.port.NfeSoapService;
import org.dfe.models.internal.reflection.PackageFinder;
import org.dfe.util.ReflectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
final class DefaultDfeServiceImpl extends DfeServiceFactory {

    private final Collection<NfeService> nfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.nfe")).assignables(Collections.singleton(NfeService.class)).excludeClasses(Collections.singleton(NfeAnService.class)).build()).stream().map(it -> (NfeService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<NfceService> nfceServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.nfce")).assignables(Collections.singleton(NfceService.class)).build()).stream().map(it -> (NfceService) ReflectionUtils.newInstance(it)).toList();
    private final Collection<Cte4Service> cte4Services = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.cte4")).assignables(Collections.singleton(Cte4Service.class)).excludeClasses(Collections.singleton(org.dfe.components.sefaz.cte4.CteAnService.class)).build()).stream().map(it -> (Cte4Service) ReflectionUtils.newInstance(it)).toList();
    private final Collection<MdfeService> mdfeServices = ReflectionUtils.findAllClasses(PackageFinder.builder().packages(Collections.singleton("org.dfe.components.sefaz.mdfe")).assignables(Collections.singleton(MdfeService.class)).build()).stream().map(it -> (MdfeService) ReflectionUtils.newInstance(it)).toList();

    @Override
    public NfceService getNfceService(NfceConfig config) throws NoProviderFound, SoapServiceGeneralException {
        NfceService nfceService = Optional.ofNullable(ReflectionUtils.newInstance(getNfceServices().stream().filter(it -> it.allow(config)).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new);
        NfceSoapService nfceSoapService = SoapService.getInstance().getNfceSoapService(config);
        return nfceService.withSoapService(nfceSoapService);
    }

    @Override
    public NfeService getNfeService(NfeConfig config) throws NoProviderFound, SoapServiceGeneralException {
        return getNfeService(config, NfeAuthorizer.valueOfConfig(config));
    }

    @Override
    public NfeService getNfeService(NfeConfig config, NfeAuthorizer nfeAuthorizer) throws NoProviderFound, SoapServiceGeneralException {
        NfeService nfeService = Optional.ofNullable(ReflectionUtils.newInstance(getNfeServices().stream().filter(it -> it.allow(config)).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new);
        NfeSoapService nfeSoapService = SoapService.getInstance().getNfeSoapService(config, nfeAuthorizer);
        return nfeService.withSoapService(nfeSoapService);
    }

    @Override
    public Cte4Service getCte4Service(CteConfig config) throws NoProviderFound, SoapServiceGeneralException {
        Cte4Service cteService = Optional.ofNullable(ReflectionUtils.newInstance(getCte4Services().stream().filter(it -> it.allow(config)).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new);
        Cte4SoapService cteSoapService = SoapService.getInstance().getCte4SoapService(config);
        return cteService.withSoapService(cteSoapService);
    }

    @Override
    public MdfeService getMdfeService(MdfeConfig config) throws NoProviderFound, SoapServiceGeneralException {
        MdfeService mdfeService = Optional.ofNullable(ReflectionUtils.newInstance(getMdfeServices().stream().filter(it -> it.allow(config)).findFirst().orElseThrow(NoProviderFound::new).getClass())).orElseThrow(NoProviderFound::new);
        MdfeSoapService mdfeSoapService = SoapService.getInstance().getMdfeSoapService(config);
        return mdfeService.withSoapService(mdfeSoapService);
    }
}
