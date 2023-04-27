package com.softart.dfe.components.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class MdfeNoStorage implements MdfeStorage {

    private static final Boolean LOG = Boolean.parseBoolean(System.getProperty("com.softart.dfe.storage.mdfe.logxml", "true"));


    @Override
    public void storeRetDistribution(Store<TRetDistDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendDistribution(Store<TDistDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeRetEvent(Store<TRetEvento> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendEvent(Store<TEvento> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeRetQueryReceipt(Store<TRetConsReciMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendQueryReceipt(Store<TConsReciMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeRetQuerySituation(Store<TRetConsSitMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendQuerySituation(Store<TConsSitMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeSendMdfe(Store<TEnviMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeReturnSendMdfe(Store<TRetEnviMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeProcMdfe(Store<TMdfeProc> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeMdfe(Store<TMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeReturnMdfe(Store<TRetMDFe> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeProcMdfeSync(Store<TMdfeProc> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) {
        if (LOG) {
            log.debug(o.getXml());
        }
    }
}
