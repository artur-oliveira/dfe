package com.softart.dfe.components.sefaz;

import com.softart.dfe.components.sefaz.port.SoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.exceptions.port.SoapServiceNotFoundException;
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
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
            .toList();
    private final Collection<AbstractNfceSoapService> nfceSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.nfce.impl"))
                    .assignables(Collections.singleton(AbstractNfceSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractNfceSoapService) ReflectionUtils.newInstance(it))
            .toList();
    private final Collection<AbstractCteSoapService> cteSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.cte.impl"))
                    .assignables(Collections.singleton(AbstractCteSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractCteSoapService) ReflectionUtils.newInstance(it))
            .toList();
    private final Collection<AbstractMdfeSoapService> mdfeSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("com.softart.dfe.components.sefaz.port.mdfe.impl"))
                    .assignables(Collections.singleton(AbstractMdfeSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractMdfeSoapService) ReflectionUtils.newInstance(it))
            .toList();

    public AbstractNfeSoapService getNfeSoapService(UF uf, Environment environment, NFEmissionType emissionType) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getNfeSoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment, emissionType))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    private AbstractNfceSoapService getNfceSoapService(UF uf, Environment environment) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getNfceSoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    private AbstractCteSoapService getCteSoapService(UF uf, Environment environment, CteEmissionType emissionType) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getCteSoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment, emissionType))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    private AbstractMdfeSoapService getMdfeSoapService(UF uf, Environment environment) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getMdfeSoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    @Override
    public NfeSoapService getNfeSoapService(NfConfig config) throws SoapServiceGeneralException {
        AbstractNfeSoapService service = (AbstractNfeSoapService) getNfeSoapService(config.webServiceUF(), config.environment(), config.emission()).withConfig(config);
        SoapServiceInitializer.nfe().initialize(service);
        return service;
    }

    @Override
    public Collection<? extends NfeSoapService> getAllNfeSoapService(NfConfig config) throws SoapServiceGeneralException {
        Collection<AbstractNfeSoapService> soapServices = new HashSet<>();
        for (UF uf : UF.states()) {
            for (Environment environment : Environment.values()) {
                for (NFEmissionType nfEmissionType : NFEmissionType.nfe()) {
                    try {
                        soapServices.add(getNfeSoapService(uf, environment, nfEmissionType));
                    } catch (SoapServiceNotFoundException ignored) {
                    }
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(soapServices.size());

        for (AbstractNfeSoapService it : soapServices) {
            executorService.submit(() -> {
                try {
                    SoapServiceInitializer.nfe().initialize((AbstractNfeSoapService) (it.withConfig(config)));
                } catch (SoapServiceInitializationException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES))
                throw new SoapServiceGeneralException("failed to await termination");
        } catch (InterruptedException e) {
            throw new SoapServiceGeneralException(e);
        }
        return soapServices;
    }

    @Override
    public NfceSoapService getNfceSoapService(NfConfig config) throws SoapServiceGeneralException {
        AbstractNfceSoapService service = (AbstractNfceSoapService) getNfceSoapService(config.webServiceUF(), config.environment()).withConfig(config);
        SoapServiceInitializer.nfce().initialize(service);
        return service;
    }

    @Override
    public Collection<? extends NfceSoapService> getAllNfceSoapService(NfConfig config) throws SoapServiceGeneralException {
        Collection<AbstractNfceSoapService> soapServices = new HashSet<>();
        for (UF uf : UF.states()) {
            for (Environment environment : Environment.values()) {
                try {
                    soapServices.add(getNfceSoapService(uf, environment));
                } catch (SoapServiceNotFoundException ignored) {
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(soapServices.size());

        for (AbstractNfceSoapService it : soapServices) {
            executorService.submit(() -> {
                try {
                    SoapServiceInitializer.nfce().initialize((AbstractNfceSoapService) (it.withConfig(config)));
                } catch (SoapServiceInitializationException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES))
                throw new SoapServiceGeneralException("failed to await termination");
        } catch (InterruptedException e) {
            throw new SoapServiceGeneralException(e);
        }
        return soapServices;
    }


    @Override
    public CteSoapService getCteSoapService(CteConfig config) throws SoapServiceGeneralException {
        AbstractCteSoapService service = (AbstractCteSoapService) getCteSoapService(config.webServiceUF(), config.environment(), config.emission()).withConfig(config);
        SoapServiceInitializer.cte().initialize(service);
        return service;
    }

    @Override
    public Collection<? extends CteSoapService> getAllCteSoapService(CteConfig config) throws SoapServiceGeneralException {
        Collection<AbstractCteSoapService> soapServices = new HashSet<>();
        for (UF uf : UF.states()) {
            for (Environment environment : Environment.values()) {
                for (CteEmissionType type : CteEmissionType.cte())
                    try {
                        soapServices.add(getCteSoapService(uf, environment, type));
                    } catch (SoapServiceNotFoundException ignored) {
                    }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(soapServices.size());

        for (AbstractCteSoapService it : soapServices) {
            executorService.submit(() -> {
                try {
                    SoapServiceInitializer.cte().initialize((AbstractCteSoapService) (it.withConfig(config)));
                } catch (SoapServiceInitializationException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES))
                throw new SoapServiceGeneralException("failed to await termination");
        } catch (InterruptedException e) {
            throw new SoapServiceGeneralException(e);
        }
        return soapServices;
    }

    @Override
    public MdfeSoapService getMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException {
        AbstractMdfeSoapService service = (AbstractMdfeSoapService) getMdfeSoapService(config.webServiceUF(), config.environment()).withConfig(config);
        SoapServiceInitializer.mdfe().initialize(service);
        return service;
    }

    @Override
    public Collection<? extends MdfeSoapService> getAllMdfeSoapService(MdfeConfig config) throws SoapServiceGeneralException {
        Collection<AbstractMdfeSoapService> soapServices = new HashSet<>();
        for (UF uf : UF.states()) {
            for (Environment environment : Environment.values()) {
                try {
                    soapServices.add(getMdfeSoapService(uf, environment));
                } catch (SoapServiceNotFoundException ignored) {
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(soapServices.size());

        for (AbstractMdfeSoapService it : soapServices) {
            executorService.submit(() -> {
                try {
                    SoapServiceInitializer.mdfe().initialize((AbstractMdfeSoapService) (it.withConfig(config)));
                } catch (SoapServiceInitializationException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES))
                throw new SoapServiceGeneralException("failed to await termination");
        } catch (InterruptedException e) {
            throw new SoapServiceGeneralException(e);
        }
        return soapServices;
    }
}
