package com.softart.dfe.components.process;

import com.softart.dfe.components.process.cte.CteProcessFactory;
import com.softart.dfe.components.process.cte4.Cte4ProcessFactory;
import com.softart.dfe.components.process.mdfe.MdfeProcessFactory;
import com.softart.dfe.components.process.nf.NfProcessFactory;


final class DefaultS3StorageProcessFactory extends ProcessFactory {
    @Override
    public NfProcessFactory nf() {
        return NfProcessFactory.s3StorageProcess();
    }

    @Override
    public CteProcessFactory cte() {
        return CteProcessFactory.s3StorageProcess();
    }

    @Override
    public MdfeProcessFactory mdfe() {
        return MdfeProcessFactory.s3StorageProcess();
    }

    @Override
    public Cte4ProcessFactory cte4() {
        return Cte4ProcessFactory.s3StorageProcess();
    }
}
