package com.softart.dfe.components.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TProcEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public final class NfeNoStorage extends NfCommonNoStorage implements NfeStorage {

    @Override
    public void storeRetDistribution(Store<TRetDistDFeInt> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeEnvDistribution(Store<TDistDFeInt> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcManifestation(Store<TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetManifestation(Store<TRetEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendManifestation(Store<TEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendCorrectionLetter(Store<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcEpec(Store<br.inf.portalfiscal.nfe.event_epec.TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetEpec(Store<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendEpec(Store<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeProcInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeRetInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> o) {
        log.info(o.getXml());
    }

    @Override
    public void storeSendInterestedActor(Store<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> o) {
        log.info(o.getXml());
    }
}
