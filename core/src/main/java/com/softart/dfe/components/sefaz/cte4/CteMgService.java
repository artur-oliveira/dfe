package com.softart.dfe.components.sefaz.cte4;

import br.inf.portalfiscal.cte.send400.*;
import com.softart.dfe.components.internal.PairImpl;
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

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteMgService extends CteAnService {

    @Override
    public <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(CteMarshallerFactory.getInstance().eventCte(data.data()), data.config());
        JAXBElement<TEvento> envio = CteUnmarshallerFactory.getInstance().eventCte400(xml);

        for (Validator<TEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.event.mg.prod.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.mg.prod.CTeRecepcaoEventoV4) getSoapService().prodEvent()).getCTeRecepcaoEventoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte4.wsdl.event.mg.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.event.mg.hom.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.mg.hom.CTeRecepcaoEventoV4) getSoapService().homEvent()).getCTeRecepcaoEventoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.event.mg.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEvento, TRetEvento> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsSitCTe, TRetConsSitCTe>> Pair<TConsSitCTe, TRetConsSitCTe> querySituation(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().querySituationCte(data.data());
        JAXBElement<TConsSitCTe> envio = CteUnmarshallerFactory.getInstance().querySituationCte400(xml);

        for (Validator<TConsSitCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsSitCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsSitCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.prod.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.mg.prod.CTeConsultaV4) getSoapService().prodQuerySituation()).getCTeConsultaV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.hom.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.mg.hom.CTeConsultaV4) getSoapService().homQuerySituation()).getCTeConsultaV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.mg.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitCTe, TRetConsSitCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionGtve(data.data()), data.config());
        JAXBElement<TGTVe> envio = CteUnmarshallerFactory.getInstance().receptionGtve400(xml);

        for (Validator<TGTVe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TGTVe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetGTVe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.prod.CTeRecepcaoGTVeV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.prod.CTeRecepcaoGTVeV4) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.prod.CteRecepcaoGTVeResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.hom.CTeRecepcaoGTVeV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.hom.CTeRecepcaoGTVeV4) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mg.hom.CteRecepcaoGTVeResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TGTVe, TRetGTVe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TCTeOS, TRetCTeOS>> Pair<TCTeOS, TRetCTeOS> receptionOs(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signCte(CteMarshallerFactory.getInstance().receptionCteOs(data.data()), data.config());
        JAXBElement<TCTeOS> envio = CteUnmarshallerFactory.getInstance().receptionCteOs400(xml);

        for (Validator<TCTeOS> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTeOS> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetCTeOS retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.reception_os.mg.prod.CTeRecepcaoOSV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.mg.prod.CTeRecepcaoOSV4) getSoapService().prodReceptionOs()).getCTeRecepcaoOSV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.mg.prod.CteRecepcaoOSResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoOS(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_os.mg.hom.CTeRecepcaoOSV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.mg.hom.CTeRecepcaoOSV4) getSoapService().homReceptionOs()).getCTeRecepcaoOSV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.mg.hom.CteRecepcaoOSResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoOS(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
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
        JAXBElement<TCTe> envio = CteUnmarshallerFactory.getInstance().receptionCteSync400(xml);

        for (Validator<TCTe> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TCTe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetCTe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.prod.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.prod.CTeRecepcaoSincV4) getSoapService().prodReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.prod.CteRecepcaoResult resultMsg;
            try {
                resultMsg = ws.cteRecepcao(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.hom.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.hom.CTeRecepcaoSincV4) getSoapService().homReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.mg.hom.CteRecepcaoResult resultMsg;
            try {
                resultMsg = ws.cteRecepcao(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TCTe, TRetCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().statusService(data.data());
        JAXBElement<TConsStatServ> envio = CteUnmarshallerFactory.getInstance().statusService400(xml);

        for (Validator<TConsStatServ> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsStatServ retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.status_service.mg.prod.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.mg.prod.CTeStatusServicoV4) getSoapService().prodStatusService()).getCTeStatusServicoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.mg.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.status_service.mg.hom.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.mg.hom.CTeStatusServicoV4) getSoapService().homStatusService()).getCTeStatusServicoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.mg.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

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
