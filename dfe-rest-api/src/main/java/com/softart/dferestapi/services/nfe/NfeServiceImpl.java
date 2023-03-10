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
import com.softart.dfe.services.nf.authorization.NfeAuthorizationServiceImpl;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public final class NfeServiceImpl implements NfeService {

    @Override
    public ReturnSendNf authorization(SendNf sendNf) throws ProcessException, ValidationException, SoapServiceGeneralException, NoProviderFound, SecurityException {
        return new NfeAuthorizationServiceImpl(getConfig()).authorization(sendNf.getNFe());
    }

    @Override
    @SneakyThrows
    public NfConfig getConfig() {
        return new PfxNfConfigImpl(UF.PI, "11520224000140", Environment.HOMOLOGATION, KeyStoreFactory.getInstance(), NFEmissionType.NORMAL, null, null);
    }
}
