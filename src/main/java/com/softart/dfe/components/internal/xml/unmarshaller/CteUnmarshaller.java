package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshaller;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.interfaces.xml.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;
import java.util.Objects;

public final class CteUnmarshaller {

    private CteUnmarshaller() {
        throw new RuntimeException("No CteUnmarshaller for you");
    }

    public static JAXBElement<DistDFeInt> distributionCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteDistributionContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.distribution.ObjectFactory fc = new br.inf.portalfiscal.cte.distribution.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createDistDFeInt((DistDFeInt) ((JAXBElement<?>) o).getValue());
            return fc.createDistDFeInt((DistDFeInt) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TEvento> eventCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createEventoCTe((TEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEventoCTe((TEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TInutCTe> inutCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createInutCTe((TInutCTe) ((JAXBElement<?>) o).getValue());
            return fc.createInutCTe((TInutCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsSitCTe> querySituationCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsSitCTe((TConsSitCTe) ((JAXBElement<?>) o).getValue());
            return fc.createConsSitCTe((TConsSitCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TEnviCTe> receptionCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
            return fc.createEnviCTe((TEnviCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TGTVe> receptionGtve(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createGTVe((TGTVe) ((JAXBElement<?>) o).getValue());
            return fc.createGTVe((TGTVe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TCTeOS> receptionCteOs(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createCTeOS((TCTeOS) ((JAXBElement<?>) o).getValue());
            return fc.createCTeOS((TCTeOS) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TCTe> receptionCteSync(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createCTe((TCTe) ((JAXBElement<?>) o).getValue());
            return fc.createCTe((TCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsReciCTe> queryReceipt(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsReciCTe((TConsReciCTe) ((JAXBElement<?>) o).getValue());
            return fc.createConsReciCTe((TConsReciCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsStatServ> statusService(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createConsStatServCte((TConsStatServ) ((JAXBElement<?>) o).getValue());
            return fc.createConsStatServCte((TConsStatServ) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }


    public static JAXBElement<TProtCTe> protCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.protCte(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<TProtCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createProtCTe((TProtCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtCTe((TProtCTe) o);
            if (Objects.equals(Model.CTE, AccessKeyParserFactory.cte().model(prot.getValue().getInfProt().getChCTe())))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }


    public static JAXBElement<EvCancCTe> evCancCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.protCte(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCancCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCancCTe((EvCancCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCancCTe((EvCancCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.protCte(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCCeCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCCeCTe((EvCCeCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCCeCTe((EvCCeCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvCancCTe o) throws JAXBException, ParserConfigurationException {
        return toElement(new ObjectFactory().createEvCancCTe(o));
    }
    public static Element toElement(EvCCeCTe o) throws JAXBException, ParserConfigurationException {
        return toElement(new ObjectFactory().createEvCCeCTe(o));
    }

    public static Element toElement(JAXBElement<?> o) throws JAXBException {
        DOMResult res = new DOMResult();
        CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(o, res);
        return ((Document)res.getNode()).getDocumentElement();
    }

    public static JAXBElement<TProtCTeOS> protCTeOS(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.protCteOs(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<TProtCTeOS> prot;
            if (o instanceof JAXBElement) prot = fc.createProtCTeOS((TProtCTeOS) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtCTeOS((TProtCTeOS) o);
            if (Objects.equals(Model.CTE_OS, AccessKeyParserFactory.cte().model(prot.getValue().getInfProt().getChCTe())))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TProtGTVe> protGTVe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.protGtve(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<TProtGTVe> prot;
            if (o instanceof JAXBElement) prot = fc.createProtGTVe((TProtGTVe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtGTVe((TProtGTVe) o);
            if (Objects.equals(Model.GTVE, AccessKeyParserFactory.cte().model(prot.getValue().getInfProt().getChCTe())))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TEnviCTe> enviCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
            return fc.createEnviCTe((TEnviCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

}
