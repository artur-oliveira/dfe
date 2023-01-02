package com.softart.dfe.components.process.nf.epec.impl;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.components.process.nf.epec.impl.file.FileStoreEpecFactory;
import com.softart.dfe.components.process.nf.epec.impl.nostore.NoStoreEpecFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;

import java.util.Collection;

public abstract class EpecProcessFactory implements ProcessFactory<TEnvEvento, TRetEnvEvento> {

    public static EpecProcessFactory noStore() {
        return new NoStoreEpecFactory();
    }

    public static EpecProcessFactory fileStore() {
        return new FileStoreEpecFactory();
    }

    public abstract Collection<AfterEpec> after();

    public abstract Collection<BeforeEpec> before();

}
