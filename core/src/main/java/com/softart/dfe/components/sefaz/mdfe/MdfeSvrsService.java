package com.softart.dfe.components.sefaz.mdfe;

import br.inf.portalfiscal.mdfe.classes.*;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import com.softart.dfe.util.GZIPUtils;
import com.softart.dfe.util.RequireUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.Holder;
import lombok.Getter;

import java.util.Collection;
import java.util.Objects;

@Getter
@SuppressWarnings("unused")
public final class MdfeSvrsService implements MdfeService {

    private MdfeSoapService soapService;

    public Collection<UF> ufs() {
        return UF.states();
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return ufs();
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return ufs();
    }

    public boolean allow(UF uf, Environment environment, MdfeEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, MdfeEmissionType.NORMAL);
    }

    @Override
    public MdfeService withSoapService(MdfeSoapService nfeSoapService) {
        this.soapService = nfeSoapService;
        return this;
    }

    @Override
    public <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distributionOld(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendDistributionOld(data.data());
        JAXBElement<DistDFeInt> envio = MdfeUnmarshallerFactory.getInstance().sendDistributionOld(xml);
        for (Validator<DistDFeInt> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<DistDFeInt> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        RetDistDFeInt returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.MDFeDistribuicaoDFeSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.MDFeDistribuicaoDFe) (getSoapService()).distributionOldProd()).getMDFeDistribuicaoDFeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            dadosMsg.getContent().add(envio);
            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.prod.MdfeDistDFeInteresseResult result = ws.mdfeDistDFeInteresse(dadosMsg, new Holder<>(cabecMsg));

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.MDFeDistribuicaoDFeSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.MDFeDistribuicaoDFe) (getSoapService()).distributionOldHom()).getMDFeDistribuicaoDFeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.distributionold.svrs.hom.MdfeDistDFeInteresseResult result = ws.mdfeDistDFeInteresse(dadosMsg, new Holder<>(cabecMsg));

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (RetDistDFeInt) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<DistDFeInt, RetDistDFeInt> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TDistDFe, TRetDistDFe>> Pair<TDistDFe, TRetDistDFe> distribution(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendDistribution(data.data());
        JAXBElement<TDistDFe> envio = MdfeUnmarshallerFactory.getInstance().sendDistribution(xml);
        for (Validator<TDistDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TDistDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetDistDFe returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MDFeDistribuicaoDFeSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MDFeDistribuicaoDFe) (getSoapService()).distributionProd()).getMDFeDistribuicaoDFeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.prod.MdfeDistDFeInteresseResult result = ws.mdfeDistDFeInteresse(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.MDFeDistribuicaoDFeSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.MDFeDistribuicaoDFe) (getSoapService()).distributionHom()).getMDFeDistribuicaoDFeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.distribution.svrs.hom.MdfeDistDFeInteresseResult result = ws.mdfeDistDFeInteresse(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetDistDFe) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TDistDFe, TRetDistDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(MdfeMarshallerFactory.getInstance().sendEvent(data.data()), data.config());
        JAXBElement<TEvento> envio = MdfeUnmarshallerFactory.getInstance().sendEvent(xml);
        for (Validator<TEvento> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TEvento> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetEvento returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.MDFeRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.MDFeRecepcaoEvento) (getSoapService()).eventProd()).getMDFeRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.prod.MdfeRecepcaoEventoResult result = ws.mdfeRecepcaoEvento(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.MDFeRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.MDFeRecepcaoEvento) (getSoapService()).eventHom()).getMDFeRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.event.svrs.hom.MdfeRecepcaoEventoResult result = ws.mdfeRecepcaoEvento(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetEvento) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TEvento, TRetEvento> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TConsReciMDFe, TRetConsReciMDFe>> Pair<TConsReciMDFe, TRetConsReciMDFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendQueryReceipt(data.data());
        JAXBElement<TConsReciMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendQueryReceipt(xml);
        for (Validator<TConsReciMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TConsReciMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetConsReciMDFe returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.MDFeRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.MDFeRetRecepcao) (getSoapService()).queryReceiptProd()).getMDFeRetRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.prod.MdfeRetRecepcaoResult result = ws.mdfeRetRecepcao(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.MDFeRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.MDFeRetRecepcao) (getSoapService()).queryReceiptHom()).getMDFeRetRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_receipt.svrs.hom.MdfeRetRecepcaoResult result = ws.mdfeRetRecepcao(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetConsReciMDFe) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TConsReciMDFe, TRetConsReciMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TConsSitMDFe, TRetConsSitMDFe>> Pair<TConsSitMDFe, TRetConsSitMDFe> querySituation(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendQuerySituation(data.data());
        JAXBElement<TConsSitMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendQuerySituation(xml);
        for (Validator<TConsSitMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TConsSitMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetConsSitMDFe returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.MDFeConsultaSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.MDFeConsulta) (getSoapService()).querySituationProd()).getMDFeConsultaSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.prod.MdfeConsultaMDFResult result = ws.mdfeConsultaMDF(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.MDFeConsultaSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.MDFeConsulta) (getSoapService()).querySituationHom()).getMDFeConsultaSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_situation.svrs.hom.MdfeConsultaMDFResult result = ws.mdfeConsultaMDF(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetConsSitMDFe) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TConsSitMDFe, TRetConsSitMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc>> Pair<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> queryUnclosed(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendQueryUnclosed(data.data());
        JAXBElement<TConsMDFeNaoEnc> envio = MdfeUnmarshallerFactory.getInstance().sendQueryUnclosed(xml);
        for (Validator<TConsMDFeNaoEnc> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TConsMDFeNaoEnc> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetConsMDFeNaoEnc returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MDFeConsNaoEncSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MDFeConsNaoEnc) (getSoapService()).queryUnclosedProd()).getMDFeConsNaoEncSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.prod.MdfeConsNaoEncResult result = ws.mdfeConsNaoEnc(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.MDFeConsNaoEncSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.MDFeConsNaoEnc) (getSoapService()).queryUnclosedHom()).getMDFeConsNaoEncSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.query_unclosed.svrs.hom.MdfeConsNaoEncResult result = ws.mdfeConsNaoEnc(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetConsMDFeNaoEnc) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TEnviMDFe, TRetEnviMDFe>> Pair<TEnviMDFe, TRetEnviMDFe> reception(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signMdfe(MdfeMarshallerFactory.getInstance().sendReception(data.data()), data.config());
        JAXBElement<TEnviMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendReception(xml);
        for (Validator<TEnviMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TEnviMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetEnviMDFe returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.MDFeRecepcaoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.MDFeRecepcao) (getSoapService()).receptionProd()).getMDFeRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.prod.MdfeRecepcaoLoteResult result = ws.mdfeRecepcaoLote(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.MDFeRecepcaoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.MDFeRecepcao) (getSoapService()).receptionHom()).getMDFeRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.reception.svrs.hom.MdfeRecepcaoLoteResult result = ws.mdfeRecepcaoLote(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetEnviMDFe) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TEnviMDFe, TRetEnviMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TMDFe, TRetMDFe>> Pair<TMDFe, TRetMDFe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signMdfe(MdfeMarshallerFactory.getInstance().sendReceptionSync(data.data()), data.config());
        JAXBElement<TMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendReceptionSync(xml);
        for (Validator<TMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetMDFe returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.prod.MDFeRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.prod.MDFeRecepcaoSinc) (getSoapService()).receptionSyncProd()).getMDFeRecepcaoSincSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.prod.MdfeRecepcaoResult result;
            try {
                result = ws.mdfeRecepcao(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.hom.MDFeRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.hom.MDFeRecepcaoSinc) (getSoapService()).receptionSyncHom()).getMDFeRecepcaoSincSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.reception_sync.svrs.hom.MdfeRecepcaoResult result;
            try {
                result = ws.mdfeRecepcao(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetMDFe) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TMDFe, TRetMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = MdfeMarshallerFactory.getInstance().sendStatusService(data.data());
        JAXBElement<TConsStatServ> envio = MdfeUnmarshallerFactory.getInstance().sendStatusService(xml);
        for (Validator<TConsStatServ> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TConsStatServ> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        TRetConsStatServ returnValue;
        JAXBElement<?> resultElement = null;

        if (data.config().production()) {
            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MDFeStatusServicoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MDFeStatusServico) (getSoapService()).statusServiceProd()).getMDFeStatusServicoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.prod.MdfeStatusServicoMDFResult result = ws.mdfeStatusServicoMDF(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        } else {
            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.MDFeStatusServicoSoap12 ws = ((br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.MDFeStatusServico) (getSoapService()).statusServiceHom()).getMDFeStatusServicoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.MdfeDadosMsg dadosMsg = fc.createMdfeDadosMsg();
            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.MdfeCabecMsg cabecMsg = fc.createMdfeCabecMsg();
            cabecMsg.setCUF(data.config().uf().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            dadosMsg.getContent().add(envio);

            br.inf.portalfiscal.mdfe.wsdl.status_service.svrs.hom.MdfeStatusServicoMDFResult result = ws.mdfeStatusServicoMDF(dadosMsg);

            if (!result.getContent().isEmpty()) {
                resultElement = (JAXBElement<?>) result.getContent().get(0);
            }
        }

        returnValue = (TRetConsStatServ) RequireUtils.nonNull(resultElement, "resultElement of soap return cannot be null").getValue();

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), returnValue, data.config()));
        }

        return new PairImpl<>(envio.getValue(), returnValue);
    }
}
