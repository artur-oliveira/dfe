package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.parser.AccessKeyParserFactory;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshaller;
import com.softart.dfe.enums.internal.Model;
import com.softart.dfe.exceptions.xml.MarshallException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
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

    public static JAXBElement<?> any(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            if (o instanceof JAXBElement) return (JAXBElement<?>) o;
            throw new RuntimeException("Object " + o + " of unknown type");
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }


    public static JAXBElement<EvCancCTe> evCancCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCancCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCancCTe((EvCancCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCancCTe((EvCancCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvCancCECTe> evCancCECTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCancCECTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCancCECTe((EvCancCECTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCancCECTe((EvCancCECTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCCeCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCCeCTe((EvCCeCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCCeCTe((EvCCeCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvCECTe> evCECTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvCECTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCECTe((EvCECTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCECTe((EvCECTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvEPECCTe> evEPECCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvEPECCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvEPECCTe((EvEPECCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvEPECCTe((EvEPECCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvGTV> evGTV(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvGTV> prot;
            if (o instanceof JAXBElement) prot = fc.createEvGTV((EvGTV) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvGTV((EvGTV) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvPrestDesacordo> prot;
            if (o instanceof JAXBElement)
                prot = fc.createEvPrestDesacordo((EvPrestDesacordo) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvPrestDesacordo((EvPrestDesacordo) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvRegMultimodal> evRegMultimodal(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshaller.any(element)));
            br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
            JAXBElement<EvRegMultimodal> prot;
            if (o instanceof JAXBElement)
                prot = fc.createEvRegMultimodal((EvRegMultimodal) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvRegMultimodal((EvRegMultimodal) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvCancCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCancCTe(o));
    }

    public static Element toElement(EvCCeCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCCeCTe(o));
    }

    public static Element toElement(EvCECTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCECTe(o));
    }

    public static Element toElement(EvCancCECTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCancCECTe(o));
    }

    public static Element toElement(EvEPECCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvEPECCTe(o));
    }

    public static Element toElement(EvGTV o) throws JAXBException {
        return toElement(new ObjectFactory().createEvGTV(o));
    }

    public static Element toElement(EvRegMultimodal o) throws JAXBException {
        return toElement(new ObjectFactory().createEvRegMultimodal(o));
    }

    public static Element toElement(EvPrestDesacordo o) throws JAXBException {
        return toElement(new ObjectFactory().createEvPrestDesacordo(o));
    }

    public static Element toElement(Rodo o) throws JAXBException {
        return toElement(new ObjectFactory().createRodo(o));
    }

    public static Element toElement(Aereo o) throws JAXBException {
        return toElement(new ObjectFactory().createAereo(o));
    }

    public static Element toElement(Aquav o) throws JAXBException {
        return toElement(new ObjectFactory().createAquav(o));
    }

    public static Element toElement(Duto o) throws JAXBException {
        return toElement(new ObjectFactory().createDuto(o));
    }

    public static Element toElement(Ferrov o) throws JAXBException {
        return toElement(new ObjectFactory().createFerrov(o));
    }

    public static Element toElement(Multimodal o) throws JAXBException {
        return toElement(new ObjectFactory().createMultimodal(o));
    }

    public static Element toElement(JAXBElement<?> o) throws JAXBException {
        DOMResult res = new DOMResult();
        CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(o, res);
        return ((Document) res.getNode()).getDocumentElement();
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
