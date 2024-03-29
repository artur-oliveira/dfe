package org.dfe.components.process.mdfe.reception.impl;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import org.dfe.components.process.mdfe.reception.impl.file.FileSystemStoreReceptionMdfeFactory;
import org.dfe.components.process.mdfe.reception.impl.nostore.NoStoreReceptionMdfeFactory;
import org.dfe.components.process.mdfe.reception.impl.s3.S3StoreReceptionMdfeFactory;
import org.dfe.interfaces.process.ProcessFactory;
import org.dfe.interfaces.process.mdfe.reception.AfterReception;
import org.dfe.interfaces.process.mdfe.reception.BeforeReception;

import java.util.Collection;

public abstract class ReceptionMdfeProcessFactory implements ProcessFactory<TEnviMDFe, TRetEnviMDFe> {

    public static ReceptionMdfeProcessFactory noStore() {
        return Holder.NOSTORE;
    }

    public static ReceptionMdfeProcessFactory fileStore() {
        return Holder.FILESYSTEM;
    }

    public static ReceptionMdfeProcessFactory s3() {
        return HolderS3.INSTANCE;
    }

    public abstract Collection<BeforeReception> before();

    public abstract Collection<AfterReception> after();

    final static class HolderS3 {
        final static ReceptionMdfeProcessFactory INSTANCE = new S3StoreReceptionMdfeFactory();
    }

    final static class Holder {
        final static ReceptionMdfeProcessFactory NOSTORE = new NoStoreReceptionMdfeFactory();
        final static ReceptionMdfeProcessFactory FILESYSTEM = new FileSystemStoreReceptionMdfeFactory();
    }

}
