package com.softart.dferestapi.services.nfe;

import com.softart.dfe.components.internal.certificate.KeyStoreFactory;
import com.softart.dfe.components.internal.config.PfxNfConfigImpl;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.enums.nf.identification.NFEmissionType;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.port.SoapServiceGeneralException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.exceptions.services.NoProviderFound;
import com.softart.dfe.interfaces.internal.config.NfConfig;
import com.softart.dfe.models.nf.authorization.ReturnSendNf;
import com.softart.dfe.models.nf.authorization.SendNf;
import com.softart.dfe.models.nf.cancel.NfeCancel;
import com.softart.dfe.models.nf.cancel.ReturnNfeCancel;
import com.softart.dfe.models.nf.cancel.SendNfeCancel;
import com.softart.dfe.services.nf.authorization.NfeAuthorizationServiceImpl;
import com.softart.dfe.services.nf.cancel.NfeCancelServiceImpl;
import com.softart.dferestapi.models.nfe.CancelMultipleNfe;
import com.softart.dferestapi.models.nfe.CancelNfe;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public final class NfeServiceImpl implements NfeService {

    @Override
    public ReturnSendNf authorization(SendNf sendNf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfeAuthorizationServiceImpl(getConfig()).authorization(sendNf.getNFe());
    }

    @Override
    public ReturnNfeCancel cancel(CancelNfe withAccessKey) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfeCancelServiceImpl(getConfig()).cancelWithMotive(withAccessKey.getChNFe(), withAccessKey.getXJust());
    }

    @Override
    public ReturnNfeCancel cancel(CancelMultipleNfe cancelMultipleNfe) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfeCancelServiceImpl(getConfig()).cancel(SendNfeCancel.build(cancelMultipleNfe
                .getData()
                .stream()
                .map(it -> NfeCancel.builder().infEvento(NfeCancel
                        .InfEvento
                        .builder()
                        .chNFe(it.getChNFe())
                        .nSeqEvento("1")
                        .cnpj(getConfig().cnpj())
                        .cpf(getConfig().cpf())
                        .cOrgao(getConfig().uf().getCode())
                        .tpAmb(getConfig().environment().getCode())
                        .detEvento(NfeCancel.InfEvento
                                .DetEvento
                                .builder()
                                .nProt(it.getNProt())
                                .xJust(it.getXJust())
                                .build())
                        .build()).build())
                .collect(Collectors.toList())));
    }

    @Override
    @SneakyThrows
    public NfConfig getConfig() {
        return new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance(), NFEmissionType.NORMAL, null, null);
    }
}
