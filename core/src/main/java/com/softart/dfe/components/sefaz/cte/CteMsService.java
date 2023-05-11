package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import br.inf.portalfiscal.cte.wsdl.reception_sync.ms.prod.CteRecepcaoSincResult;
import com.softart.dfe.components.internal.PairImpl;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteMsService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.ms.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.ms.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.ms.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.ms.prod.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.ms.prod.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.ms.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.ms.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.ms.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.event.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.ms.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.ms.hom.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.ms.hom.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.ms.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

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
            br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteInutilizacao) getSoapService().prodInutilization()).getCteInutilizacaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.inutilization.ms.prod.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetInutCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.CteInutilizacaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.CteInutilizacao) getSoapService().homInutilization()).getCteInutilizacaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.inutilization.ms.hom.CteInutilizacaoCTResult resultMsg = ws.cteInutilizacaoCT(msg);

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
            br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();
            br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.ObjectFactory();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            Holder<br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.CTeCabecMsg> cabec = new Holder<>(fc.createCTeCabecMsg());
            cabec.value.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.value.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.query_situation.ms.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, cabec);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.ObjectFactory();

            Holder<br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.CTeCabecMsg> cabec = new Holder<>(fc.createCTeCabecMsg());
            cabec.value.setCUF(data.getConfig().webServiceUF().getCode());
            cabec.value.setVersaoDados(envio.getValue().getVersao());
            br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.ms.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, cabec);

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
            br.inf.portalfiscal.cte.wsdl.reception.ms.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.ms.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.ms.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.ms.prod.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.ms.prod.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.ms.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.ms.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.ms.hom.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.ms.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnviCTe, TRetEnviCTe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) {
        throw new UnsupportedOperationException("not implemented");
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
            br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.prod.CteOSRecepcaoResult resultMsg = ws.cteOSRecepcao(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.ms.hom.CteOSRecepcaoResult resultMsg = ws.cteOSRecepcao(msg);

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
            br.inf.portalfiscal.cte.wsdl.reception_sync.ms.prod.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.ms.prod.CteRecepcaoSinc) getSoapService().prodReceptionSync()).getCteRecepcaoSincSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());
            try {
                CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.ms.hom.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.ms.hom.CteRecepcaoSinc) getSoapService().homReceptionSync()).getCteRecepcaoSincSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.ms.hom.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_receipt.ms.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

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
            br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.ms.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.CTeCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.ObjectFactory().createCTeCabecMsg();
            cabecMsg.setCUF(data.getConfig().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.getData().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.ms.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return Collections.singletonList(UF.MS);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return Collections.singletonList(UF.MS);
    }

    @Override
    public boolean allow(UF uf, Environment environment, CteEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL);
    }
}
