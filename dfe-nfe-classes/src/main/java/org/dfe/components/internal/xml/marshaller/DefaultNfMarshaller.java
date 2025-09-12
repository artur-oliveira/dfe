package org.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import org.dfe.components.internal.xml.context.NfContextFactory;
import org.dfe.components.internal.xml.objectfactory.NfObjectFactoryWrapperFactory;
import org.dfe.util.XMLUtils;

final class DefaultNfMarshaller extends NfMarshallerFactory {

    String eventMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeEventContext(), el);
    }

    String sendMarshall(JAXBElement<?> el) {
        return XMLUtils.marshall(NfContextFactory.getInstance().getNfeSendContext(), el);
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
    public String queryRegister(TConsCad o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsCad(o));
    }

    @Override
    public String returnQueryRegister(TRetConsCad o) {
        return sendMarshall(NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsCad(o));
    }
}
