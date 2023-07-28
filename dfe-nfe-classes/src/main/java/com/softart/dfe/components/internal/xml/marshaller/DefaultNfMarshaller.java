package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;

final class DefaultNfMarshaller extends NfMarshallerFactory {

    private final br.inf.portalfiscal.nfe.send.ObjectFactory sendNfeObjectFactory = new br.inf.portalfiscal.nfe.send.ObjectFactory();

    private final br.inf.portalfiscal.nfe.event_cancel.ObjectFactory cancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory substituteCancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory correctionLetterNfeObjectFactory = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_epec.ObjectFactory epecNfeObjectFactory = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory manifestationNfeObjectFactory = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory interestedActorNfeObjectFactory = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
    private final br.inf.portalfiscal.nfe.gtin.ObjectFactory gtinNfeObjectFactory = new br.inf.portalfiscal.nfe.gtin.ObjectFactory();
    private final br.inf.portalfiscal.nfe.distribution.ObjectFactory distributionNfeObjectFactory = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();


    String cancelMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeCancelContext(), el);
    }

    String sendMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeSendContext(), el);
    }

    String substituteCancelMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeSubstituteCancelContext(), el);
    }

    String correctionLetterMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeCorrectionLetterContext(), el);
    }

    String epecMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeEpecContext(), el);
    }

    String manifestationMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeManifestationContext(), el);
    }

    String interestedActorMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeInterestedActorContext(), el);
    }

    String gtinMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeGtinContext(), el);
    }

    String distributionMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeDistributionContext(), el);
    }

    @Override
    public String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento o) {
        return cancelMarshall(cancelNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String returnCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento o) {
        return cancelMarshall(cancelNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String procCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TProcEvento o) {
        return cancelMarshall(cancelNfeObjectFactory.createProcEventoNFe(o));
    }


    @Override
    public String substituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento o) {
        return substituteCancelMarshall(substituteCancelNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String returnSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento o) {
        return substituteCancelMarshall(substituteCancelNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String procSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento o) {
        return substituteCancelMarshall(substituteCancelNfeObjectFactory.createProcEventoNFe(o));
    }


    @Override
    public String inutNfe(TInutNFe o) {
        return sendMarshall(sendNfeObjectFactory.createInutNFe(o));
    }

    @Override
    public String returnInutNfe(TRetInutNFe o) {
        return sendMarshall(sendNfeObjectFactory.createRetInutNFe(o));
    }

    @Override
    public String procInutNfe(TProcInutNFe o) {
        return sendMarshall(sendNfeObjectFactory.createProcInutNFe(o));
    }

    @Override
    public String sendNfe(TEnviNFe o) {
        return sendMarshall(sendNfeObjectFactory.createEnviNFe(o));
    }

    @Override
    public String procNfe(TNfeProc o) {
        return sendMarshall(sendNfeObjectFactory.createNfeProc(o));
    }

    @Override
    public String nfe(TNFe o) {
        return sendMarshall(sendNfeObjectFactory.createNFe(o));
    }

    @Override
    public String returnEnviNfe(TRetEnviNFe o) {
        return sendMarshall(sendNfeObjectFactory.createRetEnviNFe(o));
    }

    @Override
    public String queryReceiptNfe(TConsReciNFe o) {
        return sendMarshall(sendNfeObjectFactory.createConsReciNFe(o));
    }

    @Override
    public String returnQueryReceiptNfe(TRetConsReciNFe o) {
        return sendMarshall(sendNfeObjectFactory.createRetConsReciNFe(o));
    }

    @Override
    public String queryProcotolNfe(TConsSitNFe o) {
        return sendMarshall(sendNfeObjectFactory.createConsSitNFe(o));
    }

    @Override
    public String queryStatusServiceNfe(TConsStatServ o) {
        return sendMarshall(sendNfeObjectFactory.createConsStatServ(o));
    }

    @Override
    public String returnQueryStatusServiceNfe(TRetConsStatServ o) {
        return sendMarshall(sendNfeObjectFactory.createRetConsStatServ(o));
    }

    @Override
    public String queryGtinNf(TConsGTIN o) {
        return gtinMarshall(gtinNfeObjectFactory.createConsGTIN(o));
    }

    @Override
    public String returnQueryGtinNf(TRetConsGTIN o) {
        return gtinMarshall(gtinNfeObjectFactory.createRetConsGTIN(o));
    }

    @Override
    public String returnQueryProtocolNfe(TRetConsSitNFe o) {
        return sendMarshall(sendNfeObjectFactory.createRetConsSitNFe(o));
    }

    @Override
    public String distributionNfe(TDistDFeInt o) {
        return distributionMarshall(distributionNfeObjectFactory.createDistDFeInt(o));
    }

    @Override
    public String returnDistributionNfe(TRetDistDFeInt o) {
        return distributionMarshall(distributionNfeObjectFactory.createRetDistDFeInt(o));
    }

    @Override
    public String manifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento o) {
        return manifestationMarshall(manifestationNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String procManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TProcEvento o) {
        return manifestationMarshall(manifestationNfeObjectFactory.createProcEventoNFe(o));
    }

    @Override
    public String returnManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento o) {
        return manifestationMarshall(manifestationNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String epecNfe(br.inf.portalfiscal.nfe.event_epec.TEnvEvento o) {
        return epecMarshall(epecNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String returnEpecNfe(br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento o) {
        return epecMarshall(epecNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String procEpecNfe(br.inf.portalfiscal.nfe.event_epec.TProcEvento o) {
        return epecMarshall(epecNfeObjectFactory.createProcEventoNFe(o));
    }

    @Override
    public String correctionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento o) {
        return correctionLetterMarshall(correctionLetterNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String returnCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento o) {
        return correctionLetterMarshall(correctionLetterNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String procCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento o) {
        return correctionLetterMarshall(correctionLetterNfeObjectFactory.createProcEventoNFe(o));
    }

    @Override
    public String interestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento o) {
        return interestedActorMarshall(interestedActorNfeObjectFactory.createEnvEvento(o));
    }

    @Override
    public String returnInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento o) {
        return interestedActorMarshall(interestedActorNfeObjectFactory.createRetEnvEvento(o));
    }

    @Override
    public String procInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento o) {
        return interestedActorMarshall(interestedActorNfeObjectFactory.createProcEventoNFe(o));
    }

    @Override
    public String queryRegister(TConsCad o) {
        return sendMarshall(sendNfeObjectFactory.createConsCad(o));
    }

    @Override
    public String returnQueryRegister(TRetConsCad o) {
        return sendMarshall(sendNfeObjectFactory.createRetConsCad(o));
    }
}
