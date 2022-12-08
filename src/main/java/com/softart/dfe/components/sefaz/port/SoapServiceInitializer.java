package com.softart.dfe.components.sefaz.port;

import com.softart.dfe.components.sefaz.port.cte.AbstractCteSoapService;
import com.softart.dfe.components.sefaz.port.cte.initializer.ConfigCteSoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.cte.initializer.ProxyCteSoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.nfce.AbstractNfceSoapService;
import com.softart.dfe.components.sefaz.port.nfce.initializer.ConfigNfceSoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.nfce.initializer.ProxyNfceSoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.nfe.AbstractNfeSoapService;
import com.softart.dfe.components.sefaz.port.nfe.initializer.ConfigNfeSoapServiceInitializer;
import com.softart.dfe.components.sefaz.port.nfe.initializer.ProxyNfeSoapServiceInitializer;
import com.softart.dfe.exceptions.port.SoapServiceInitializationException;
import com.softart.dfe.interfaces.sefaz.port.SoapService;
import lombok.Data;

import java.util.Objects;

@Data
public abstract class SoapServiceInitializer<T extends SoapService> {
    protected SoapServiceInitializer<T> next;

    public static SoapServiceInitializer<AbstractNfeSoapService> nfe() {
        return SoapServiceInitializer.link(new ProxyNfeSoapServiceInitializer(), new ConfigNfeSoapServiceInitializer());
    }

    public static SoapServiceInitializer<AbstractNfceSoapService> nfce() {
        return SoapServiceInitializer.link(new ProxyNfceSoapServiceInitializer(), new ConfigNfceSoapServiceInitializer());
    }


    public static SoapServiceInitializer<AbstractCteSoapService> cte() {
        return SoapServiceInitializer.link(new ProxyCteSoapServiceInitializer(), new ConfigCteSoapServiceInitializer());
    }

    @SafeVarargs
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T extends SoapServiceInitializer> T link(T first, T... chain) {
        SoapServiceInitializer<SoapService> head = first;
        for (SoapServiceInitializer<SoapService> nextInChain : chain) {
            head.setNext(nextInChain);
            head = nextInChain;
        }
        return first;
    }

    public abstract void initialize(T soapService) throws SoapServiceInitializationException;

    protected void initializeNext(T soapService) throws SoapServiceInitializationException {
        if (soapService.isInitialized()) return;
        if (Objects.isNull(getNext()) && !soapService.isInitialized()) throw new SoapServiceInitializationException();
        getNext().initialize(soapService);
    }
}
