package com.softart.dfe.components.process.nf.inut.impl;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import com.softart.dfe.components.process.nf.inut.impl.file.FileStoreFactory;
import com.softart.dfe.components.process.nf.inut.impl.nostore.NoStoreFactory;
import com.softart.dfe.interfaces.process.ProcessFactory;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.process.nf.inut.BeforeInut;

import java.util.Collection;

public abstract class InutilizationProcessFactory implements ProcessFactory<TInutNFe, TRetInutNFe> {

    public static InutilizationProcessFactory noStore() {
        return new NoStoreFactory();
    }

    public static InutilizationProcessFactory fileStore() {
        return new FileStoreFactory();
    }

    public abstract Collection<AfterInut> after();

    public abstract Collection<BeforeInut> before();
}
