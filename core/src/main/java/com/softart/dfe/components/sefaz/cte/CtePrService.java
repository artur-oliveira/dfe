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
public final class CtePrService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.pr.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.pr.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.event.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.pr.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.pr.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.pr.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.pr.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.pr.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.pr.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.event.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.pr.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.pr.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.pr.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.pr.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));
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
            br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.CteInutilizacao) getSoapService().prodInutilization()).getCteInutilizacaoServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.inutilization.pr.prod.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.CteInutilizacao) getSoapService().homInutilization()).getCteInutilizacaoServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.inutilization.pr.hom.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaServicePort();
            br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.ObjectFactory();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.pr.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.ObjectFactory();

            br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.pr.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.reception.pr.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.pr.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.reception.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.pr.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.pr.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.pr.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.pr.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.pr.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.pr.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.reception.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.pr.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.pr.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.pr.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.pr.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnviCTe, TRetEnviCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signCte(CteMarshallerFactory.getInstance().receptionGtve(data.getData()), data.getConfig());
        JAXBElement<TGTVe> envio = CteUnmarshallerFactory.getInstance().receptionGtve(xml);

        for (Validator<TGTVe> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TGTVe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetGTVe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.prod.CteRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.prod.CteRecepcaoGTVe) getSoapService().prodReceptionGtve()).getCteRecepcaoGTVeServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.prod.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.hom.CteRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.hom.CteRecepcaoGTVe) getSoapService().homReceptionGtve()).getCteRecepcaoGTVeServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.pr.hom.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        for (AfterWebServiceRequest<TGTVe, TRetGTVe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
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
            br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.pr.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.pr.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.CteRecepcaoSinc) getSoapService().prodReceptionSync()).getCteRecepcaoSincServicePort();
            br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.CteDadosMsg dadosMsg = new br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.ObjectFactory().createCteDadosMsg();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                dadosMsg.getContent().add(GZIPUtils.compressToString(xml));

                br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.ObjectFactory().createCteCabecMsg();
                cabec.setCUF(data.getConfig().webServiceUF().getCode());
                cabec.setVersaoDados(envio.getValue().getInfCte().getVersao());

                br.inf.portalfiscal.cte.wsdl.reception_sync.pr.prod.CteRecepcaoResult resultMsg = ws.cteRecepcaoSinc(dadosMsg, new Holder<>(cabec));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.CteRecepcaoSinc) getSoapService().homReceptionSync()).getCteRecepcaoSincServicePort();
            br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.CteDadosMsg dadosMsg = new br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.ObjectFactory().createCteDadosMsg();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                dadosMsg.getContent().add(GZIPUtils.compressToString(xml));

                br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.ObjectFactory().createCteCabecMsg();
                cabec.setCUF(data.getConfig().webServiceUF().getCode());
                cabec.setVersaoDados(envio.getValue().getInfCte().getVersao());

                br.inf.portalfiscal.cte.wsdl.reception_sync.pr.hom.CteRecepcaoResult resultMsg = ws.cteRecepcaoSinc(dadosMsg, new Holder<>(cabec));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

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
            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());


            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.pr.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.pr.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.pr.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.PR);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.PR);
    }

    @Override
    public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
    }
}
