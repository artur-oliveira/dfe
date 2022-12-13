package com.softart.dfe.components.sefaz;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.interfaces.internal.config.CteConfig;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import com.softart.dfe.models.internal.reflection.PackageFinder;
import com.softart.dfe.util.ReflectionUtils;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
final class DefaultSoapServiceImpl extends SoapService {

    private final Collection<AbstractNfeSoapService> nfeSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.nfe.impl"))
                    .assignables(Collections.singleton(AbstractNfeSoapService.class))
                    .packageAntMatcher(Collections.singleton(".nfce."))
                    .build())
            .stream()
            .map(it -> (AbstractNfeSoapService) ReflectionUtils.newInstance(it))
            .collect(Collectors.toList());
    private final Collection<AbstractNfceSoapService> nfceSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.nfce.impl"))
                    .assignables(Collections.singleton(AbstractNfceSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractNfceSoapService) ReflectionUtils.newInstance(it))
            .collect(Collectors.toList());
    private final Collection<AbstractCteSoapService> cteSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.cte.impl"))
                    .assignables(Collections.singleton(AbstractCteSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractCteSoapService) ReflectionUtils.newInstance(it))
            .collect(Collectors.toList());
    private final Collection<AbstractMdfeSoapService> mdfeSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.mdfe.impl"))
                    .assignables(Collections.singleton(AbstractMdfeSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractMdfeSoapService) ReflectionUtils.newInstance(it))
            .collect(Collectors.toList());


    @Override
    public NfeSoapService getNfeSoapService(NfConfig config) throws SoapServiceGeneralException {
        AbstractNfeSoapService service = (AbstractNfeSoapService) ReflectionUtils.newInstance(getNfeSoapServices()
                        .stream()
                        .filter(it -> it.getAuthorizer().allow(config.uf(), config.environment()))
                        .findFirst()
                        .orElseThrow(SoapServiceGeneralException::new)
                        .getClass())
                .withConfig(config);
        SoapServiceInitializer.nfe().initialize(service);
        return service;
    }

    @Override
    public NfceSoapService getNfceSoapService(NfConfig config) throws SoapServiceGeneralException {
        AbstractNfceSoapService service = (AbstractNfceSoapService) ReflectionUtils.newInstance(getNfceSoapServices()
                        .stream()
                        .filter(it -> it.getAuthorizer().allow(config.uf(), config.environment()))
                        .findFirst()
                        .orElseThrow(SoapServiceGeneralException::new)
                        .getClass())
                .withConfig(config);
        SoapServiceInitializer.nfce().initialize(service);
        return service;
    }

    @Override
    public CteSoapService getCteSoapService(CteConfig config) throws SoapServiceGeneralException {
        AbstractCteSoapService service = (AbstractCteSoapService) ReflectionUtils.newInstance(getCteSoapServices()
                        .stream()
                        .filter(it -> it.getAuthorizer().allow(config.uf(), config.environment()))
                        .findFirst()
                        .orElseThrow(SoapServiceGeneralException::new)
                        .getClass())
                .withConfig(config);
        SoapServiceInitializer.cte().initialize(service);
        return service;
    }

    @Override
    public MdfeSoapService getMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException {
        AbstractMdfeSoapService service = (AbstractMdfeSoapService) ReflectionUtils.newInstance(getMdfeSoapServices()
                        .stream()
                        .filter(it -> it.getAuthorizer().allow(config.uf(), config.environment()))
                        .findFirst()
                        .orElseThrow(SoapServiceGeneralException::new)
                        .getClass())
                .withConfig(config);
        SoapServiceInitializer.mdfe().initialize(service);
        return service;
    }
}
