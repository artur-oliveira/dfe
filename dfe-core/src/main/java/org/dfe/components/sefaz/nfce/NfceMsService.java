package org.dfe.components.sefaz.nfce;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import lombok.Getter;
import org.dfe.components.internal.PairImpl;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.components.internal.xml.objectfactory.NfObjectFactoryWrapperFactory;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.nf.identification.NFEmissionType;
import org.dfe.exceptions.DfeUncheckedException;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.process.AfterWebServiceRequest;
import org.dfe.interfaces.process.BeforeWebServiceRequest;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.sefaz.nf.nfce.NfceService;
import org.dfe.interfaces.sefaz.port.NfceSoapService;
import org.dfe.interfaces.validation.Validator;
import org.dfe.models.internal.After;
import org.dfe.models.internal.Before;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.wsdl.ProviderConfig;
import org.dfe.util.GZIPUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@SuppressWarnings({"unchecked", "unused"})
@Getter
public final class NfceMsService implements NfceService {
    private NfceSoapService soapService;

    public Collection<UF> ufs() {
        return Collections.singletonList(UF.MS);
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
            br.inf.portalfiscal.nfce.wsdl.authorization.ms.prod.NFeAutorizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.authorization.ms.prod.NFeAutorizacao4) getSoapService().prodAuthorization()).getNfeAutorizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            String gzip;
            try {
                gzip = GZIPUtils.compressToString(xml);
            } catch (Exception e) {
                throw new DfeUncheckedException(e);
            }
            br.inf.portalfiscal.nfce.wsdl.authorization.ms.prod.NfeResultMsg2 resultMsg = ws.nfeAutorizacaoLoteZIP(gzip);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.authorization.ms.hom.NFeAutorizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.authorization.ms.hom.NFeAutorizacao4) getSoapService().homAuthorization()).getNfeAutorizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            String gzip;
            try {
                gzip = GZIPUtils.compressToString(xml);
            } catch (Exception e) {
                throw new DfeUncheckedException(e);
            }
            br.inf.portalfiscal.nfce.wsdl.authorization.ms.hom.NfeResultMsg2 resultMsg = ws.nfeAutorizacaoLoteZIP(gzip);

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
            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.prod.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.prod.NFeRecepcaoEvento4) getSoapService().prodCancel()).getNfeRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.prod.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.prod.NfeResultMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.prod.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.hom.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.hom.NFeRecepcaoEvento4) getSoapService().homCancel()).getNfeRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.hom.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.hom.NfeResultMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.event_cancel.ms.hom.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

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
            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.prod.NFeInutilizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.inutilization.ms.prod.NFeInutilizacao4) getSoapService().prodInutilization()).getNfeInutilizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.prod.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.inutilization.ms.prod.NfeResultMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.prod.NfeResultMsg2 resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NFeInutilizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNfeInutilizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg2 resultMsg = ws.nfeInutilizacaoNF(msg);

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
            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.prod.NFeConsultaProtocoloSoap ws = ((br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.prod.NFeConsultaProtocolo4) getSoapService().prodQueryProtocol()).getNfeConsultaProtocolo4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.prod.NfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.prod.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NFeConsultaProtocoloSoap ws = ((br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNfeConsultaProtocolo4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

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
            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.prod.NFeRetAutorizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.prod.NFeRetAutorizacao4) getSoapService().prodReturnAuthorization()).getNfeRetAutorizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.prod.NfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.prod.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.hom.NFeRetAutorizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.hom.NFeRetAutorizacao4) getSoapService().homReturnAuthorization()).getNfeRetAutorizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.return_authorization.ms.hom.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

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
        JAXBElement<TConsStatServ> envio = NfObjectFactoryWrapperFactory.getInstance().consStatServ(data.data());

        for (Validator<TConsStatServ> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsStatServ> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsStatServ retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfce.wsdl.status_service.ms.prod.NFeStatusServico4 ws = ((br.inf.portalfiscal.nfce.wsdl.status_service.ms.prod.NFeStatusServico4_Service) getSoapService().prodQueryStatusService()).getNfeStatusServico4Soap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.status_service.ms.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.status_service.ms.prod.NfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.status_service.ms.prod.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NFeStatusServico4 ws = ((br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NFeStatusServico4_Service) getSoapService().homQueryStatusService()).getNfeStatusServico4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

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
            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.prod.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.prod.NFeRecepcaoEvento4) getSoapService().prodSubstituteCancel()).getNfeRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.prod.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.prod.NfeResultMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.prod.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.hom.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.hom.NFeRecepcaoEvento4) getSoapService().homSubstituteCancel()).getNfeRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.hom.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.hom.NfeResultMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.event_substitute_cancel.ms.hom.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

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
