package org.dfe.components.process;

import org.dfe.components.process.cte4.Cte4ProcessFactory;
import org.dfe.components.process.mdfe.MdfeProcessFactory;
import org.dfe.components.process.nf.NfProcessFactory;

final class DefaultNoStorageProcessFactory extends ProcessFactory {
    @Override
    public NfProcessFactory nf() {
        return NfProcessFactory.noStorageProcess();
    }

    @Override
    public MdfeProcessFactory mdfe() {
        return MdfeProcessFactory.noStorageProcess();
    }

    @Override
    public Cte4ProcessFactory cte4() {
        return Cte4ProcessFactory.noStorageProcess();
    }
}
