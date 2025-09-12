package org.dfe.components.sefaz.nfe;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import org.dfe.components.internal.PairImpl;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.NfUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.process.AfterWebServiceRequest;
import org.dfe.interfaces.process.BeforeWebServiceRequest;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.sefaz.nf.nfe.NfeService;
import org.dfe.interfaces.validation.Validator;
import org.dfe.models.internal.After;
import org.dfe.models.internal.Before;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.wsdl.ProviderConfig;

@SuppressWarnings("unchecked")
public abstract class NfeAnService implements NfeService {

    @Override
    public <T extends SefazRequest<TDistDFeInt, TRetDistDFeInt>> Pair<TDistDFeInt, TRetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = NfMarshallerFactory.getInstance().distributionNfe(data.data());
        JAXBElement<TDistDFeInt> envio = NfUnmarshallerFactory.getInstance().distributionNfe(xml);

        for (Validator<TDistDFeInt> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<TDistDFeInt> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        TRetDistDFeInt retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NFeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NFeDistribuicaoDFe) getSoapService().prodDistribution()).getNFeDistribuicaoDFeSoap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresse.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.ObjectFactory().createNfeDistDFeInteresseNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.distribution.an.prod.NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult resultMsg = ws.nfeDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetDistDFeInt>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NFeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NFeDistribuicaoDFe) getSoapService().homDistribution()).getNFeDistribuicaoDFeSoap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NfeDistDFeInteresse.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.ObjectFactory().createNfeDistDFeInteresseNfeDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.nfe.wsdl.distribution.an.hom.NfeDistDFeInteresseResponse.NfeDistDFeInteresseResult resultMsg = ws.nfeDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<TRetDistDFeInt>) resultMsg.getContent().getFirst()).getValue();
        }

        for (AfterWebServiceRequest<TDistDFeInt, TRetDistDFeInt> it : data.afterRequest())
            it.process(new After<>(data.data(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> eventAN(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signEvent(NfMarshallerFactory.getInstance().eventNfe(data.data()), data.config());
        JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> envio = NfUnmarshallerFactory.getInstance().eventNfe(xml);

        for (Validator<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> it : data.validators())
            it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.nfe.wsdl.event_generic.an.prod.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_generic.an.prod.NFeRecepcaoEvento4) getSoapService().prodEvent()).getNFeRecepcaoEvento4Soap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_generic.an.prod.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_generic.an.prod.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_generic.an.prod.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>) resultMsg.getContent().getFirst()).getValue();
        } else {
            br.inf.portalfiscal.nfe.wsdl.event_generic.an.hom.NFeRecepcaoEvento4Soap ws = ((br.inf.portalfiscal.nfe.wsdl.event_generic.an.hom.NFeRecepcaoEvento4) getSoapService().homEvent()).getNFeRecepcaoEvento4Soap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.nfe.wsdl.event_generic.an.hom.NfeDadosMsg msg = new br.inf.portalfiscal.nfe.wsdl.event_generic.an.hom.ObjectFactory().createNfeDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.nfe.wsdl.event_generic.an.hom.NfeRecepcaoEventoNFResult resultMsg = ws.nfeRecepcaoEventoNF(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = ((JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento>) resultMsg.getContent().getFirst()).getValue();
        }

        for (AfterWebServiceRequest<br.inf.portalfiscal.nfe.event_generic.TEnvEvento, br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> it : data.afterRequest())
            it.process(new After<>(data.data(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }
}
