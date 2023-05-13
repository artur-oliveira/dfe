package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.UnmarshallException;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Element;

import java.io.StringReader;

final class DefaultNfUnmarshaller extends NfUnmarshallerFactory {

    private final br.inf.portalfiscal.nfe.send.ObjectFactory sendNfeObjectFactory = new br.inf.portalfiscal.nfe.send.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_cancel.ObjectFactory cancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory substituteCancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory correctionLetterNfeObjectFactory = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_epec.ObjectFactory epecNfeObjectFactory = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory manifestationNfeObjectFactory = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory interestedActorNfeObjectFactory = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
    private final br.inf.portalfiscal.nfe.distribution.ObjectFactory distributionNfeObjectFactory = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();

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
    public JAXBElement<?> anyCancelNfe(String xml) {
        try (StringReader sr = new StringReader(xml)) {
            Object o = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller().unmarshal(sr);
            if (o instanceof JAXBElement) {
                return (JAXBElement<?>) o;
            }
            throw new UnmarshallException("Object " + o + " of unknown type");
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> anySubstituteCancelNfe(Element el) {
        return anySubstituteCancelNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anySubstituteCancelNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createUnmarshaller().unmarshal(sr);
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
    public JAXBElement<?> anyCorrectionLetterNfe(Element el) {
        return anyCorrectionLetterNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anyCorrectionLetterNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createUnmarshaller().unmarshal(sr);
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
    public JAXBElement<?> anyEpecNfe(Element el) {
        return anyEpecNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anyEpecNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeEpecContext().createUnmarshaller().unmarshal(sr);
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
    public JAXBElement<?> anyManifestationNfe(Element el) {
        return anyManifestationNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anyManifestationNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeManifestationContext().createUnmarshaller().unmarshal(sr);
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
    public JAXBElement<?> anyInterestedActorNfe(Element el) {
        return anyInterestedActorNfe(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<?> anyInterestedActorNfe(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeInterestedActorContext().createUnmarshaller().unmarshal(sr);
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
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> cancelNfe(String xml) {
        return cancelNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anyCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_cancel.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> returnCancelNfe(String xml) {
        return cancelNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anyCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> procCancelNfe(String xml) {
        return cancelNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anyCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_cancel.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> substituteCancelNfe(String xml) {
        return substituteCancelNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anySubstituteCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento> returnSubstituteCancelNfe(String xml) {
        return substituteCancelNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anySubstituteCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento> procSubstituteCancelNfe(String xml) {
        return substituteCancelNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anySubstituteCancelNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<TEnviNFe> enviNfe(String xml) {
        return sendNfeObjectFactory.createEnviNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TEnviNFe.class, xml));
    }

    @Override
    public JAXBElement<TInutNFe> inutNfe(String xml) {
        return sendNfeObjectFactory.createInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TRetInutNFe> retInutNfe(String xml) {
        return sendNfeObjectFactory.createRetInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TRetInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TProcInutNFe> procInutNfe(String xml) {
        return sendNfeObjectFactory.createProcInutNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TProcInutNFe.class, xml));
    }

    @Override
    public JAXBElement<TConsReciNFe> queryReceiptNfe(String xml) {
        return sendNfeObjectFactory.createConsReciNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsReciNFe.class, xml));
    }

    @Override
    public JAXBElement<TConsSitNFe> queryProtocolNfe(String xml) {
        return sendNfeObjectFactory.createConsSitNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsSitNFe.class, xml));
    }

    @Override
    public JAXBElement<TDistDFeInt> distributionNfe(String xml) {
        return distributionNfeObjectFactory.createDistDFeInt(XMLUtils.getJaxbElementValue(anyDistributionNfe(xml).getValue(), TDistDFeInt.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> manifestationNfe(String xml) {
        return manifestationNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anyManifestationNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento> returnManifestationNfe(String xml) {
        return manifestationNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anyManifestationNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TProcEvento> procManifestationNfe(String xml) {
        return manifestationNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anyManifestationNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_manifestation.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> epecNfe(String xml) {
        return epecNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anyEpecNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_epec.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> returnEpecNfe(String xml) {
        return epecNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anyEpecNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TProcEvento> procEpecNfe(String xml) {
        return epecNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anyEpecNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_epec.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> correctionLetterNfe(String xml) {
        return correctionLetterNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anyCorrectionLetterNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento.class, xml));
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> returnCorrectionLetterNfe(String xml) {
        return correctionLetterNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anyCorrectionLetterNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> procCorrectionLetterNfe(String xml) {
        return correctionLetterNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anyCorrectionLetterNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> interestedActorNfe(String xml) {
        return interestedActorNfeObjectFactory.createEnvEvento(XMLUtils.getJaxbElementValue(anyInterestedActorNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> returnInterestedActorNfe(String xml) {
        return interestedActorNfeObjectFactory.createRetEnvEvento(XMLUtils.getJaxbElementValue(anyInterestedActorNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> procInterestedActorNfe(String xml) {
        return interestedActorNfeObjectFactory.createProcEventoNFe(XMLUtils.getJaxbElementValue(anyInterestedActorNfe(xml).getValue(), br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento.class, xml));
    }

    @Override
    public JAXBElement<TNFe> nfe(String xml) {
        return sendNfeObjectFactory.createNFe(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TNFe.class, xml));
    }

    @Override
    public JAXBElement<TNfeProc> nfeProc(String xml) {
        return sendNfeObjectFactory.createNfeProc(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TNfeProc.class, xml));
    }

    @Override
    public JAXBElement<TConsCad> queryRegister(String xml) {
        return sendNfeObjectFactory.createConsCad(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TConsCad.class, xml));
    }

    @Override
    public JAXBElement<TRetConsCad> returnQueryRegister(String xml) {
        return sendNfeObjectFactory.createRetConsCad(XMLUtils.getJaxbElementValue(anySendNfe(xml).getValue(), TRetConsCad.class, xml));
    }
}
