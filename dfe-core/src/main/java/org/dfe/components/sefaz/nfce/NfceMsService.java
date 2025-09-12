package org.dfe.components.sefaz.nfce;

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

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().getFirst()).getValue();
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

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().getFirst()).getValue();
        }
        for (AfterWebServiceRequest<TEnviNFe, TRetEnviNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> event(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(NfMarshallerFactory.getInstance().eventNfe(data.data()), data.config());
        JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().eventNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.prod.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_generic.ms.prod.NFeRecepcaoEvento4) getSoapService().prodEvent()).getNfeRecepcaoEventoSoap12();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.prod.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_generic.ms.prod.NfeResultMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.prod.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.hom.NFeRecepcaoEventoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.event_generic.ms.hom.NFeRecepcaoEvento4) getSoapService().homEvent()).getNfeRecepcaoEventoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.hom.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.event_generic.ms.hom.NfeResultMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.event_generic.ms.hom.NfeResultMsg2 resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>) resultMsg.getContent().getFirst()).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> it : data.afterRequest())
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
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NFeInutilizacaoSoap ws = ((br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNfeInutilizacaoSoap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg msg = new br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.inutilization.ms.hom.NfeResultMsg2 resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().getFirst()).getValue();
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
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NFeConsultaProtocoloSoap ws = ((br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNfeConsultaProtocolo4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.query_protocol.ms.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().getFirst()).getValue();
        }

        for (AfterWebServiceRequest<TConsSitNFe, TRetConsSitNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) throws SecurityException, ValidationException, ProcessException {
        throw new DfeUncheckedException("not implemented for UF");
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
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NFeStatusServico4 ws = ((br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NFeStatusServico4_Service) getSoapService().homQueryStatusService()).getNfeStatusServico4Soap12();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfce.wsdl.status_service.ms.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().getFirst()).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(NFEmissionType.NORMAL, emissionType);
    }
}
