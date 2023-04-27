package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import br.inf.portalfiscal.nfe.send.*;
import com.softart.dfe.components.internal.xml.context.NfContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringWriter;

final class DefaultNfMarshaller extends NfMarshallerFactory {

    private final br.inf.portalfiscal.nfe.send.ObjectFactory sendNfeObjectFactory = new br.inf.portalfiscal.nfe.send.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_cancel.ObjectFactory cancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory substituteCancelNfeObjectFactory = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory correcetionLetterNfeObjectFactory = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_epec.ObjectFactory epecNfeObjectFactory = new br.inf.portalfiscal.nfe.event_epec.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory manifestationNfeObjectFactory = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory interestedActorNfeObjectFactory = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory();
    private final br.inf.portalfiscal.nfe.gtin.ObjectFactory gtinNfeObjectFactory = new br.inf.portalfiscal.nfe.gtin.ObjectFactory();
    private final br.inf.portalfiscal.nfe.distribution.ObjectFactory distributionNfeObjectFactory = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();

    @Override
    public String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(cancelNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(cancelNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(cancelNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }


    @Override
    public String substituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(substituteCancelNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(substituteCancelNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(substituteCancelNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }


    @Override
    public String inutNfe(TInutNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createInutNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnInutNfe(TRetInutNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetInutNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procInutNfe(TProcInutNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createProcInutNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String sendNfe(TEnviNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createEnviNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procNfe(TNfeProc o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createNfeProc(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String nfe(TNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnEnviNfe(TRetEnviNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetEnviNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryReceiptNfe(TConsReciNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createConsReciNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryReceiptNfe(TRetConsReciNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetConsReciNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryProcotolNfe(TConsSitNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createConsSitNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryStatusServiceNfe(TConsStatServ o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createConsStatServ(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryStatusServiceNfe(TRetConsStatServ o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetConsStatServ(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryGtinNf(TConsGTIN o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeGtinContext().createMarshaller().marshal(gtinNfeObjectFactory.createConsGTIN(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryGtinNf(TRetConsGTIN o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeGtinContext().createMarshaller().marshal(gtinNfeObjectFactory.createRetConsGTIN(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryProtocolNfe(TRetConsSitNFe o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetConsSitNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String distributionNfe(TDistDFeInt o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller().marshal(distributionNfeObjectFactory.createDistDFeInt(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnDistributionNfe(TRetDistDFeInt o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller().marshal(distributionNfeObjectFactory.createRetDistDFeInt(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String manifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(manifestationNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(manifestationNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(manifestationNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String epecNfe(br.inf.portalfiscal.nfe.event_epec.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(epecNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnEpecNfe(br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(epecNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procEpecNfe(br.inf.portalfiscal.nfe.event_epec.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(epecNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String correctionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(correcetionLetterNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(correcetionLetterNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(correcetionLetterNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String interestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(interestedActorNfeObjectFactory.createEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(interestedActorNfeObjectFactory.createRetEnvEvento(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(interestedActorNfeObjectFactory.createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryRegister(TConsCad o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createConsCad(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryRegister(TRetConsCad o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(sendNfeObjectFactory.createRetConsCad(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }
}
