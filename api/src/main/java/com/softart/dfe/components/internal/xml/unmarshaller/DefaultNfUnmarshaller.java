package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.UnmarshallException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

final class DefaultNfUnmarshaller extends NfUnmarshallerFactory {

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> cancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_cancel.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento> substituteCancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TEnviNFe> enviNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement) return fc.createEnviNFe((TEnviNFe) ((JAXBElement<?>) o).getValue());
                return fc.createEnviNFe((TEnviNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TInutNFe> inutNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement) return fc.createInutNFe((TInutNFe) ((JAXBElement<?>) o).getValue());
                return fc.createInutNFe((TInutNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TConsReciNFe> queryReceiptNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createConsReciNFe((TConsReciNFe) ((JAXBElement<?>) o).getValue());
                return fc.createConsReciNFe((TConsReciNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TConsSitNFe> queryProtocolNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement) return fc.createConsSitNFe((TConsSitNFe) ((JAXBElement<?>) o).getValue());
                return fc.createConsSitNFe((TConsSitNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TDistDFeInt> distributionNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeDistributionContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.distribution.ObjectFactory fc = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();
                if (o instanceof JAXBElement) return fc.createDistDFeInt((TDistDFeInt) ((JAXBElement<?>) o).getValue());
                return fc.createDistDFeInt((TDistDFeInt) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento> manifestationNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeManifestationContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento> epecNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeEpecContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_epec.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento> correctionLetterNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento> interestedActorNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeInterestedActorContext().createUnmarshaller().unmarshal(reader);
                br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory fc = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) ((JAXBElement<?>) o).getValue());
                return fc.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TNFe> nfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createNFe((TNFe) ((JAXBElement<?>) o).getValue());
                return fc.createNFe((TNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TNfeProc> nfeProc(String xmlProc) {
        try {
            try (StringReader reader = new StringReader(xmlProc)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                ObjectFactory fc = new ObjectFactory();
                if (o instanceof JAXBElement)
                    return fc.createNfeProc((TNfeProc) ((JAXBElement<?>) o).getValue());
                return fc.createNfeProc((TNfeProc) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }
}
