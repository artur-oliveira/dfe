package com.softart.dfe.components.sefaz.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.cte.CteService;
import com.softart.dfe.interfaces.sefaz.port.CteSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import com.softart.dfe.models.internal.wsdl.ProviderConfig;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;

public abstract class CteAnService implements CteService {

    private CteSoapService soapService;

    @Override
    public CteService withSoapService(CteSoapService soapService) {
        this.soapService = soapService;
        return this;
    }

    @Override
    public CteSoapService getSoapService() {
        return soapService;
    }

    @Override
    public <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().distributionCte(data.getData());
        JAXBElement<DistDFeInt> envio = CteUnmarshallerFactory.getInstance().distributionCte(xml);

        for (Validator<DistDFeInt> it : data.getValidators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<DistDFeInt> it : data.getBeforeRequest())
            it.process(new Before<>(envio.getValue(), data.getConfig()));

        RetDistDFeInt retorno = null;

        if (data.getConfig().production()) {
            br.inf.portalfiscal.cte.wsdl.distribution.an.prod.CTeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.cte.wsdl.distribution.an.prod.CTeDistribuicaoDFe) getSoapService().prodDistribution()).getCTeDistribuicaoDFeSoap();

            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.distribution.an.prod.CteDistDFeInteresse.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.distribution.an.prod.ObjectFactory().createCteDistDFeInteresseCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte.wsdl.distribution.an.prod.CteDistDFeInteresseResponse.CteDistDFeInteresseResult resultMsg = ws.cteDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (RetDistDFeInt) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CTeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CTeDistribuicaoDFe) getSoapService().homDistribution()).getCTeDistribuicaoDFeSoap();
            data.getConfigureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.getConfig()).build());

            br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CteDistDFeInteresse.CteDadosMsg msg = new br.inf.portalfiscal.cte.wsdl.distribution.an.hom.ObjectFactory().createCteDistDFeInteresseCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte.wsdl.distribution.an.hom.CteDistDFeInteresseResponse.CteDistDFeInteresseResult resultMsg = ws.cteDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (RetDistDFeInt) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<DistDFeInt, RetDistDFeInt> it : data.getAfterRequest())
            it.process(new After<>(data.getData(), retorno, data.getConfig()));

        return new PairImpl<>(envio.getValue(), retorno);
    }
}
