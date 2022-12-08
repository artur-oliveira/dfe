package com.softart.dfe.components.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
import com.softart.dfe.components.process.nf.NfProcessFactory;

public abstract class ProcessFactory {

    public static ProcessFactory noStorageProcess() {
        return new DefaultNoStorageProcessFactory();
    }

    public static ProcessFactory fileStorageProcess() {
        return new DefaultFileStorageProcessFactory();
    }

    public abstract NfProcessFactory nf();

    public abstract CteProcessFactory cte();

}
