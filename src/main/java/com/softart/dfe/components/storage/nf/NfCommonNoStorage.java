package com.softart.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.nf.common.NfCommonStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NfCommonNoStorage implements NfCommonStorage {

    @Override
    public void storeProcNfe(Store<TNfeProc> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetNfe(Store<TRetEnviNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEnvNfe(Store<TEnviNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendCancel(Store<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcInut(Store<TProcInutNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetInut(Store<TRetInutNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEnvInut(Store<TInutNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetQueryProtocol(Store<TRetConsSitNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEnvQueryProtocol(Store<TConsSitNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetReturnAuthorization(Store<TRetConsReciNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEnvReturnAuthorization(Store<TConsReciNFe> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendQueryStatusService(Store<TConsStatServ> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeReturnQueryStatusService(Store<TRetConsStatServ> o) {
        log.info(o.getXml());
    }


    @Override
    public void storeReturnQueryGtin(Store<TRetConsGTIN> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeQueryGtin(Store<TConsGTIN> o) {
        log.info(o.getXml());

    }
}
