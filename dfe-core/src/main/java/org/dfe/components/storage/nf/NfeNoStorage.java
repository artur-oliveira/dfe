package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TProcEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.NfeStorage;
import lombok.extern.log4j.Log4j2;

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
    public void storeProcManifestation(Store<TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetManifestation(Store<TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendManifestation(Store<TEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcEpec(Store<br.inf.portalfiscal.nfe.event_epec.TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetEpec(Store<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendEpec(Store<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> o) {
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
