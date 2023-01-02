package com.softart.dfe.components.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
import com.softart.dfe.components.process.mdfe.MdfeProcessFactory;
import com.softart.dfe.components.process.nf.NfProcessFactory;

public abstract class ProcessFactory {

    public static ProcessFactory noStorageProcess() {
        return ProcessFactoryHolder.NO_STORAGE;
    }

    public static ProcessFactory fileStorageProcess() {
        return ProcessFactoryHolder.FILE_STORAGE;
    }

    public abstract NfProcessFactory nf();

    public abstract CteProcessFactory cte();

    public abstract MdfeProcessFactory mdfe();

    private static final class ProcessFactoryHolder {
        final static ProcessFactory NO_STORAGE = new DefaultNoStorageProcessFactory();
        final static ProcessFactory FILE_STORAGE = new DefaultFileStorageProcessFactory();
    }

}
