package com.softart.dfe.components.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
import com.softart.dfe.components.process.cte4.Cte4ProcessFactory;
import com.softart.dfe.components.process.mdfe.MdfeProcessFactory;
import com.softart.dfe.components.process.nf.NfProcessFactory;

final class DefaultFileStorageProcessFactory extends ProcessFactory {
    @Override
    public NfProcessFactory nf() {
        return NfProcessFactory.fileStorageProcess();
    }

    @Override
    public CteProcessFactory cte() {
        return CteProcessFactory.fileStorageProcess();
    }

    @Override
    public MdfeProcessFactory mdfe() {
        return MdfeProcessFactory.fileStorageProcess();
    }

    @Override
    public Cte4ProcessFactory cte4() {
        return Cte4ProcessFactory.fileStorageProcess();
    }
}
