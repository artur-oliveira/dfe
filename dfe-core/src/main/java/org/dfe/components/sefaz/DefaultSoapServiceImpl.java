package org.dfe.components.sefaz;

import lombok.AccessLevel;
import lombok.Getter;
import org.dfe.components.sefaz.port.SoapServiceInitializer;
import org.dfe.components.sefaz.port.cte4.AbstractCte4SoapService;
import org.dfe.components.sefaz.port.mdfe.AbstractMdfeSoapService;
import org.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import org.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import org.dfe.enums.cte.identification.CteEmissionType;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.exceptions.port.SoapServiceGeneralException;
import org.dfe.exceptions.port.SoapServiceInitializationException;
import org.dfe.exceptions.port.SoapServiceNotFoundException;
import org.dfe.interfaces.internal.config.CteConfig;
import org.dfe.interfaces.internal.config.MdfeConfig;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import org.dfe.interfaces.sefaz.port.MdfeSoapService;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import org.dfe.interfaces.sefaz.port.NfeSoapService;
import org.dfe.models.internal.reflection.PackageFinder;
import org.dfe.util.ReflectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter(AccessLevel.PRIVATE)
final class DefaultSoapServiceImpl extends SoapService {

    private final Collection<AbstractNfeSoapService> nfeSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("org.dfe.components.sefaz.port.nfe.impl"))
                    .assignables(Collections.singleton(AbstractNfeSoapService.class))
                    .packageAntMatcher(Collections.singleton(".nfce."))
                    .build())
            .stream()
            .map(it -> (AbstractNfeSoapService) ReflectionUtils.newInstance(it))
            .toList();
    private final Collection<AbstractNfceSoapService> nfceSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("org.dfe.components.sefaz.port.nfce.impl"))
                    .assignables(Collections.singleton(AbstractNfceSoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractNfceSoapService) ReflectionUtils.newInstance(it))
            .toList();
    private final Collection<AbstractCte4SoapService> cte4SoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("org.dfe.components.sefaz.port.cte4.impl"))
                    .assignables(Collections.singleton(AbstractCte4SoapService.class))
                    .build())
            .stream()
            .map(it -> (AbstractCte4SoapService) ReflectionUtils.newInstance(it))
            .toList();
    private final Collection<AbstractMdfeSoapService> mdfeSoapServices = ReflectionUtils.findAllClasses(PackageFinder
                    .builder()
                    .packages(Collections.singleton("org.dfe.components.sefaz.port.mdfe.impl"))
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

    AbstractNfceSoapService getNfceSoapService(UF uf, Environment environment) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getNfceSoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    AbstractCte4SoapService getCte4SoapService(UF uf, Environment environment, CteEmissionType emissionType) throws SoapServiceGeneralException {
        return ReflectionUtils.newInstance(getCte4SoapServices()
                .stream()
                .filter(it -> it.getAuthorizer().allow(uf, environment, emissionType))
                .findFirst()
                .orElseThrow(SoapServiceNotFoundException::new)
                .getClass());
    }

    AbstractMdfeSoapService getMdfeSoapService(UF uf, Environment environment) throws SoapServiceGeneralException {
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
    public Cte4SoapService getCte4SoapService(CteConfig config) throws SoapServiceGeneralException {
        AbstractCte4SoapService service = (AbstractCte4SoapService) getCte4SoapService(config.webServiceUF(), config.environment(), config.emission()).withConfig(config);
        SoapServiceInitializer.cte4().initialize(service);
        return service;
    }

    @Override
    public Collection<? extends Cte4SoapService> getAllCte4SoapService(CteConfig config) throws SoapServiceGeneralException {
        Collection<AbstractCte4SoapService> soapServices = new HashSet<>();
        for (UF uf : UF.states()) {
            for (Environment environment : Environment.values()) {
                for (CteEmissionType type : CteEmissionType.cte())
                    try {
                        soapServices.add(getCte4SoapService(uf, environment, type));
                    } catch (SoapServiceNotFoundException ignored) {
                    }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(soapServices.size());

        for (AbstractCte4SoapService it : soapServices) {
            executorService.submit(() -> {
                try {
                    SoapServiceInitializer.cte4().initialize((AbstractCte4SoapService) (it.withConfig(config)));
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
