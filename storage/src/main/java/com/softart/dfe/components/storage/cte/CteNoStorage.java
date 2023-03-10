package com.softart.dfe.components.storage.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class CteNoStorage implements CteStorage {

    private static final Boolean LOG_XML = Boolean.parseBoolean(System.getProperty("com.softart.dfe.storage.cte.logxml", "true"));

    @Override
    public void storeDistribution(Store<DistDFeInt> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeEvent(Store<TEvento> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeInutilization(Store<TInutCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnInutilization(Store<TRetInutCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcInutilization(Store<TProcInutCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeQueryReceipt(Store<TConsReciCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnQueryReceipt(Store<TRetConsReciCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnQuerySituation(Store<TRetConsSitCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeGtve(Store<TGTVe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnCteOs(Store<TRetCTeOS> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcCteOs(Store<TCteOSProc> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeCte(Store<TEnviCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnCte(Store<TRetEnviCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcCte(Store<TCteProc> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeCteSync(Store<TCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnCteSync(Store<TRetCTe> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeProcCteSync(Store<TCteProc> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) {
        if (LOG_XML) {
            log.info(o.getXml());
        }
    }
}
