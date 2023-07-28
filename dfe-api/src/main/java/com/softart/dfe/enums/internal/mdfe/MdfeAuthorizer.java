package com.softart.dfe.enums.internal.mdfe;

import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.allow.AllowUF;
import com.softart.dfe.interfaces.internal.mdfe.MdfeURL;
import com.softart.dfe.util.ClassUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public enum MdfeAuthorizer implements MdfeURL, AllowUF {
    SVRS {
        @Override
        public String statusServiceHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx";
        }

        @Override
        public String queryUnclosedHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }

        @Override
        public String distributionHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeDistribuicaoDFe/MDFeDistribuicaoDFe.asmx";
        }

        @Override
        public String receptionSyncHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoSinc/MDFeRecepcaoSinc.asmx";
        }

        @Override
        public String receptionHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String queryReceiptHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String eventHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String querySituationHom() {
            return "https://mdfe-homologacao.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public String statusServiceProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeStatusServico/MDFeStatusServico.asmx";
        }

        @Override
        public String queryUnclosedProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeConsNaoEnc/MDFeConsNaoEnc.asmx";
        }

        @Override
        public String distributionProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeDistribuicaoDFe/MDFeDistribuicaoDFe.asmx";
        }

        @Override
        public String receptionSyncProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoSinc/MDFeRecepcaoSinc.asmx";
        }

        @Override
        public String receptionProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcao/MDFeRecepcao.asmx";
        }

        @Override
        public String queryReceiptProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeRetRecepcao/MDFeRetRecepcao.asmx";
        }

        @Override
        public String eventProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeRecepcaoEvento/MDFeRecepcaoEvento.asmx";
        }

        @Override
        public String querySituationProd() {
            return "https://mdfe.svrs.rs.gov.br/ws/MDFeConsulta/MDFeConsulta.asmx";
        }

        @Override
        public Collection<UF> allowedUfsProduction() {
            return UF.states();
        }

        @Override
        public Collection<UF> allowedUfsHomologation() {
            return UF.states();
        }
    };

    public static Collection<String> get(UF uf, Environment environment) throws NoProviderFound {
        MdfeAuthorizer serviceURL = Arrays.stream(MdfeAuthorizer.values()).filter(it -> it.allow(uf, environment)).findFirst().orElseThrow(NoProviderFound::new);

        return environment.production() ? serviceURL.prod() : serviceURL.hom();
    }

    public Collection<String> hom() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("hom")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }

    public Collection<String> prod() {
        return Arrays.stream(this.getClass().getDeclaredMethods()).filter(it -> it.getName().toLowerCase().endsWith("prod")).map(it -> ClassUtils.get(it, this)).filter(Objects::nonNull).map(String::valueOf).collect(Collectors.toSet());
    }
}
