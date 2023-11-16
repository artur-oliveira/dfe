package org.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import org.dfe.interfaces.storage.Store;
import org.dfe.interfaces.storage.nf.common.NfCommonStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NfCommonNoStorage implements NfCommonStorage {

    protected static final Boolean LOG_XML = Boolean.parseBoolean(System.getProperty("org.dfe.storage.nf.logxml", "true"));

    @Override
    public void storeProcNfe(Store<TNfeProc> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetNfe(Store<TRetEnviNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEnvNfe(Store<TEnviNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeProcInut(Store<TProcInutNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetInut(Store<TRetInutNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEnvInut(Store<TInutNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetQueryProtocol(Store<TRetConsSitNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEnvQueryProtocol(Store<TConsSitNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeRetReturnAuthorization(Store<TRetConsReciNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeEnvReturnAuthorization(Store<TConsReciNFe> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeSendQueryStatusService(Store<TConsStatServ> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeReturnQueryStatusService(Store<TRetConsStatServ> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }


    @Override
    public void storeReturnQueryGtin(Store<TRetConsGTIN> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }

    @Override
    public void storeQueryGtin(Store<TConsGTIN> o) {
        if (LOG_XML) {
            log.debug(o.xml());
        }
    }
}
