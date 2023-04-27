package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.UnmarshallException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@SuppressWarnings("unchecked")
final class DefaultNfUnmarshaller extends NfUnmarshallerFactory {

    private final br.inf.portalfiscal.nfe.send.ObjectFactory sendNfeObjectFactory = new br.inf.portalfiscal.nfe.send.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_cancel.ObjectFactory cancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory substituteCancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory correcetionLetterNfeObjectFactory = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_epec.ObjectFactory epecNfeObjectFactory = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory manifestationNfeObjectFactory = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory interestedActorNfeObjectFactory = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
    private final br.inf.portalfiscal.nfe.distribution.ObjectFactory distributionNfeObjectFactory = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento> cancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TEnvEvento>) o;
                }
                return cancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) o);
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

                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento>) o;
                }
                return substituteCancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEnviNFe>) o;
                }
                return sendNfeObjectFactory.createEnviNFe((TEnviNFe) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TInutNFe>) o;
                }
                return sendNfeObjectFactory.createInutNFe((TInutNFe) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsReciNFe>) o;
                }
                return sendNfeObjectFactory.createConsReciNFe((TConsReciNFe) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsSitNFe>) o;
                }
                return sendNfeObjectFactory.createConsSitNFe((TConsSitNFe) o);
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

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TDistDFeInt>) o;
                }
                return distributionNfeObjectFactory.createDistDFeInt((TDistDFeInt) o);
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

                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento>) o;
                }
                return manifestationNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) o);
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

                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_epec.TEnvEvento>) o;
                }
                return epecNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) o);
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

                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento>) o;
                }
                return correcetionLetterNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento>) o;
                }
                return interestedActorNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TNFe>) o;
                }
                return sendNfeObjectFactory.createNFe((TNFe) o);
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
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TNfeProc>) o;
                }
                return sendNfeObjectFactory.createNfeProc((TNfeProc) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TConsCad> queryRegister(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsCad>) o;
                }
                return sendNfeObjectFactory.createConsCad((TConsCad) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TRetConsCad> returnQueryRegister(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TRetConsCad>) o;
                }
                return sendNfeObjectFactory.createRetConsCad((TRetConsCad) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }
}
