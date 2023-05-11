package com.softart.dfe.components.sefaz.nfe;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
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
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.interfaces.sefaz.port.NfeSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;
import lombok.Getter;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Getter
@SuppressWarnings({"unchecked", "unused"})
public final class NfePeService extends NfeAnService {

    private NfeSoapService soapService;

    public Collection<UF> ufs() {
        return Collections.singletonList(UF.PE);
    }

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, NFEmissionType.NORMAL);
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
    public NfeService withSoapService(NfeSoapService nfeSoapService) {
        this.soapService = nfeSoapService;
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
            br.inf.portalfiscal.nfe.wsdl.authorization.pe.prod.NFeAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.pe.prod.NFeAutorizacao4) getSoapService().prodAuthorization()).getNFeAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.pe.prod.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.pe.prod.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

            retorno = ((JAXBElement<TRetEnviNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.authorization.pe.hom.NFeAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.authorization.pe.hom.NFeAutorizacao4) getSoapService().homAuthorization()).getNFeAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.authorization.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.authorization.pe.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.authorization.pe.hom.NfeResultMsg resultMsg = ws.nfeAutorizacaoLote(msg);

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
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.prod.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.prod.NFeRecepcaoEvento4) getSoapService().prodCancel()).getNFeRecepcaoEvento4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.hom.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.hom.NFeRecepcaoEvento4) getSoapService().homCancel()).getNFeRecepcaoEvento4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_cancel.pe.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

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
            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.prod.NFeInutilizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.pe.prod.NFeInutilizacao4) getSoapService().prodInutilization()).getNFeInutilizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.prod.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.hom.NFeInutilizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.inutilization.pe.hom.NFeInutilizacao4) getSoapService().homInutilization()).getNFeInutilizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.inutilization.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.inutilization.pe.hom.NfeResultMsg resultMsg = ws.nfeInutilizacaoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetInutNFe>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TInutNFe, TRetInutNFe> it : data.getAfterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.prod.NFeRetAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.prod.NFeRetAutorizacao4) getSoapService().prodReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.prod.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.hom.NFeRetAutorizacao4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.hom.NFeRetAutorizacao4) getSoapService().homReturnAuthorization()).getNFeRetAutorizacao4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.return_authorization.pe.hom.NfeResultMsg resultMsg = ws.nfeRetAutorizacaoLote(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsReciNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsReciNFe, TRetConsReciNFe> it : data.getAfterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.NFeConsultaProtocolo4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.NFeConsultaProtocolo4) getSoapService().prodQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.prod.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.hom.NFeConsultaProtocolo4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.hom.NFeConsultaProtocolo4) getSoapService().homQueryProtocol()).getNFeConsultaProtocolo4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_protocol.pe.hom.NfeResultMsg resultMsg = ws.nfeConsultaNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsSitNFe>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsSitNFe, TRetConsSitNFe> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));
        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> correctionLetter(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().correctionLetterNfe(data.getData()), data.getConfig());
        JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().correctionLetterNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.prod.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.prod.NFeRecepcaoEvento4) getSoapService().prodCorrectionLetter()).getNFeRecepcaoEvento4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.prod.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.hom.NFeRecepcaoEvento4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.hom.NFeRecepcaoEvento4) getSoapService().homCorrectionLetter()).getNFeRecepcaoEvento4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.event_correction_letter.pe.hom.NfeResultMsg resultMsg = ws.nfeRecepcaoEvento(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento, br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> it : data.getAfterRequest())
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
            br.inf.portalfiscal.nfe.wsdl.status_service.pe.prod.NFeStatusServico4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.pe.prod.NFeStatusServico4) getSoapService().prodQueryStatusService()).getNFeStatusServico4ServicePort();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.pe.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.status_service.pe.prod.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.status_service.pe.hom.NFeStatusServico4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.status_service.pe.hom.NFeStatusServico4) getSoapService().homQueryStatusService()).getNFeStatusServico4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.status_service.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.status_service.pe.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.status_service.pe.hom.NfeResultMsg resultMsg = ws.nfeStatusServicoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetConsStatServ>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TConsStatServ, TRetConsStatServ> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TConsGTIN, TRetConsGTIN>> Pair<TConsGTIN, TRetConsGTIN> queryGtin(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryGtinNf(data.getData());
        JAXBElement<TConsGTIN> envio = new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createConsGTIN(data.getData());

        for (Validator<TConsGTIN> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsGTIN> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsGTIN retorno = null;

        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTINSoap ws = ((br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTIN_Service) getSoapService().queryGtin()).getCcgConsGTINSoap();

        data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTIN.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.ObjectFactory().createCcgConsGTINNfeDadosMsg();
        msg.getContent().add(envio);
        br.inf.portalfiscal.nfe.wsdl.query_gtin.svrs.prod.CcgConsGTINResponse.NfeResultMsg resultMsg = ws.ccgConsGTIN(msg);

        if (!resultMsg.getContent().isEmpty())
            retorno = ((JAXBElement<TRetConsGTIN>) resultMsg.getContent().get(0)).getValue();

        for (AfterWebServiceRequest<TConsGTIN, TRetConsGTIN> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }


    @Override
    public <T extends SefazRequest<TConsCad, TRetConsCad>> Pair<TConsCad, TRetConsCad> queryRegister(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().queryRegister(data.getData());
        JAXBElement<TConsCad> envio = NfUnmarshallerFactory.getInstance().queryRegister(xml);

        for (Validator<TConsCad> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TConsCad> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetConsCad retorno;
        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.query_register.pe.prod.CadConsultaCadastro4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_register.pe.prod.CadConsultaCadastro4) getSoapService().prodQueryRegister()).getCadConsultaCadastro4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_register.pe.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_register.pe.prod.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_register.pe.prod.NfeResultMsg resultMsg = ws.consultaCadastro(msg);

            retorno = ((JAXBElement<TRetConsCad>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.query_register.pe.hom.CadConsultaCadastro4Soap12 ws = ((br.inf.portalfiscal.nfe.wsdl.query_register.pe.hom.CadConsultaCadastro4) getSoapService().homQueryRegister()).getCadConsultaCadastro4ServicePort();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.query_register.pe.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.query_register.pe.hom.NfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.query_register.pe.hom.NfeResultMsg resultMsg = ws.consultaCadastro(msg);

            retorno = ((JAXBElement<TRetConsCad>) resultMsg.getContent().get(0)).getValue();
        }
        for (AfterWebServiceRequest<TConsCad, TRetConsCad> it : data.getAfterRequest())
            it.process(new After<>(envio.getValue(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

}
