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
import jakarta.xml.bind.JAXBElement;

import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("unused")
public final class NfceOfflineService implements NfceService {
    @Override
    public Collection<UF> allowedUfsProduction() {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public boolean allow(UF uf, Environment environment, NFEmissionType emissionType) {
        return Objects.equals(emissionType, NFEmissionType.OFFLINE);
    }

    @Override
    public <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> substituteCancel(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public NfceSoapService getSoapService() {
        return null;
    }

    @Override
    public NfceService withSoapService(NfceSoapService soapService) {
        return this;
    }

    @Override
    public <T extends SefazRequest<TEnviNFe, TRetEnviNFe>> Pair<TEnviNFe, TRetEnviNFe> authorize(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signNfe(NfMarshallerFactory.getInstance().sendNfe(data.data()), data.config());
        JAXBElement<TEnviNFe> envio = NfUnmarshallerFactory.getInstance().enviNfe(xml);

        for (Validator<TEnviNFe> it : data.validators()) it.valid(new Validation<>(envio.getValue(), xml));

        for (BeforeWebServiceRequest<TEnviNFe> it : data.beforeRequest())
            it.process(new Before<>(envio.getValue(), data.config()));

        for (AfterWebServiceRequest<TEnviNFe, TRetEnviNFe> it : data.afterRequest())
            it.process(new After<>(envio.getValue(), null, data.config()));

        return new PairImpl<>(envio.getValue(), new TRetEnviNFe());
    }

    @Override
    public <T extends SefazRequest<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento>> Pair<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento, br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> cancel(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public <T extends SefazRequest<TInutNFe, TRetInutNFe>> Pair<TInutNFe, TRetInutNFe> inutilization(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public <T extends SefazRequest<TConsSitNFe, TRetConsSitNFe>> Pair<TConsSitNFe, TRetConsSitNFe> queryProtocol(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> queryStatusService(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }

    @Override
    public <T extends SefazRequest<TConsReciNFe, TRetConsReciNFe>> Pair<TConsReciNFe, TRetConsReciNFe> queryReceipt(T data) {
        throw new UnsupportedOperationException("cannot perform this action");
    }
}
