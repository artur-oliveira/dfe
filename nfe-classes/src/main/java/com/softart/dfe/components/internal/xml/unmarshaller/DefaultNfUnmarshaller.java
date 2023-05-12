package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.UnmarshallException;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;

import java.io.StringReader;

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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_cancel.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return cancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return cancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento> returnCancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return cancelNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return cancelNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_cancel.TProcEvento> procCancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCancelContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_cancel.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return cancelNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_cancel.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return cancelNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_cancel.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return substituteCancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return substituteCancelNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento> returnSubstituteCancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return substituteCancelNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return substituteCancelNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento> procSubstituteCancelNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return substituteCancelNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return substituteCancelNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TEnviNFe)) {
                        throw new UnmarshallException("cannot convert to TEnviNFe", xml);
                    }
                    return sendNfeObjectFactory.createEnviNFe((TEnviNFe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TInutNFe)) {
                        throw new UnmarshallException("cannot convert to TInutNFe", xml);
                    }
                    return sendNfeObjectFactory.createInutNFe((TInutNFe) ((JAXBElement<?>) o).getValue());
                }
                return sendNfeObjectFactory.createInutNFe((TInutNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TRetInutNFe> retInutNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TRetInutNFe)) {
                        throw new UnmarshallException("cannot convert to TRetInutNFe", xml);
                    }
                    return sendNfeObjectFactory.createRetInutNFe((TRetInutNFe) ((JAXBElement<?>) o).getValue());
                }
                return sendNfeObjectFactory.createRetInutNFe((TRetInutNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TProcInutNFe> procInutNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProcInutNFe)) {
                        throw new UnmarshallException("cannot convert to TProcInutNFe", xml);
                    }
                    return sendNfeObjectFactory.createProcInutNFe((TProcInutNFe) ((JAXBElement<?>) o).getValue());
                }
                return sendNfeObjectFactory.createProcInutNFe((TProcInutNFe) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsReciNFe)) {
                        throw new UnmarshallException("cannot convert to TConsReciNFe", xml);
                    }
                    return sendNfeObjectFactory.createConsReciNFe((TConsReciNFe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsSitNFe)) {
                        throw new UnmarshallException("cannot convert to TConsSitNFe", xml);
                    }
                    return sendNfeObjectFactory.createConsSitNFe((TConsSitNFe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TDistDFeInt)) {
                        throw new UnmarshallException("cannot convert to TDistDFeInt", xml);
                    }
                    return distributionNfeObjectFactory.createDistDFeInt((TDistDFeInt) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return manifestationNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return manifestationNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento> returnManifestationNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeManifestationContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return manifestationNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return manifestationNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_manifestation.TProcEvento> procManifestationNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeManifestationContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_manifestation.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return manifestationNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_manifestation.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return manifestationNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_manifestation.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_epec.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return epecNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return epecNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_epec.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento> returnEpecNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeEpecContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return epecNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return epecNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_epec.TProcEvento> procEpecNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeEpecContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_epec.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return epecNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_epec.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return epecNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_epec.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return correcetionLetterNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return correcetionLetterNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento> returnCorrectionLetterNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return correcetionLetterNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return correcetionLetterNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento> procCorrectionLetterNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return correcetionLetterNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return correcetionLetterNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TEnvEvento", xml);
                    }
                    return interestedActorNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return interestedActorNfeObjectFactory.createEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento> returnInterestedActorNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeInterestedActorContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento)) {
                        throw new UnmarshallException("cannot convert to TRetEnvEvento", xml);
                    }
                    return interestedActorNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento) ((JAXBElement<?>) o).getValue());
                }
                return interestedActorNfeObjectFactory.createRetEnvEvento((br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento> procInterestedActorNfe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeInterestedActorContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento)) {
                        throw new UnmarshallException("cannot convert to TProcEvento", xml);
                    }
                    return interestedActorNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento) ((JAXBElement<?>) o).getValue());
                }
                return interestedActorNfeObjectFactory.createProcEventoNFe((br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TNFe)) {
                        throw new UnmarshallException("cannot convert to TNFe", xml);
                    }
                    return sendNfeObjectFactory.createNFe((TNFe) ((JAXBElement<?>) o).getValue());
                }
                return sendNfeObjectFactory.createNFe((TNFe) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TNfeProc> nfeProc(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = NfContextFactory.getInstance().getNfeSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TNfeProc)) {
                        throw new UnmarshallException("cannot convert to TNfeProc", xml);
                    }
                    return sendNfeObjectFactory.createNfeProc((TNfeProc) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsCad)) {
                        throw new UnmarshallException("cannot convert to TConsCad", xml);
                    }
                    return sendNfeObjectFactory.createConsCad((TConsCad) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TRetConsCad)) {
                        throw new UnmarshallException("cannot convert to TRetConsCad", xml);
                    }
                    return sendNfeObjectFactory.createRetConsCad((TRetConsCad) ((JAXBElement<?>) o).getValue());
                }
                return sendNfeObjectFactory.createRetConsCad((TRetConsCad) o);
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }
}
