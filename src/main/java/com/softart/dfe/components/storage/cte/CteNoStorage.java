package com.softart.dfe.components.storage.cte;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.cte.CteStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class CteNoStorage implements CteStorage {
    @Override
    public void storeDistribution(Store<DistDFeInt> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnDistribution(Store<RetDistDFeInt> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEvent(Store<TEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnEvent(Store<TRetEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcEvent(Store<TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeInutilization(Store<TInutCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnInutilization(Store<TRetInutCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcInutilization(Store<TProcInutCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeQueryReceipt(Store<TConsReciCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnQueryReceipt(Store<TRetConsReciCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeQuerySituation(Store<TConsSitCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnQuerySituation(Store<TRetConsSitCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeGtve(Store<TGTVe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnGtve(Store<TRetGTVe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcGtve(Store<TGTVeProc> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeCteOs(Store<TCTeOS> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnCteOs(Store<TRetCTeOS> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcCteOs(Store<TCteOSProc> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeCte(Store<TEnviCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnCte(Store<TRetEnviCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcCte(Store<TCteProc> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeCteSync(Store<TCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnCteSync(Store<TRetCTe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcCteSync(Store<TCteProc> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeStatusService(Store<TConsStatServ> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnStatusService(Store<TRetConsStatServ> o) {
        log.info(o.getXml());
    }
}
