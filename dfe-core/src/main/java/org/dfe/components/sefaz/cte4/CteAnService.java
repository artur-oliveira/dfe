package org.dfe.components.sefaz.cte4;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import org.dfe.components.internal.PairImpl;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.exceptions.ValidationException;
import org.dfe.exceptions.security.SecurityException;
import org.dfe.interfaces.internal.Pair;
import org.dfe.interfaces.process.AfterWebServiceRequest;
import org.dfe.interfaces.process.BeforeWebServiceRequest;
import org.dfe.interfaces.sefaz.SefazRequest;
import org.dfe.interfaces.sefaz.cte4.Cte4Service;
import org.dfe.interfaces.sefaz.port.Cte4SoapService;
import org.dfe.interfaces.validation.Validator;
import org.dfe.models.internal.After;
import org.dfe.models.internal.Before;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.wsdl.ProviderConfig;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;

public abstract class CteAnService implements Cte4Service {

    private Cte4SoapService soapService;

    @Override
    public Cte4Service withSoapService(Cte4SoapService soapService) {
        this.soapService = soapService;
        return this;
    }

    @Override
    public Cte4SoapService getSoapService() {
        return soapService;
    }

    @Override
    public <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distribution(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = CteMarshallerFactory.getInstance().distributionCte(data.data());
        JAXBElement<DistDFeInt> envio = CteUnmarshallerFactory.getInstance().distributionCte(xml);

        for (Validator<DistDFeInt> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));
        for (BeforeWebServiceRequest<DistDFeInt> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        RetDistDFeInt retorno = null;

        if (data.config().production()) {
            br.inf.portalfiscal.cte4.wsdl.distribution.an.prod.CTeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.cte4.wsdl.distribution.an.prod.CTeDistribuicaoDFe) getSoapService().prodDistribution()).getCTeDistribuicaoDFeSoap();

            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.distribution.an.prod.CteDistDFeInteresse.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.distribution.an.prod.ObjectFactory().createCteDistDFeInteresseCteDadosMsg();
            msg.getContent().add(envio);
            br.inf.portalfiscal.cte4.wsdl.distribution.an.prod.CteDistDFeInteresseResponse.CteDistDFeInteresseResult resultMsg = ws.cteDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (RetDistDFeInt) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        } else {
            br.inf.portalfiscal.cte4.wsdl.distribution.an.hom.CTeDistribuicaoDFeSoap ws = ((br.inf.portalfiscal.cte4.wsdl.distribution.an.hom.CTeDistribuicaoDFe) getSoapService().homDistribution()).getCTeDistribuicaoDFeSoap();
            data.configureProvider().configure(ProviderConfig.builder().port((BindingProvider) ws).config(data.config()).build());

            br.inf.portalfiscal.cte4.wsdl.distribution.an.hom.CteDistDFeInteresse.CteDadosMsg msg = new br.inf.portalfiscal.cte4.wsdl.distribution.an.hom.ObjectFactory().createCteDistDFeInteresseCteDadosMsg();
            msg.getContent().add(envio);

            br.inf.portalfiscal.cte4.wsdl.distribution.an.hom.CteDistDFeInteresseResponse.CteDistDFeInteresseResult resultMsg = ws.cteDistDFeInteresse(msg);

            if (!resultMsg.getContent().isEmpty())
                retorno = (RetDistDFeInt) ((JAXBElement<?>) resultMsg.getContent().get(0)).getValue();
        }

        for (AfterWebServiceRequest<DistDFeInt, RetDistDFeInt> it : data.afterRequest())
            it.process(new After<>(data.data(), retorno, data.config()));

        return new PairImpl<>(envio.getValue(), retorno);
    }
}
