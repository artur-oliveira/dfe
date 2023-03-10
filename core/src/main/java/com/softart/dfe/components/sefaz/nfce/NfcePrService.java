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

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings({"unchecked", "unused"})
@Getter
public final class NfcePrService implements NfceService {

    private NfceSoapService soapService;

    public Collection<UF> ufs() {
        return Collections.singletonList(UF.PR);
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
        String xml = data.getSigner().signNfe(NfMarshallerFactory.getInstance().sendNfe(data.getData()), data.getConfig());
        JAXBElement<TEnviNFe> envio = NfUnmarshallerFactory.getInstance().enviNfe(xml);

        for (Validator<TEnviNFe> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnviNFe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetEnviNFe retorno;
        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.prod.NFeAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.prod.NFeAutorizacao4) getSoapService().prodAuthorization()).getNFeAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.prod.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.hom.NFeAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.hom.NFeAutorizacao4) getSoapService().homAuthorization()).getNFeAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TEnviNFe, TRetEnviNFe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> cancel(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().cancelNfe(data.getData()), data.getConfig());
        JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().cancelNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.prod.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.prod.NFeRecepcaoEvento4) getSoapService().prodCancel()).getNFeRecepcaoEvento4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.hom.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.hom.NFeRecepcaoEvento4) getSoapService().homCancel()).getNFeRecepcaoEvento4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TInutNFe, TRetInutNFe>> Pair<TInutNFe, TRetInutNFe> inutilization(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signInut(NfMarshallerFactory.getInstance().inutNfe(data.getData()), data.getConfig());
        JAXBElement<TInutNFe> envio = NfUnmarshallerFactory.getInstance().inutNfe(xml);

        for (Validator<TInutNFe> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TInutNFe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetInutNFe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.prod.NFeInutilizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.prod.NFeInutilizacao4) getSoapService().prodInutilization()).getNFeInutilizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.hom.NFeInutilizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNFeInutilizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.inutilization.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TInutNFe, TRetInutNFe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsSitNFe, TRetConsSitNFe>> Pair<TConsSitNFe, TRetConsSitNFe> queryProtocol(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryProcotolNfe(data.getData());
        JAXBElement<TConsSitNFe> envio = NfUnmarshallerFactory.getInstance().queryProtocolNfe(xml);

        for (Validator<TConsSitNFe> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));

        for (BeforeWebServiceRequest<TConsSitNFe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsSitNFe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.prod.NFeConsultaProtocolo4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.prod.NFeConsultaProtocolo4) getSoapService().prodQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.hom.NFeConsultaProtocolo4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitNFe, TRetConsSitNFe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryReceiptNfe(data.getData());
        JAXBElement<TConsReciNFe> envio = NfUnmarshallerFactory.getInstance().queryReceiptNfe(xml);

        for (Validator<TConsReciNFe> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));

        for (BeforeWebServiceRequest<TConsReciNFe> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsReciNFe retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.prod.NFeRetAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.prod.NFeRetAutorizacao4) getSoapService().prodReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.hom.NFeRetAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.hom.NFeRetAutorizacao4) getSoapService().homReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciNFe, TRetConsReciNFe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));
        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> queryStatusService(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryStatusServiceNfe(data.getData());
        JAXBElement<TConsStatServ> envio = new ObjectFactory().createConsStatServ(data.getData());

        for (Validator<TConsStatServ> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsStatServ retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.prod.NFeStatusServico4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.prod.NFeStatusServico4) getSoapService().prodQueryStatusService()).getNFeStatusServico4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.hom.NFeStatusServico4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.hom.NFeStatusServico4) getSoapService().homQueryStatusService()).getNFeStatusServico4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.status_service.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> substituteCancel(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().substituteCancelNfe(data.getData()), data.getConfig());
        JAXBElement<TEnvEvento> envio = NfUnmarshallerFactory.getInstance().substituteCancelNfe(xml);

        for (Validator<TEnvEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.prod.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.prod.NFeRecepcaoEvento4) getSoapService().prodSubstituteCancel()).getNFeRecepcaoEvento4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.hom.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.hom.NFeRecepcaoEvento4) getSoapService().homSubstituteCancel()).getNFeRecepcaoEvento4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_substitute_cancel.pr.nfce.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(NFEmissionType.NORMAL, emissionType);
    }
}
