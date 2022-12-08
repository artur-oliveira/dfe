package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public final class CteMarshaller {

    private CteMarshaller() {
        throw new RuntimeException("No CteMarshaller for you");
    }

    public static String distributionCte(DistDFeInt data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteDistributionContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.distribution.ObjectFactory().createDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnDistributionCte(RetDistDFeInt data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteDistributionContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.distribution.ObjectFactory().createRetDistDFeInt(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String eventCte(TEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createEventoCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnEventCte(TRetEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetEventoCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procEventCte(TProcEvento data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createProcEventoCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String inutilizationCte(TInutCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createInutCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnInutilizationCte(TRetInutCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetInutCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String procInutilizationCte(TProcInutCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createProcInutCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String querySituationCte(TConsSitCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createConsSitCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnQuerySituationCte(TRetConsSitCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetConsSitCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String receptionCte(TEnviCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createEnviCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnReceptionCte(TRetEnviCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetEnviCte(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String cteProc(TCteProc data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createCteProc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String receptionGtve(TGTVe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createGTVe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }


    public static String returnReceptionGtve(TRetGTVe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetGTVe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String gtveProc(TGTVeProc data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createGTVeProc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String receptionCteOs(TCTeOS data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createCTeOS(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnReceptionCteOs(TRetCTeOS data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetCTeOS(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String cteOsProc(TCteOSProc data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createCteOSProc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String receptionCteSync(TCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnReceptionCteSync(TRetCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String cteProcSync(TCteProc data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createCteProc(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String queryReceipt(TConsReciCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createConsReciCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnQueryReceipt(TRetConsReciCTe data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetConsReciCTe(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String statusService(TConsStatServ data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createConsStatServCte(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    public static String returnStatusService(TRetConsStatServ data) {
        try {
            javax.xml.bind.Marshaller marshaller = CteContextFactory.getInstance().getCteSendContext().createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(new br.inf.portalfiscal.cte.send.ObjectFactory().createRetConsStatServCte(data), sw);
            return XMLStringUtils.cleanNamespace(sw.toString());
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
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

    public static String protCte(Element element) {
        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            StringWriter sw = new StringWriter();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(element), new StreamResult(sw));
            return XMLStringUtils.cleanNamespace("<protCTe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTe>");
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static String protCteOs(Element element) {

        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            StringWriter sw = new StringWriter();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(element), new StreamResult(sw));
            return XMLStringUtils.cleanNamespace("<protCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTeOS>");
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static String protGtve(Element element) {

        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            StringWriter sw = new StringWriter();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(element), new StreamResult(sw));
            return XMLStringUtils.cleanNamespace("<protGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protGTVe>");
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }
}

