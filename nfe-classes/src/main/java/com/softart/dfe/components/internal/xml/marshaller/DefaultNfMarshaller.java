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

    @Override
    public String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento o) {
        try {
            try (StringWriter sw = new StringWriter()) {
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createProcEventoNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createProcEventoNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createInutNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createRetInutNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createProcInutNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createEnviNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createNfeProc(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createRetEnviNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createConsReciNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsReciNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createConsSitNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createConsStatServ(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsStatServ(o), sw);
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
                NfContextFactory.getInstance().getNfeGtinContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createConsGTIN(o), sw);
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
                NfContextFactory.getInstance().getNfeGtinContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createRetConsGTIN(o), sw);
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
                NfContextFactory.getInstance().getNfeSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsSitNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.distribution.ObjectFactory().createDistDFeInt(o), sw);
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
                NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.distribution.ObjectFactory().createRetDistDFeInt(o), sw);
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
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createProcEventoNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeEpecContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createProcEventoNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createProcEventoNFe(o), sw);
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
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createRetEnvEvento(o), sw);
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
                NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller().marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createProcEventoNFe(o), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

}
