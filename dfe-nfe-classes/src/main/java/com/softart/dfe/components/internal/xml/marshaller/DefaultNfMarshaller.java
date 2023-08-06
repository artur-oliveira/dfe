package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.components.internal.xml.objectfactory.NfObjectFactoryWrapperFactory;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;

final class DefaultNfMarshaller extends NfMarshallerFactory {

    String eventMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeEventContext(), el);
    }

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
    public String eventNfe(br.inf.portalfiscal.nfe.event_generic.TEnvEvento o) {
        return eventMarshall(NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnEventNfe(br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento o) {
        return eventMarshall(NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procEventNfe(br.inf.portalfiscal.nfe.event_generic.TProcEvento o) {
        return eventMarshall(NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createProcEventoNFe(o));
    }

    @Override
    public String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento o) {
        return cancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getCancelNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento o) {
        return cancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getCancelNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TProcEvento o) {
        return cancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getCancelNfeObjectFactory().createProcEventoNFe(o));
    }


    @Override
    public String substituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento o) {
        return substituteCancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getSubstituteCancelNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento o) {
        return substituteCancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getSubstituteCancelNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento o) {
        return substituteCancelMarshall(NfObjectFactoryWrapperFactory.getInstance().getSubstituteCancelNfeObjectFactory().createProcEventoNFe(o));
    }


    @Override
    public String inutNfe(TInutNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createInutNFe(o));
    }

    @Override
    public String returnInutNfe(TRetInutNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetInutNFe(o));
    }

    @Override
    public String procInutNfe(TProcInutNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createProcInutNFe(o));
    }

    @Override
    public String sendNfe(TEnviNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createEnviNFe(o));
    }

    @Override
    public String procNfe(TNfeProc o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createNfeProc(o));
    }

    @Override
    public String nfe(TNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createNFe(o));
    }

    @Override
    public String returnEnviNfe(TRetEnviNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetEnviNFe(o));
    }

    @Override
    public String queryReceiptNfe(TConsReciNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsReciNFe(o));
    }

    @Override
    public String returnQueryReceiptNfe(TRetConsReciNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsReciNFe(o));
    }

    @Override
    public String queryProcotolNfe(TConsSitNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsSitNFe(o));
    }

    @Override
    public String queryStatusServiceNfe(TConsStatServ o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsStatServ(o));
    }

    @Override
    public String returnQueryStatusServiceNfe(TRetConsStatServ o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsStatServ(o));
    }

    @Override
    public String queryGtinNf(TConsGTIN o) {
        return gtinMarshall(NfObjectFactoryWrapperFactory.getInstance().getGtinNfeObjectFactory().createConsGTIN(o));
    }

    @Override
    public String returnQueryGtinNf(TRetConsGTIN o) {
        return gtinMarshall(NfObjectFactoryWrapperFactory.getInstance().getGtinNfeObjectFactory().createRetConsGTIN(o));
    }

    @Override
    public String returnQueryProtocolNfe(TRetConsSitNFe o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsSitNFe(o));
    }

    @Override
    public String distributionNfe(TDistDFeInt o) {
        return distributionMarshall(NfObjectFactoryWrapperFactory.getInstance().getDistributionNfeObjectFactory().createDistDFeInt(o));
    }

    @Override
    public String returnDistributionNfe(TRetDistDFeInt o) {
        return distributionMarshall(NfObjectFactoryWrapperFactory.getInstance().getDistributionNfeObjectFactory().createRetDistDFeInt(o));
    }

    @Override
    public String manifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento o) {
        return manifestationMarshall(NfObjectFactoryWrapperFactory.getInstance().getManifestationNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String procManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TProcEvento o) {
        return manifestationMarshall(NfObjectFactoryWrapperFactory.getInstance().getManifestationNfeObjectFactory().createProcEventoNFe(o));
    }

    @Override
    public String returnManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento o) {
        return manifestationMarshall(NfObjectFactoryWrapperFactory.getInstance().getManifestationNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String epecNfe(br.inf.portalfiscal.nfe.event_epec.TEnvEvento o) {
        return epecMarshall(NfObjectFactoryWrapperFactory.getInstance().getEpecNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnEpecNfe(br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento o) {
        return epecMarshall(NfObjectFactoryWrapperFactory.getInstance().getEpecNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procEpecNfe(br.inf.portalfiscal.nfe.event_epec.TProcEvento o) {
        return epecMarshall(NfObjectFactoryWrapperFactory.getInstance().getEpecNfeObjectFactory().createProcEventoNFe(o));
    }

    @Override
    public String correctionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento o) {
        return correctionLetterMarshall(NfObjectFactoryWrapperFactory.getInstance().getCorrectionLetterNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento o) {
        return correctionLetterMarshall(NfObjectFactoryWrapperFactory.getInstance().getCorrectionLetterNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento o) {
        return correctionLetterMarshall(NfObjectFactoryWrapperFactory.getInstance().getCorrectionLetterNfeObjectFactory().createProcEventoNFe(o));
    }

    @Override
    public String interestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento o) {
        return interestedActorMarshall(NfObjectFactoryWrapperFactory.getInstance().getInterestedActorNfeObjectFactory().createEnvEvento(o));
    }

    @Override
    public String returnInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento o) {
        return interestedActorMarshall(NfObjectFactoryWrapperFactory.getInstance().getInterestedActorNfeObjectFactory().createRetEnvEvento(o));
    }

    @Override
    public String procInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento o) {
        return interestedActorMarshall(NfObjectFactoryWrapperFactory.getInstance().getInterestedActorNfeObjectFactory().createProcEventoNFe(o));
    }

    @Override
    public String queryRegister(TConsCad o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsCad(o));
    }

    @Override
    public String returnQueryRegister(TRetConsCad o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsCad(o));
    }
}
