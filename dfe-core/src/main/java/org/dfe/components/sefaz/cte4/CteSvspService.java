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
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("unused")
public final class CteSvspService extends CteAnService {

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
            br.inf.portalfiscal.cte4.wsdl.event.svsp.prod.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.svsp.prod.CTeRecepcaoEventoV4) getSoapService().prodEvent()).getCTeRecepcaoEventoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte4.wsdl.event.svsp.prod.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetEvento) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.event.svsp.hom.CTeRecepcaoEventoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.event.svsp.hom.CTeRecepcaoEventoV4) getSoapService().homEvent()).getCTeRecepcaoEventoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.event.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.event.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.event.svsp.hom.CteRecepcaoEventoResult resultMsg = ws.cteRecepcaoEvento(msg);

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
            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.prod.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.prod.CTeConsultaV4) getSoapService().prodQuerySituation()).getCTeConsultaV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.prod.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsSitCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom.CTeConsultaV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom.CTeConsultaV4) getSoapService().homQuerySituation()).getCTeConsultaV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);


            br.inf.portalfiscal.cte4.wsdl.query_situation.svsp.hom.CteConsultaCTResult resultMsg = ws.cteConsultaCT(msg);

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
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.prod.CTeRecepcaoGTVeV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.prod.CTeRecepcaoGTVeV4) getSoapService().prodReceptionGtve()).getCTeRecepcaoGTVeV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.prod.CteRecepcaoGTVeResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoGTVe(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetGTVe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.hom.CTeRecepcaoGTVeV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.hom.CTeRecepcaoGTVeV4) getSoapService().homReceptionGtve()).getCTeRecepcaoGTVeV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_gtve.svsp.hom.CteRecepcaoGTVeResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod.CTeRecepcaoOSV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod.CTeRecepcaoOSV4) getSoapService().prodReceptionOs()).getCTeRecepcaoOSV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.prod.CteRecepcaoOSResult resultMsg;
            try {
                resultMsg = ws.cteRecepcaoOS(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTeOS) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.hom.CTeRecepcaoOSV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.hom.CTeRecepcaoOSV4) getSoapService().homReceptionOs()).getCTeRecepcaoOSV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_os.svsp.hom.CteRecepcaoOSResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.prod.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.prod.CTeRecepcaoSincV4) getSoapService().prodReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.prod.CteRecepcaoResult resultMsg;
            try {
                resultMsg = ws.cteRecepcao(GZIPUtils.compressToString(xml));
            } catch (IOException e) {
                throw new DfeUncheckedException(e);
            }
            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetCTe) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.hom.CTeRecepcaoSincV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.hom.CTeRecepcaoSincV4) getSoapService().homReceptionSync()).getCTeRecepcaoSincV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.reception_sync.svsp.hom.CteRecepcaoResult resultMsg;
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
            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.prod.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.svsp.prod.CTeStatusServicoV4) getSoapService().prodStatusService()).getCTeStatusServicoV4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.prod.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.svsp.prod.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.prod.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (TRetConsStatServ) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.hom.CTeStatusServicoV4Soap12 ws = ((br.inf.portalfiscal.cte4.wsdl.status_service.svsp.hom.CTeStatusServicoV4) getSoapService().homStatusService()).getCTeStatusServicoV4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.hom.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.status_service.svsp.hom.ObjectFactory().createCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.status_service.svsp.hom.CteStatusServicoCTResult resultMsg = ws.cteStatusServicoCT(msg);

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
