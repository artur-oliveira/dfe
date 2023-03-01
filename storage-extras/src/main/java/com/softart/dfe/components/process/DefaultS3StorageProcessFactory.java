package com.softart.dfe.components.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
import com.softart.dfe.components.process.mdfe.MdfeProcessFactory;
import com.softart.dfe.components.process.nf.NfProcessFactory;


final class DefaultS3StorageProcessFactory extends ProcessFactory {
    @Override
    public NfProcessFactory nf() {
        return NfProcessFactory.s3StorageProcess();
    }

    @Override
    public CteProcessFactory cte() {
        return CteProcessFactory.noStorageProcess();
    }

    @Override
    public MdfeProcessFactory mdfe() {
        return MdfeProcessFactory.noStorageProcess();
    }
}
