package com.softart.dfe.components.sefaz.nfe;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.nf.nfe.NfeService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;

@SuppressWarnings("unchecked")
public abstract class NfeAnService implements NfeService {

    @Override
    public <T extends SefazRequest<TDistDFeInt, TRetDistDFeInt>> Pair<TDistDFeInt, TRetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().distributionNfe(data.getData());
        JAXBElement<TDistDFeInt> envio = NfUnmarshallerFactory.getInstance().distributionNfe(xml);

        for (Validator<TDistDFeInt> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TDistDFeInt> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetDistDFeInt retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NFeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NFeDistribuicaoDFe) getSoapService().prodDistribution()).getNFeDistribuicaoDFeSoap();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresse.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.ObjectFactory().createNfeDistDFeInteresseNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult resultMsg = ws.nfeDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetDistDFeInt>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NFeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NFeDistribuicaoDFe) getSoapService().homDistribution()).getNFeDistribuicaoDFeSoap();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NfeDistDFeInteresse.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.ObjectFactory().createNfeDistDFeInteresseNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult resultMsg = ws.nfeDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetDistDFeInt>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TDistDFeInt, TRetDistDFeInt> it : data.getAfterRequest())
            it.process(new After<>(data.getData(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> manifestation(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().manifestationNfe(data.getData()), data.getConfig());
        JAXBElement<TEnvEvento> envio = NfUnmarshallerFactory.getInstance().manifestationNfe(xml);

        for (Validator<TEnvEvento> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.prod.NFeRecepcaoEvento4) getSoapService().prodManifestation()).getNFeRecepcaoEvento4Soap();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.prod.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.hom.NFeRecepcaoEvento4) getSoapService().homManifestation()).getNFeRecepcaoEvento4Soap();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_manifestation.an.hom.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<TEnvEvento, TRetEnvEvento> it : data.getAfterRequest())
            it.process(new After<>(data.getData(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento, br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento, br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> interestedActor(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().interestedActorNfe(data.getData()), data.getConfig());
        JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().interestedActorNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.prod.NFeRecepcaoEvento4) getSoapService().prodInterestedActor()).getNFeRecepcaoEvento4Soap();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.prod.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.hom.NFeRecepcaoEvento4) getSoapService().homInterestedActor()).getNFeRecepcaoEvento4Soap();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_interested_actor.an.hom.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento, br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> it : data.getAfterRequest())
            it.process(new After<>(data.getData(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_epec.TEnvEvento, br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_epec.TEnvEvento, br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> epec(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.getSigner().signEvent(NfMarshallerFactory.getInstance().epecNfe(data.getData()), data.getConfig());
        JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().epecNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> it : data.getValidators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_epec.an.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_epec.an.prod.NFeRecepcaoEvento4) getSoapService().prodEpec()).getNFeRecepcaoEvento4Soap();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_epec.an.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_epec.an.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_epec.an.prod.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_epec.an.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_epec.an.hom.NFeRecepcaoEvento4) getSoapService().homEpec()).getNFeRecepcaoEvento4Soap();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.nfe.wsdl.event_epec.an.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_epec.an.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_epec.an.hom.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_epec.TEnvEvento, br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> it : data.getAfterRequest())
            it.process(new After<>(data.getData(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }
}
