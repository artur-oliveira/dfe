package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSincResult;
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

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.Holder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteSvrsService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

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
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.CteInutilizacao) getSoapService().prodInutilization()).getCteInutilizacaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.prod.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.CteInutilizacao) getSoapService().homInutilization()).getCteInutilizacaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.svrs.hom.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg);

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
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.ObjectFactory();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());


            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.getData().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

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
            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

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
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CTeRecepcaoGTVe) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());
            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CTeRecepcaoGTVe) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);

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
            br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSinc) getSoapService().prodReceptionSync()).getCteRecepcaoSincSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());
            try {
                CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSinc) getSoapService().homReceptionSync()).getCteRecepcaoSincSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.svrs.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

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
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    private Collection<UF> ufs() {
        return Arrays.asList(UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RS, UF.RO, UF.SC, UF.SE, UF.TO);
    }

    private Collection<UF> ufsContigency() {
        return Arrays.asList(UF.MS, UF.MT, UF.SP, UF.AP, UF.PE, UF.RR);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return ufs();
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return ufs();
    }

    @Override
    public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL) || (Arrays.asList(CteEmissionType.EPEC, CteEmissionType.SVCRS).contains(emissionType) && ufsContigency().contains(uf));
    }
}
