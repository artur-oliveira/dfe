package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.enums.cte.identification.CteEmissionType;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.exceptions.DfeUncheckedException;
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteSvspService extends CteAnService {

    @Override
    public <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(CteMarshallerFactory.getInstance().eventCte(data.data()), data.config());
        JAXBElement<TEvento> envio = CteUnmarshallerFactory.getInstance().eventCte(xml);

        for (Validator<TEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.event.svsp.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svsp.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.event.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.event.svsp.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.svsp.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svsp.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.event.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.event.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.svsp.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEvento, TRetEvento> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TInutCTe, TRetInutCTe>> Pair<TInutCTe, TRetInutCTe> inutilization(T data) throws SecurityException, ValidationException, ProcessException {
        throw new DfeUncheckedException("not implemented inutilization for uf " + data.config().uf() + " at environment " + data.config().environment());
    }

    @Override
    public <T extends SefazRequest<TConsSitCTe, TRetConsSitCTe>> Pair<TConsSitCTe, TRetConsSitCTe> querySituation(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().querySituationCte(data.data());
        JAXBElement<TConsSitCTe> envio = CteUnmarshallerFactory.getInstance().querySituationCte(xml);

        for (Validator<TConsSitCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsSitCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsSitCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.svsp.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitCTe, TRetConsSitCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TEnviCTe, TRetEnviCTe>> Pair<TEnviCTe, TRetEnviCTe> reception(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionCte(data.data()), data.config());
        JAXBElement<TEnviCTe> envio = CteUnmarshallerFactory.getInstance().receptionCte(xml);

        for (Validator<TEnviCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnviCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEnviCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svsp.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svsp.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnviCTe, TRetEnviCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionGtve(data.data()), data.config());
        JAXBElement<TGTVe> envio = CteUnmarshallerFactory.getInstance().receptionGtve(xml);

        for (Validator<TGTVe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TGTVe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetGTVe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.prod.CteRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.prod.CteRecepcaoGTVe) getSoapService().prodReceptionGtve()).getCteRecepcaoGTVeSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.prod.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.hom.CteRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.hom.CteRecepcaoGTVe) getSoapService().homReceptionGtve()).getCteRecepcaoGTVeSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svsp.hom.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        for (AfterWebServiceRequest<TGTVe, TRetGTVe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TCTeOS, TRetCTeOS>> Pair<TCTeOS, TRetCTeOS> receptionOs(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionCteOs(data.data()), data.config());
        JAXBElement<TCTeOS> envio = CteUnmarshallerFactory.getInstance().receptionCteOs(xml);

        for (Validator<TCTeOS> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTeOS> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetCTeOS retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svsp.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TCTeOS, TRetCTeOS> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TCTe, TRetCTe>> Pair<TCTe, TRetCTe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionCteSync(data.data()), data.config());
        JAXBElement<TCTe> envio = CteUnmarshallerFactory.getInstance().receptionCteSync(xml);

        for (Validator<TCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.prod.CTeRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.prod.CTeRecepcaoSinc) getSoapService().prodReceptionSync()).getCTeRecepcaoSincSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.prod.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.hom.CTeRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.hom.CTeRecepcaoSinc) getSoapService().homReceptionSync()).getCTeRecepcaoSincSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.svsp.hom.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));
                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        for (AfterWebServiceRequest<TCTe, TRetCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsReciCTe, TRetConsReciCTe>> Pair<TConsReciCTe, TRetConsReciCTe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().queryReceipt(data.data());
        JAXBElement<TConsReciCTe> envio = CteUnmarshallerFactory.getInstance().queryReceipt(xml);

        for (Validator<TConsReciCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsReciCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsReciCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.config().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.config().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.return_reception.svsp.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciCTe, TRetConsReciCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().statusService(data.data());
        JAXBElement<TConsStatServ> envio = CteUnmarshallerFactory.getInstance().statusService(xml);

        for (Validator<TConsStatServ> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsStatServ retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());


            br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svsp.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    Collection<UF> ufs() {
        return Arrays.asList(UF.AP, UF.PE, UF.RR, UF.SP);
    }

    Collection<UF> ufsContigency() {
        return Arrays.asList(UF.MG, UF.PR, UF.RS, UF.AC, UF.AL, UF.AM, UF.BA, UF.CE, UF.DF, UF.ES, UF.GO, UF.MA, UF.PA, UF.PB, UF.PI, UF.RJ, UF.RN, UF.RO, UF.SC, UF.SE, UF.TO);
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
        return allow(uf, environment) && Objects.equals(emissionType, CteEmissionType.NORMAL) || (Arrays.asList(CteEmissionType.EPEC, CteEmissionType.SVCSP).contains(emissionType) && ufsContigency().contains(uf));
    }
}
