package org.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.dfe.components.internal.xml.context.NfContextFactory;
import org.dfe.components.internal.xml.objectfactory.NfObjectFactoryWrapperFactory;
import org.dfe.exceptions.xml.UnmarshallException;
import org.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import java.io.StringReader;

final class DefaultNfUnmarshaller extends NfUnmarshallerFactory {

    @Override
    public JAXBElement<?> anySendNfe(Element el) {
        return anySendNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anySendNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new UnmarshallException("Object " + o + " of unknown type");
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> anyEventNfe(String xml) {
        try (StringReader sr = new StringReader(xml)) {
            Object o = NfContextFactory.getInstance().getNfeEventContext().createUnmarshaller().unmarshal(sr);
            if (o instanceof JAXBElement) {
                return (JAXBElement<?>) o;
            }
            throw new UnmarshallException("Object " + o + " of unknown type");
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> anyDistributionNfe(Element el) {
        return anyDistributionNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anyDistributionNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeDistributionContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new UnmarshallException("Object " + o + " of unknown type");
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_generic.TEnvEvento> eventNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createEnvEvento(XMLUtils.getJaxbElementValue(anyEventNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_generic.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento> returnEventNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createRetEnvEvento(XMLUtils.getJaxbElementValue(anyEventNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_generic.TProcEvento> procEventNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getEventNfeObjectFactory().createProcEventoNFe(XMLUtils.getJaxbElementValue(anyEventNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_generic.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<TEnviNFe> enviNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createEnviNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TEnviNFe.class, xml));
    }

    @Override
    public JAXBElement<TInutNFe> inutNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TRetInutNFe> retInutNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TRetInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TProcInutNFe> procInutNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createProcInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TProcInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TConsReciNFe> queryReceiptNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsReciNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsReciNFe.class, xml));
    }

    @Override
    public JAXBElement<TConsSitNFe> queryProtocolNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsSitNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsSitNFe.class, xml));
    }

    @Override
    public JAXBElement<TDistDFeInt> distributionNfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getDistributionNfeObjectFactory().createDistDFeInt(XMLUtils.getJaxbElementValue(anyDistributionNfe(xml).getValue(), TDistDFeInt.class, xml));
    }


    @Override
    public JAXBElement<TNFe> nfe(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TNFe.class, xml));
    }

    @Override
    public JAXBElement<TNfeProc> nfeProc(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createNfeProc(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TNfeProc.class, xml));
    }

    @Override
    public JAXBElement<TConsCad> queryRegister(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createConsCad(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsCad.class, xml));
    }

    @Override
    public JAXBElement<TRetConsCad> returnQueryRegister(String xml) {
        return NfObjectFactoryWrapperFactory.getInstance().getSendNfeObjectFactory().createRetConsCad(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TRetConsCad.class, xml));
    }
}
