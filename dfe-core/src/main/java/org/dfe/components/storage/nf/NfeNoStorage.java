package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import lombok.extern.log4j.Log4j2;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfeStorage;

@Log4j2
public final class NfeNoStorage extends NfCommonNoStorage implements NfeStorage {

    @Override
    public void storeRetDistribution(Store<TRetDistDFeInt> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEnvDistribution(Store<TDistDFeInt> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendQueryRegister(Store<TConsCad> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnQueryRegister(Store<TRetConsCad> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }
}
