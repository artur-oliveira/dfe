package com.softart.dfe.interfaces.xml.context;

import jakarta.xml.bind.JAXBContext;

public interface NfContext {

    JAXBContext getNfeEventContext();

    /**
     * Returns a JAXBContext object for the NFeCancel class
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeCancelContext();

    /**
     * Returns a JAXBContext object for the NfeSubstituteCancel class
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeSubstituteCancelContext();

    /**
     * Returns a JAXBContext object that can be used to marshal and unmarshal NFe objects
     *
     * @return A JAXBContext object.
     */
    JAXBContext getNfeSendContext();

    /**
     * Returns a JAXBContext object that can be used to marshal and unmarshal NFeDistribution objects
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeDistributionContext();

    /**
     * Returns a JAXBContext object that can be used to unmarshal the NFe Manifestation of Receipt XML file
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeManifestationContext();

    /**
     * Returns a JAXBContext object for the NFe Epec package
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeEpecContext();

    /**
     * Returns a JAXBContext object for the NFe Correction Letter
     *
     * @return The JAXBContext object is being returned.
     */
    JAXBContext getNfeCorrectionLetterContext();

    /**
     * Returns a JAXBContext object that can be used to marshal/unmarshal the NFeInterestedActor class
     *
     * @return A JAXBContext object.
     */
    JAXBContext getNfeInterestedActorContext();

    /**
     * Returns a JAXBContext object for the NfeGtin class
     *
     * @return A JAXBContext object.
     */
    JAXBContext getNfeGtinContext();
}
