package com.softart.dfe.components.sefaz.nfce;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.nf.nfce.NfceService;
import com.softart.dfe.interfaces.sefaz.port.NfceSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import lombok.Getter;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings({"unchecked", "unused"})
@Getter
public final class NfceSvrsService implements NfceService {

    private NfceSoapService soapService;

    public Collection<UF> ufs() {
        return Arrays.asList(UF.AC, UF.AL, UF.AP, UF.BA, UF.DF, UF.ES, UF.MA, UF.PA, UF.PB, UF.PE, UF.PI, UF.RJ, UF.RN, UF.RO, UF.RR, UF.SC, UF.SE, UF.TO);
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return ufs();
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return ufs();
    }

    @Override
    public NfceService withSoapService(NfceSoapService soapService) {
        this.soapService = soapService;
        return this;
    }

    @Override
    public <T extends SefazRequest<TEnviNFe, TRetEnviNFe>> Pair<TEnviNFe, TRetEnviNFe> authorize(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signNfe(NfMarshallerFactory.getInstance().sendNfe(data.data()), data.config());
        JAXBElement<TEnviNFe> envio = NfUnmarshallerFactory.getInstance().enviNfe(xml);

        for (Validator<TEnviNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnviNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEnviNFe retorno;
        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod.NFeAutorizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod.NFeAutorizacao4) getSoapService().prodAuthorization()).getNFeAutorizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.hom.NFeAutorizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.hom.NFeAutorizacao4) getSoapService().homAuthorization()).getNFeAutorizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TEnviNFe, TRetEnviNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> cancel(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(NfMarshallerFactory.getInstance().cancelNfe(data.data()), data.config());
        JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().cancelNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.prod.NFeRecepcaoEvento4) getSoapService().prodCancel()).getNFeRecepcaoEvento4Soap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.hom.NFeRecepcaoEvento4) getSoapService().homCancel()).getNFeRecepcaoEvento4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_cancel.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TInutNFe, TRetInutNFe>> Pair<TInutNFe, TRetInutNFe> inutilization(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signInut(NfMarshallerFactory.getInstance().inutNfe(data.data()), data.config());
        JAXBElement<TInutNFe> envio = NfUnmarshallerFactory.getInstance().inutNfe(xml);

        for (Validator<TInutNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TInutNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetInutNFe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.prod.NFeInutilizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.prod.NFeInutilizacao4) getSoapService().prodInutilization()).getNFeInutilizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.hom.NFeInutilizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNFeInutilizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.inutilization.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TInutNFe, TRetInutNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsSitNFe, TRetConsSitNFe>> Pair<TConsSitNFe, TRetConsSitNFe> queryProtocol(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryProcotolNfe(data.data());
        JAXBElement<TConsSitNFe> envio = NfUnmarshallerFactory.getInstance().queryProtocolNfe(xml);

        for (Validator<TConsSitNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));

        for (BeforeWebServiceRequest<TConsSitNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsSitNFe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.prod.NFeConsultaProtocolo4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.prod.NFeConsultaProtocolo4) getSoapService().prodQueryProtocol()).getNFeConsultaProtocolo4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.hom.NFeConsultaProtocolo4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNFeConsultaProtocolo4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_protocol.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitNFe, TRetConsSitNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryReceiptNfe(data.data());
        JAXBElement<TConsReciNFe> envio = NfUnmarshallerFactory.getInstance().queryReceiptNfe(xml);

        for (Validator<TConsReciNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));

        for (BeforeWebServiceRequest<TConsReciNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsReciNFe retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.prod.NFeRetAutorizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.prod.NFeRetAutorizacao4) getSoapService().prodReturnAuthorization()).getNFeRetAutorizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.hom.NFeRetAutorizacao4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.hom.NFeRetAutorizacao4) getSoapService().homReturnAuthorization()).getNFeRetAutorizacao4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.return_authorization.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciNFe, TRetConsReciNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));
        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> queryStatusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryStatusServiceNfe(data.data());
        JAXBElement<TConsStatServ> envio = new ObjectFactory().createConsStatServ(data.data());

        for (Validator<TConsStatServ> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsStatServ retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.prod.NFeStatusServico4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.prod.NFeStatusServico4) getSoapService().prodQueryStatusService()).getNFeStatusServico4Soap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.hom.NFeStatusServico4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.hom.NFeStatusServico4) getSoapService().homQueryStatusService()).getNFeStatusServico4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.status_service.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> substituteCancel(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(NfMarshallerFactory.getInstance().substituteCancelNfe(data.data()), data.config());
        JAXBElement<TEnvEvento> envio = NfUnmarshallerFactory.getInstance().substituteCancelNfe(xml);

        for (Validator<TEnvEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnvEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEnvEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.prod.NFeRecepcaoEvento4) getSoapService().prodSubstituteCancel()).getNFeRecepcaoEvento4Soap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.hom.NFeRecepcaoEvento4) getSoapService().homSubstituteCancel()).getNFeRecepcaoEvento4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.svrs.nfce.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(NFEmissionType.NORMAL, emissionType);
    }
}
