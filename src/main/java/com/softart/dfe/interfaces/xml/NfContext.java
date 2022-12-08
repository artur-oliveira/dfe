package com.softart.dfe.interfaces.xml;

import javax.xml.bind.JAXBContext;

public interface NfContext {

    JAXBContext getNfeCancelContext();

    JAXBContext getNfeSubstituteCancelContext();

    JAXBContext getNfeSendContext();

    JAXBContext getNfeDistributionContext();

    JAXBContext getNfeManifestationContext();

    JAXBContext getNfeEpecContext();

    JAXBContext getNfeCorrectionLetterContext();

    JAXBContext getNfeInterestedActorContext();

    JAXBContext getNfeGtinContext();
}
