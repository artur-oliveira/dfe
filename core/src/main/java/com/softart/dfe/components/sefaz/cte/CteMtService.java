package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import br.inf.portalfiscal.cte.wsdl.reception_sync.mt.prod.CteRecepcaoSincResult;
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
public final class CteMtService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.mt.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.mt.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.mt.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mt.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.mt.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.mt.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.mt.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.CteInutilizacao) getSoapService().prodInutilization()).getCteInutilizacao();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getData().getInfInut().getCUF());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.prod.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.CteInutilizacao) getSoapService().homInutilization()).getCteInutilizacao();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getData().getInfInut().getCUF());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.mt.hom.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsulta();
            br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.ObjectFactory();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());


            br.inf.portalfiscal.cte.wsdl.query_situation.mt.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsulta();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.ObjectFactory();

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.mt.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.reception.mt.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mt.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mt.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.mt.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mt.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.mt.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mt.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mt.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.mt.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mt.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.prod.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.prod.CteRecepcaoGTVe) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());
            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.prod.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.hom.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.hom.CteRecepcaoGTVe) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.mt.hom.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mt.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.reception_sync.mt.prod.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.mt.prod.CteRecepcaoSinc) getSoapService().prodReceptionSync()).getCteRecepcaoSincSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).replacePortAddress("https://cte.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc").build());

            try {
                CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.mt.hom.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.mt.hom.CteRecepcaoSinc) getSoapService().homReceptionSync()).getCteRecepcaoSincSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).replacePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CteRecepcaoSinc").build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.mt.hom.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().uf().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.mt.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServico();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().uf().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mt.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServico();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().uf().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mt.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.MT);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.MT);
    }

    @Override
    public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
    }
}
