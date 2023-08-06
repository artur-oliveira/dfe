package com.softart.dfe.components.sefaz.nfe;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.objectfactory.NfObjectFactoryWrapperFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.DfeUncheckedException;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import com.softart.dfe.util.GZIPUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Getter
@SuppressWarnings({"unchecked", "unused"})
public final class NfeGoService extends NfeAnService {

    private NfeSoapService soapService;

    public Collection<UF> ufs() {
        return Collections.singletonList(UF.GO);
    }

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && List.of(NFEmissionType.NORMAL, NFEmissionType.EPEC).contains(emissionType);
    }

    @Override
    public NfeService withSoapService(NfeSoapService nfeSoapService) {
        this.soapService = nfeSoapService;
        return this;
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
    public <T extends SefazRequest<TEnviNFe, TRetEnviNFe>> Pair<TEnviNFe, TRetEnviNFe> authorize(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signNfe(NfMarshallerFactory.getInstance().sendNfe(data.data()), data.config());
        JAXBElement<TEnviNFe> envio = NfUnmarshallerFactory.getInstance().enviNfe(xml);

        for (Validator<TEnviNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnviNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetEnviNFe retorno;
        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NFeAutorizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NFeAutorizacao4) getSoapService().prodAuthorization()).getNFeAutorizacao4Port();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            String gzip;
            try {
                gzip = GZIPUtils.compressToString(xml);
            } catch (Exception e) {
                throw new DfeUncheckedException(e);
            }
            br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeDadosMsgZip msg = new br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeDadosMsgZip();
            msg.getContent().add(gzip);

            br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeResultMsg resultMsg = ws.nfeAutorizacaoLoteZIP(msg);
//            br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeDadosMsg();
//            msg.getContent().add(envio);
//
//            br.inf.portalfiscal.nfe.wsdl.authorization.go.prod.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NFeAutorizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NFeAutorizacao4) getSoapService().homAuthorization()).getNFeAutorizacao4Port();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());
            String gzip;
            try {
                gzip = GZIPUtils.compressToString(xml);
            } catch (Exception e) {
                throw new DfeUncheckedException(e);
            }
            br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeDadosMsgZip msg = new br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeDadosMsgZip();
            msg.getContent().add(gzip);

            br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeResultMsg resultMsg = ws.nfeAutorizacaoLoteZIP(msg);
//            br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeDadosMsg();
//            msg.getContent().add(envio);
//
//            br.inf.portalfiscal.nfe.wsdl.authorization.go.hom.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

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
            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.prod.NFeRecepcaoEvento4Service ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.go.prod.NFeRecepcaoEvento4) getSoapService().prodCancel()).getNFeRecepcaoEvento4ServicePort();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.hom.NFeRecepcaoEvento4Service ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.go.hom.NFeRecepcaoEvento4) getSoapService().homCancel()).getNFeRecepcaoEvento4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_cancel.go.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

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
            br.inf.portalfiscal.nfe.wsdl.inutilization.go.prod.NFeInutilizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.go.prod.NFeInutilizacao4) getSoapService().prodInutilization()).getNFeInutilizacao4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.inutilization.go.prod.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.inutilization.go.hom.NFeInutilizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.go.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNFeInutilizacao4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.inutilization.go.hom.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TInutNFe, TRetInutNFe> it : data.afterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.prod.NFeRetAutorizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.go.prod.NFeRetAutorizacao4) getSoapService().prodReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.prod.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.hom.NFeRetAutorizacao4Service ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.go.hom.NFeRetAutorizacao4) getSoapService().homReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.return_authorization.go.hom.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciNFe, TRetConsReciNFe> it : data.afterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.prod.NFeConsultaProtocolo4Service ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.go.prod.NFeConsultaProtocolo4) getSoapService().prodQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.prod.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.hom.NFeConsultaProtocolo4Service ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.go.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_protocol.go.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitNFe, TRetConsSitNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> correctionLetter(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(NfMarshallerFactory.getInstance().correctionLetterNfe(data.data()), data.config());
        JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().correctionLetterNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.prod.NFeRecepcaoEvento4Service ws = ((br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.prod.NFeRecepcaoEvento4) getSoapService().prodCorrectionLetter()).getNFeRecepcaoEvento4ServicePort();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.hom.NFeRecepcaoEvento4Service ws = ((br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.hom.NFeRecepcaoEvento4) getSoapService().homCorrectionLetter()).getNFeRecepcaoEvento4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.go.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> it : data.afterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.status_service.go.prod.NFeStatusServico4Service ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.go.prod.NFeStatusServico4) getSoapService().prodQueryStatusService()).getNFeStatusServico4ServicePort();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.go.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.status_service.go.prod.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.status_service.go.hom.NFeStatusServico4Service ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.go.hom.NFeStatusServico4) getSoapService().homQueryStatusService()).getNFeStatusServico4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.go.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.status_service.go.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsGTIN, TRetConsGTIN>> Pair<TConsGTIN, TRetConsGTIN> queryGtin(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryGtinNf(data.data());
        JAXBElement<TConsGTIN> envio = new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createConsGTIN(data.data());

        for (Validator<TConsGTIN> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsGTIN> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsGTIN retorno = null;

        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTINSoap ws = ((br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTIN_Service) getSoapService().queryGtin()).getCcgConsGTINSoap();

        data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTIN.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.ObjectFactory().createCcgConsGTINNfeDadosMsg();
        msg.getContent().add(envio);
        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTINResponse.NfeResultMsg resultMsg = ws.ccgConsGTIN(msg);

        if (!resultMsg.getContent().isEmpty())
            retorno = ((JAXBElement<TRetConsGTIN>) resultMsg.getContent().get(0)).getValue();

        for (AfterWebServiceRequest<TConsGTIN, TRetConsGTIN> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TConsCad, TRetConsCad>> Pair<TConsCad, TRetConsCad> queryRegister(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryRegister(data.data());
        JAXBElement<TConsCad> envio = NfUnmarshallerFactory.getInstance().queryRegister(xml);

        for (Validator<TConsCad> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsCad> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetConsCad retorno;
        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.query_register.go.prod.CadConsultaCadastro4Service ws = ((br.inf.portalfiscal.nfe.wsdl.query_register.go.prod.CadConsultaCadastro4) getSoapService().prodQueryRegister()).getCadConsultaCadastro4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_register.go.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_register.go.prod.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_register.go.prod.NfeResultMsg resultMsg = ws.consultaCadastro(msg);

            retorno = ((JAXBElement<TRetConsCad>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_register.go.hom.CadConsultaCadastro4Service ws = ((br.inf.portalfiscal.nfe.wsdl.query_register.go.hom.CadConsultaCadastro4) getSoapService().homQueryRegister()).getCadConsultaCadastro4ServicePort();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.query_register.go.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_register.go.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_register.go.hom.NfeResultMsg resultMsg = ws.consultaCadastro(msg);

            retorno = ((JAXBElement<TRetConsCad>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TConsCad, TRetConsCad> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }
}
