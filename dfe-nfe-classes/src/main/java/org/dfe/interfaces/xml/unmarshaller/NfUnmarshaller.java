package org.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import org.w3c.dom.Element;

public interface NfUnmarshaller {
    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> eventNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> returnEventNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_generic.TProcEvento> procEventNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> cancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> returnCancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> procCancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> substituteCancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento> returnSubstituteCancelNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento> procSubstituteCancelNfe(String xml);

    JAXBElement<TEnviNFe> enviNfe(String xml);

    JAXBElement<TInutNFe> inutNfe(String xml);

    JAXBElement<TRetInutNFe> retInutNfe(String xml);

    JAXBElement<TProcInutNFe> procInutNfe(String xml);

    JAXBElement<TConsReciNFe> queryReceiptNfe(String xml);

    JAXBElement<TConsSitNFe> queryProtocolNfe(String xml);

    JAXBElement<TDistDFeInt> distributionNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> manifestationNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento> returnManifestationNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TProcEvento> procManifestationNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> epecNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> returnEpecNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_epec.TProcEvento> procEpecNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> correctionLetterNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> returnCorrectionLetterNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> procCorrectionLetterNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> interestedActorNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> returnInterestedActorNfe(String xml);

    JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> procInterestedActorNfe(String xml);

    JAXBElement<TNFe> nfe(String xml);

    JAXBElement<TNfeProc> nfeProc(String xmlProc);

    JAXBElement<TConsCad> queryRegister(String xml);

    JAXBElement<TRetConsCad> returnQueryRegister(String xml);

    JAXBElement<?> anySendNfe(Element el);

    JAXBElement<?> anySendNfe(String xml);

    JAXBElement<?> anyCancelNfe(String xml);

    JAXBElement<?> anyEventNfe(String xml);

    JAXBElement<?> anySubstituteCancelNfe(Element el);

    JAXBElement<?> anySubstituteCancelNfe(String xml);

    JAXBElement<?> anyCorrectionLetterNfe(Element el);

    JAXBElement<?> anyCorrectionLetterNfe(String xml);

    JAXBElement<?> anyEpecNfe(Element el);

    JAXBElement<?> anyEpecNfe(String xml);

    JAXBElement<?> anyManifestationNfe(Element el);

    JAXBElement<?> anyManifestationNfe(String xml);

    JAXBElement<?> anyInterestedActorNfe(Element el);

    JAXBElement<?> anyInterestedActorNfe(String xml);

    JAXBElement<?> anyDistributionNfe(Element el);

    JAXBElement<?> anyDistributionNfe(String xml);

}
