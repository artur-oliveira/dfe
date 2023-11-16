package org.dfe.components.process;

import org.dfe.components.process.cte.CteProcessFactory;
import org.dfe.components.process.cte4.Cte4ProcessFactory;
import org.dfe.components.process.mdfe.MdfeProcessFactory;
import org.dfe.components.process.nf.NfProcessFactory;

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
