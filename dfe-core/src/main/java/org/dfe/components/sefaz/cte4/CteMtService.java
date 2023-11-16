package org.dfe.components.sefaz.cte4;

import br.inf.portalfiscal.cte.send400.*;
import org.dfe.components.internal.PairImpl;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.enums.cte.identification.CteEmissionType;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.process.AfterWebServiceRequest;
import org.dfe.interfaces.process.BeforeWebServiceRequest;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.validation.Validator;
import org.dfe.models.internal.After;
import org.dfe.models.internal.Before;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.wsdl.ProviderConfig;
import org.dfe.util.GZIPUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteMtService extends CteAnService {

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
            br.inf.portalfiscal.cte4.wsdl.event.mt.prod.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.mt.prod.CTeRecepcaoEventoV4) getSoapService().prodEvent()).getCTeRecepcaoEventoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte4.wsdl.event.mt.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.event.mt.hom.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.mt.hom.CTeRecepcaoEventoV4) getSoapService().homEvent()).getCTeRecepcaoEventoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoEventoV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.event.mt.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

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
            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod.CTeConsultaV4) getSoapService().prodQuerySituation()).getCTeConsultaV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.CTeConsultaV4) getSoapService().homQuerySituation()).getCTeConsultaV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeConsultaV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.mt.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

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
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.prod.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.prod.CTeRecepcaoGTVeV4) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.prod.CteRecepcaoGTVeResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.hom.CTeRecepcaoGTVeV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.hom.CTeRecepcaoGTVeV4) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoGTVeV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.mt.hom.CteRecepcaoGTVeResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.reception_os.mt.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.mt.prod.CTeRecepcaoOSV4) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.mt.prod.CteRecepcaoOSResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoOS(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_os.mt.hom.CTeRecepcaoOSV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.mt.hom.CTeRecepcaoOSV4) getSoapService().prodReceptionOs()).getCTeRecepcaoOSV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews/services/CTeRecepcaoOSV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.mt.hom.CteRecepcaoOSResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.prod.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.prod.CTeRecepcaoSincV4) getSoapService().prodReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).overridePortAddress("https://cte.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4").build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.prod.CteRecepcaoResult resultMsg;
            try {
                resultMsg = ws.cteRecepcao(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.hom.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.hom.CTeRecepcaoSincV4) getSoapService().homReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeRecepcaoSincV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.mt.hom.CteRecepcaoResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.CTeStatusServicoV4) getSoapService().prodStatusService()).getCTeStatusServicoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.mt.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.status_service.mt.hom.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.mt.hom.CTeStatusServicoV4) getSoapService().homStatusService()).getCTeStatusServicoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().overridePortAddress("https://homologacao.sefaz.mt.gov.br/ctews2/services/CTeStatusServicoV4").port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.mt.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.mt.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.mt.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

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
