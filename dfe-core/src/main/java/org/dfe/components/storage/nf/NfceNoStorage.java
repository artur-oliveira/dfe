package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfceStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class NfceNoStorage extends NfCommonNoStorage implements NfceStorage {
    @Override
    public void storeProcSubstituteCancel(Store<TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnSubstituteCancel(Store<TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendSubstituteCancel(Store<TEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }
}
