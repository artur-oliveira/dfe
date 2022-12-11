package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public final class MdfeMarshaller {

    private final static ObjectFactory fc = new ObjectFactory();

    private MdfeMarshaller() {
        throw new RuntimeException("No MdfeMarshaller for you");
    }

    public static String any(Element element) {
        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            StringWriter sw = new StringWriter();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(element), new StreamResult(sw));
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static String returnDistribution(RetDistDFeInt data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnEvent(TRetEvento data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetEventoMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnQueryReceipt(TRetConsReciMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetConsReciMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnQuerySituation(TRetConsSitMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetConsSitMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnQueryUnclosed(TRetConsMDFeNaoEnc data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetConsMDFeNaoEnc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnReception(TRetEnviMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetEnviMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnReceptionSync(TRetMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnStatusService(TRetConsStatServ data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createRetConsStatServMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendDistribution(DistDFeInt data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendEvent(TEvento data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createEventoMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procEvent(TProcEvento data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createProcEventoMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendQueryReceipt(TConsReciMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createConsReciMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendQuerySituation(TConsSitMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createConsSitMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendQueryUnclosed(TConsMDFeNaoEnc data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createConsMDFeNaoEnc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendReception(TEnviMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createEnviMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendReceptionSync(TMDFe data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procMdfe(TMdfeProc mdfeProc) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createMdfeProc(mdfeProc), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String sendStatusService(TConsStatServ data) {
        try {
            Marshaller marshaller = MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(fc.createConsStatServMDFe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


}

