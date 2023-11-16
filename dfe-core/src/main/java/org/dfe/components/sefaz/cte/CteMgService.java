package org.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import org.dfe.components.internal.PairImpl;
import org.dfe.components.internal.parser.AccessKeyParserFactory;
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
import jakarta.xml.ws.Holder;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteMgService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mg.prod.RecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.event.mg.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.mg.hom.RecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.event.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.mg.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.mg.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnviCTe, TRetEnviCTe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TGTVe, TRetGTVe>> Pair<TGTVe, TRetGTVe> receptionGtve(T data) {
        throw new UnsupportedOperationException("Not implemented");
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
            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabecMsg));
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.mg.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getInfCte().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(GZIPUtils.compressToString(xml));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.reception.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(envio.getValue().getInfCte().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.mg.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabecMsg));
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
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
            br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.config().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setVersaoDados(envio.getValue().getVersao());
            cabecMsg.setCUF(data.config().webServiceUF().getCode());

            br.inf.portalfiscal.cte.wsdl.return_reception.mg.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mg.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.mg.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

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
