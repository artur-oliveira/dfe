package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

public final class NfUnmarshaller {

    private NfUnmarshaller() {
        throw new RuntimeException("No NfUnmarshaller for you");
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> cancelNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_cancel.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> substituteCancelNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TEnviNFe> enviNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createEnviNFe((TEnviNFe) ((JAXBElement<?>) o).getValue());
            return fc.createEnviNFe((TEnviNFe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TInutNFe> inutNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createInutNFe((TInutNFe) ((JAXBElement<?>) o).getValue());
            return fc.createInutNFe((TInutNFe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TConsReciNFe> queryReceiptNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsReciNFe((TConsReciNFe) ((JAXBElement<?>) o).getValue());
            return fc.createConsReciNFe((TConsReciNFe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TConsSitNFe> queryProtocolNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsSitNFe((TConsSitNFe) ((JAXBElement<?>) o).getValue());
            return fc.createConsSitNFe((TConsSitNFe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TDistDFeInt> distributionNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeDistributionContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.distribution.ObjectFactory fc = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createDistDFeInt((TDistDFeInt) ((JAXBElement<?>) o).getValue());
            return fc.createDistDFeInt((TDistDFeInt) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> manifestationNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeManifestationContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> epectNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeEpecContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_epec.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> correctionLetterNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> interestedActorNfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeInterestedActorContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TNFe> nfe(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createNFe((TNFe) ((JAXBElement<?>) o).getValue());
            return fc.createNFe((TNFe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TNfeProc> nfeProc(String xmlProc) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller();
            try (StringReader reader = new StringReader(xmlProc)) {
                Object o = unmarshaller.unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createNfeProc((TNfeProc) ((JAXBElement<?>) o).getValue());
                return fc.createNfeProc((TNfeProc) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }
}
