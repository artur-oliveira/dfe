package org.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.send.*;
import br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSincResult;
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteSvrsService extends CteAnService {

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
            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEvento) getSoapService().prodEvent()).getCteRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.svrs.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEventoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEvento) getSoapService().homEvent()).getCteRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.event.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.event.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.event.svrs.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsulta) getSoapService().prodQuerySituation()).getCteConsultaSoap12();
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.ObjectFactory();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());


            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsultaSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsulta) getSoapService().homQuerySituation()).getCteConsultaSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.ObjectFactory fc = new br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.ObjectFactory();

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteDadosMsg msg = fc.createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteCabecMsg cabecMsg = fc.createCteCabecMsg();
            cabecMsg.setCUF(AccessKeyParserFactory.cte().uf(data.data().getChCTe()).getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());

            br.inf.portalfiscal.cte.wsdl.query_situation.svrs.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg, new Holder<>(cabecMsg));

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
            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcao) getSoapService().prodReception()).getCteRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.prod.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEnviCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcao) getSoapService().homReception()).getCteRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception.svrs.hom.CteRecepcaoLoteResult resultMsg = ws.cteRecepcaoLote(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CTeRecepcaoGTVe) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.prod.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CTeRecepcaoGTVeSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CTeRecepcaoGTVe) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_gtve.svrs.hom.CteRecepcaoGTVeResult resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOS) getSoapService().prodReceptionOs()).getCteRecepcaoOSSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.prod.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOSSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOS) getSoapService().homReceptionOs()).getCteRecepcaoOSSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.ObjectFactory().createCteDadosMsg();
            try {
                msg.getContent().add(envio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.reception_os.svrs.hom.CteRecepcaoOSResult resultMsg = ws.cteRecepcaoOS(msg);

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
            br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.prod.CteRecepcaoSinc) getSoapService().prodReceptionSync()).getCteRecepcaoSincSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            try {
                CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));

                if (!resultMsg.getContent().isEmpty())
                    retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else {
            br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSincSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSinc) getSoapService().homReceptionSync()).getCteRecepcaoSincSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            try {
                br.inf.portalfiscal.cte.wsdl.reception_sync.svrs.hom.CteRecepcaoSincResult resultMsg = ws.cteRecepcaoSinc(GZIPUtils.compressToString(xml));
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
            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.CteRetRecepcao) getSoapService().prodQueryReceipt()).getCteRetRecepcaoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.prod.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsReciCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.CteRetRecepcaoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.CteRetRecepcao) getSoapService().homQueryReceipt()).getCteRetRecepcaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.CteCabecMsg cabec = new br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabec.setCUF(data.config().webServiceUF().getCode());
            cabec.setVersaoDados(envio.getValue().getVersao());

            br.inf.portalfiscal.cte.wsdl.return_reception.svrs.hom.CteRetRecepcaoResult resultMsg = ws.cteRetRecepcao(msg, new Holder<>(cabec));

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
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServico) getSoapService().prodStatusService()).getCteStatusServicoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServicoSoap12 ws = ((br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServico) getSoapService().homStatusService()).getCteStatusServicoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteCabecMsg cabecMsg = new br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.ObjectFactory().createCteCabecMsg();
            cabecMsg.setCUF(data.config().webServiceUF().getCode());
            cabecMsg.setVersaoDados(data.data().getVersao());
            br.inf.portalfiscal.cte.wsdl.status_service.svrs.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg, new Holder<>(cabecMsg));

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

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
