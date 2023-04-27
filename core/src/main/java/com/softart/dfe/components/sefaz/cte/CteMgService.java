package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import com.softart.dfe.util.GZIPUtils;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteMgService extends CteAnService {

    @Override
    public <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(CteMarshallerFactory.getInstance().eventCte(data.getData()), data.getConfig());
        JAXBElement<TEvento> envio = CteUnmarshallerFactory.getInstance().eventCte(xml);

        for (Validator<TEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mg.prod.RecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mg.hom.RecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEvento, TRetEvento> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TInutCTe, TRetInutCTe>> Pair<TInutCTe, TRetInutCTe> inutilization(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signInut(CteMarshallerFactory.getInstance().inutilizationCte(data.getData()), data.getConfig());
        JAXBElement<TInutCTe> envio = CteUnmarshallerFactory.getInstance().inutCte(xml);

        for (Validator<TInutCTe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TInutCTe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetInutCTe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.CteInutilizacao) getSoapService().prodInutilization()).getCteInutilizacaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.prod.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.CteInutilizacao) getSoapService().homInutilization()).getCteInutilizacaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.mg.hom.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TInutCTe, TRetInutCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsSitCTe, TRetConsSitCTe>> Pair<TConsSitCTe, TRetConsSitCTe> querySituation(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().querySituationCte(data.getData());
        JAXBElement<TConsSitCTe> envio = CteUnmarshallerFactory.getInstance().querySituationCte(xml);

        for (Validator<TConsSitCTe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsSitCTe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsSitCTe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitCTe, TRetConsSitCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TEnviCTe, TRetEnviCTe>> Pair<TEnviCTe, TRetEnviCTe> reception(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signCte(CteMarshallerFactory.getInstance().receptionCte(data.getData()), data.getConfig());
        JAXBElement<TEnviCTe> envio = CteUnmarshallerFactory.getInstance().receptionCte(xml);

        for (Validator<TEnviCTe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnviCTe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetEnviCTe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnviCTe, TRetEnviCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <T extends SefazRequest<TCTeOS, TRetCTeOS>> Pair<TCTeOS, TRetCTeOS> receptionOs(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signCte(CteMarshallerFactory.getInstance().receptionCteOs(data.getData()), data.getConfig());
        JAXBElement<TCTeOS> envio = CteUnmarshallerFactory.getInstance().receptionCteOs(xml);

        for (Validator<TCTeOS> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTeOS> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetCTeOS retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabecMsg));
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TCTeOS, TRetCTeOS> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TCTe, TRetCTe>> Pair<TCTe, TRetCTe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signCte(CteMarshallerFactory.getInstance().receptionCteSync(data.getData()), data.getConfig());
        JAXBElement<TCTe> envio = CteUnmarshallerFactory.getInstance().receptionCteSync(xml);

        for (Validator<TCTe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetCTe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getInfCte().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getInfCte().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TCTe, TRetCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsReciCTe, TRetConsReciCTe>> Pair<TConsReciCTe, TRetConsReciCTe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().queryReceipt(data.getData());
        JAXBElement<TConsReciCTe> envio = CteUnmarshallerFactory.getInstance().queryReceipt(xml);

        for (Validator<TConsReciCTe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsReciCTe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsReciCTe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mg.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciCTe, TRetConsReciCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().statusService(data.getData());
        JAXBElement<TConsStatServ> envio = CteUnmarshallerFactory.getInstance().statusService(xml);

        for (Validator<TConsStatServ> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsStatServ retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.MG);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.MG);
    }

    @Override
    public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
    }
}
