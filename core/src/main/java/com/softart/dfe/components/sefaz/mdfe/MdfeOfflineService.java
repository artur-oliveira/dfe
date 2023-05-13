package com.softart.dfe.components.sefaz.mdfe;

import br.inf.portalfiscal.mdfe.classes.*;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import com.softart.dfe.components.internal.PairImpl;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.mdfe.identification.MdfeEmissionType;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.process.AfterWebServiceRequest;
import com.softart.dfe.interfaces.process.BeforeWebServiceRequest;
import com.softart.dfe.interfaces.sefaz.SefazRequest;
import com.softart.dfe.interfaces.sefaz.mdfe.MdfeService;
import com.softart.dfe.interfaces.sefaz.port.MdfeSoapService;
import com.softart.dfe.interfaces.validation.Validator;
import com.softart.dfe.models.internal.After;
import com.softart.dfe.models.internal.Before;
import com.softart.dfe.models.internal.Validation;
import lombok.Getter;

import jakarta.xml.bind.JAXBElement;
import java.util.Collection;
import java.util.Objects;

@Getter
public final class MdfeOfflineService implements MdfeService {

    private MdfeSoapService soapService;

    public Collection<UF> ufs() {
        return UF.states();
    }

    @Override
    public Collection<UF> allowedUfsHomologation() {
        return ufs();
    }

    @Override
    public Collection<UF> allowedUfsProduction() {
        return ufs();
    }

    public boolean allow(UF uf, Environment environment, MdfeEmissionType emissionType) {
        return allow(uf, environment) && Objects.equals(emissionType, MdfeEmissionType.CONTINGENCY);
    }

    @Override
    public MdfeService withSoapService(MdfeSoapService nfeSoapService) {
        this.soapService = nfeSoapService;
        return this;
    }

    @Override
    public <T extends SefazRequest<TDistDFe, TRetDistDFe>> Pair<TDistDFe, TRetDistDFe> distribution(T data) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public <T extends SefazRequest<DistDFeInt, RetDistDFeInt>> Pair<DistDFeInt, RetDistDFeInt> distributionOld(T data) throws SecurityException, ValidationException, ProcessException {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public <T extends SefazRequest<TEvento, TRetEvento>> Pair<TEvento, TRetEvento> event(T data) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public <T extends SefazRequest<TConsReciMDFe, TRetConsReciMDFe>> Pair<TConsReciMDFe, TRetConsReciMDFe> queryReceipt(T data) {
        throw new UnsupportedOperationException("not implemented");

    }

    @Override
    public <T extends SefazRequest<TConsSitMDFe, TRetConsSitMDFe>> Pair<TConsSitMDFe, TRetConsSitMDFe> querySituation(T data) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public <T extends SefazRequest<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc>> Pair<TConsMDFeNaoEnc, TRetConsMDFeNaoEnc> queryUnclosed(T data) {
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public <T extends SefazRequest<TEnviMDFe, TRetEnviMDFe>> Pair<TEnviMDFe, TRetEnviMDFe> reception(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signMdfe(MdfeMarshallerFactory.getInstance().sendReception(data.data()), data.config());
        JAXBElement<TEnviMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendReception(xml);
        for (Validator<TEnviMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TEnviMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        for (AfterWebServiceRequest<TEnviMDFe, TRetEnviMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), new TRetEnviMDFe(), data.config()));
        }

        return new PairImpl<>(envio.getValue(), new TRetEnviMDFe());
    }

    @Override
    public <T extends SefazRequest<TMDFe, TRetMDFe>> Pair<TMDFe, TRetMDFe> receptionSync(T data) throws SecurityException, ValidationException, ProcessException {
        String xml = data.signer().signMdfe(MdfeMarshallerFactory.getInstance().sendReceptionSync(data.data()), data.config());
        JAXBElement<TMDFe> envio = MdfeUnmarshallerFactory.getInstance().sendReceptionSync(xml);
        for (Validator<TMDFe> validator : data.validators()) {
            validator.valid(new Validation<>(envio.getValue(), xml));
        }

        for (BeforeWebServiceRequest<TMDFe> before : data.beforeRequest()) {
            before.process(new Before<>(envio.getValue(), data.config()));
        }

        for (AfterWebServiceRequest<TMDFe, TRetMDFe> after : data.afterRequest()) {
            after.process(new After<>(envio.getValue(), new TRetMDFe(), data.config()));
        }

        return new PairImpl<>(envio.getValue(), new TRetMDFe());
    }

    @Override
    public <T extends SefazRequest<TConsStatServ, TRetConsStatServ>> Pair<TConsStatServ, TRetConsStatServ> statusService(T data) {
        throw new UnsupportedOperationException("not implemented");
    }
}
