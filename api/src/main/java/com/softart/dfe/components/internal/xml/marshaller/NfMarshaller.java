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
import java.io.StringWriter;

public final class NfMarshaller {

    private NfMarshaller() {
        throw new RuntimeException("No NfMarshaller for you");
    }


    public static String cancelNfe(br.inf.portalfiscal.nfe.event_cancel.TEnvEvento tEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createEnvEvento(tEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procCancelNfe(br.inf.portalfiscal.nfe.event_cancel.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_cancel.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String substituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento tEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createEnvEvento(tEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procSubstituteCancelNfe(br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSubstituteCancelContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String inutNfe(TInutNFe tInutNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createInutNFe(tInutNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retInutNfe(TRetInutNFe response) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createRetInutNFe(response), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procInutNfe(TProcInutNFe procInut) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createProcInutNFe(procInut), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendNfe(TEnviNFe tEnviNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createEnviNFe(tEnviNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procNfe(TNfeProc proc) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createNfeProc(proc), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String nfe(TNFe tnFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createNFe(tnFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retEnviNfe(TRetEnviNFe retEnvi) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createRetEnviNFe(retEnvi), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String queryReceiptNfe(TConsReciNFe tConsReciNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createConsReciNFe(tConsReciNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retQueryReceiptNfe(TRetConsReciNFe tRetConsReciNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createRetConsReciNFe(tRetConsReciNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String queryProcotolNfe(TConsSitNFe tConsSitNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createConsSitNFe(tConsSitNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String queryStatusServiceNfe(TConsStatServ tConsStatServ) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createConsStatServ(tConsStatServ), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retQueryStatusServiceNfe(TRetConsStatServ tRetConsReciNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createRetConsStatServ(tRetConsReciNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String queryGtinNf(TConsGTIN tConsStatServ) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeGtinContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createConsGTIN(tConsStatServ), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnQueryGtinNf(TRetConsGTIN tRetConsReciNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeGtinContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.gtin.ObjectFactory().createRetConsGTIN(tRetConsReciNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retQueryProtocolNfe(TRetConsSitNFe tRetConsReciNFe) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new ObjectFactory().createRetConsSitNFe(tRetConsReciNFe), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String distributionNfe(TDistDFeInt data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.distribution.ObjectFactory().createDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retDistributionNfe(TRetDistDFeInt data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeDistributionContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.distribution.ObjectFactory().createRetDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String manifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createEnvEvento(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retManifestationNfe(br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeManifestationContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String epecNfe(br.inf.portalfiscal.nfe.event_epec.TEnvEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeEpecContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createEnvEvento(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retEpecNfe(br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeEpecContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procEpecNfe(br.inf.portalfiscal.nfe.event_epec.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeEpecContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_epec.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String correctionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createEnvEvento(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procCorrectionLetterNfe(br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeCorrectionLetterContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String interestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createEnvEvento(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String retInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento tRetEnvEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createRetEnvEvento(tRetEnvEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procInterestedActorNfe(br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento tProcEvento) {
        try {
            javax.xml.bind.Marshaller marshaller = NfContextFactory.getInstance().getNfeInterestedActorContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createProcEventoNFe(tProcEvento), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

}
