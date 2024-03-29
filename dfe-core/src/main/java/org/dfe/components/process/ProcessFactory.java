package org.dfe.components.process;

import org.dfe.components.process.cte4.Cte4ProcessFactory;
import org.dfe.components.process.mdfe.MdfeProcessFactory;
import org.dfe.components.process.nf.NfProcessFactory;

public abstract class ProcessFactory {

    public static ProcessFactory noStorageProcess() {
        return ProcessFactoryHolder.NO_STORAGE;
    }

    public static ProcessFactory fileStorageProcess() {
        return ProcessFactoryHolder.FILE_STORAGE;
    }

    public static ProcessFactory s3() {
        return S3ProcessFactoryHolder.S3;
    }

    public abstract NfProcessFactory nf();

    public abstract Cte4ProcessFactory cte4();

    public abstract MdfeProcessFactory mdfe();

    private static final class S3ProcessFactoryHolder {
        final static ProcessFactory S3 = new DefaultS3StorageProcessFactory();
    }

    private static final class ProcessFactoryHolder {
        final static ProcessFactory NO_STORAGE = new DefaultNoStorageProcessFactory();
        final static ProcessFactory FILE_STORAGE = new DefaultFileStorageProcessFactory();
    }

}
