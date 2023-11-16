package org.dfe.components.storage.cte4;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send400.*;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.cte4.CteStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class CteNoStorage implements CteStorage {

    private static final Boolean LOG_XML = Boolean.parseBoolean(System.getProperty("org.dfe.storage.cte.logxml", "true"));

    @Override
    public void storeDistribution(Store<DistDFeInt> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEvent(Store<TEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnQuerySituation(Store<TRetConsSitCTe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeGtve(Store<TGTVe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnCteOs(Store<TRetCTeOS> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcCteOs(Store<TCteOSProc> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }


    @Override
    public void storeCteSync(Store<TCTe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnCteSync(Store<TRetCTe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcCteSync(Store<TCteProc> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }
}
