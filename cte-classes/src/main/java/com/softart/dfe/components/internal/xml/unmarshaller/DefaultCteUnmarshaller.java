package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;
import java.util.Objects;

final class DefaultCteUnmarshaller extends CteUnmarshallerFactory {

    @Override
    public JAXBElement<DistDFeInt> distributionCte(String xml) {
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

    @Override
    public JAXBElement<TEvento> eventCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createEventoCTe((TEvento) ((JAXBElement<?>) o).getValue());
            return fc.createEventoCTe((TEvento) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TInutCTe> inutCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createInutCTe((TInutCTe) ((JAXBElement<?>) o).getValue());
            return fc.createInutCTe((TInutCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsSitCTe> querySituationCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsSitCTe((TConsSitCTe) ((JAXBElement<?>) o).getValue());
            return fc.createConsSitCTe((TConsSitCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEnviCTe> receptionCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
            return fc.createEnviCTe((TEnviCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TGTVe> receptionGtve(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createGTVe((TGTVe) ((JAXBElement<?>) o).getValue());
            return fc.createGTVe((TGTVe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TCTeOS> receptionCteOs(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createCTeOS((TCTeOS) ((JAXBElement<?>) o).getValue());
            return fc.createCTeOS((TCTeOS) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TCTe> receptionCteSync(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createCTe((TCTe) ((JAXBElement<?>) o).getValue());
            return fc.createCTe((TCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsReciCTe> queryReceipt(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement) return fc.createConsReciCTe((TConsReciCTe) ((JAXBElement<?>) o).getValue());
            return fc.createConsReciCTe((TConsReciCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsStatServ> statusService(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createConsStatServCte((TConsStatServ) ((JAXBElement<?>) o).getValue());
            return fc.createConsStatServCte((TConsStatServ) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }


    @Override
    public JAXBElement<TProtCTe> protCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().protCte(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<TProtCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createProtCTe((TProtCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtCTe((TProtCTe) o);
            if (Objects.equals("57", prot.getValue().getInfProt().getChCTe().substring(20, 22)))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> any(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            if (o instanceof JAXBElement) return (JAXBElement<?>) o;
            throw new RuntimeException("Object " + o + " of unknown type");
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }


    @Override
    public JAXBElement<EvCancCTe> evCancCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvCancCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCancCTe((EvCancCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCancCTe((EvCancCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCancCECTe> evCancCECTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvCancCECTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCancCECTe((EvCancCECTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCancCECTe((EvCancCECTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvCCeCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCCeCTe((EvCCeCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCCeCTe((EvCCeCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCECTe> evCECTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvCECTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvCECTe((EvCECTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvCECTe((EvCECTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvEPECCTe> evEPECCTe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvEPECCTe> prot;
            if (o instanceof JAXBElement) prot = fc.createEvEPECCTe((EvEPECCTe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvEPECCTe((EvEPECCTe) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvGTV> evGTV(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvGTV> prot;
            if (o instanceof JAXBElement) prot = fc.createEvGTV((EvGTV) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvGTV((EvGTV) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvPrestDesacordo> prot;
            if (o instanceof JAXBElement)
                prot = fc.createEvPrestDesacordo((EvPrestDesacordo) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvPrestDesacordo((EvPrestDesacordo) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvRegMultimodal> evRegMultimodal(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().any(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<EvRegMultimodal> prot;
            if (o instanceof JAXBElement)
                prot = fc.createEvRegMultimodal((EvRegMultimodal) ((JAXBElement<?>) o).getValue());
            else prot = fc.createEvRegMultimodal((EvRegMultimodal) o);
            return prot;
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvCancCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCancCTe(o));
    }

    @Override
    public Element toElement(RodoOS o) throws JAXBException {
        return toElement(new ObjectFactory().createRodoOS(o));
    }

    @Override
    public Element toElement(EvCCeCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCCeCTe(o));
    }

    @Override
    public Element toElement(EvCECTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCECTe(o));
    }

    @Override
    public Element toElement(EvCancCECTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvCancCECTe(o));
    }

    @Override
    public Element toElement(EvEPECCTe o) throws JAXBException {
        return toElement(new ObjectFactory().createEvEPECCTe(o));
    }

    @Override
    public Element toElement(EvGTV o) throws JAXBException {
        return toElement(new ObjectFactory().createEvGTV(o));
    }

    @Override
    public Element toElement(EvRegMultimodal o) throws JAXBException {
        return toElement(new ObjectFactory().createEvRegMultimodal(o));
    }

    @Override
    public Element toElement(EvPrestDesacordo o) throws JAXBException {
        return toElement(new ObjectFactory().createEvPrestDesacordo(o));
    }

    @Override
    public Element toElement(Rodo o) throws JAXBException {
        return toElement(new ObjectFactory().createRodo(o));
    }

    @Override
    public Element toElement(Aereo o) throws JAXBException {
        return toElement(new ObjectFactory().createAereo(o));
    }

    @Override
    public Element toElement(Aquav o) throws JAXBException {
        return toElement(new ObjectFactory().createAquav(o));
    }

    @Override
    public Element toElement(Duto o) throws JAXBException {
        return toElement(new ObjectFactory().createDuto(o));
    }

    @Override
    public Element toElement(Ferrov o) throws JAXBException {
        return toElement(new ObjectFactory().createFerrov(o));
    }

    @Override
    public Element toElement(Multimodal o) throws JAXBException {
        return toElement(new ObjectFactory().createMultimodal(o));
    }

    @Override
    public Element toElement(JAXBElement<?> o) throws JAXBException {
        DOMResult res = new DOMResult();
        CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(o, res);
        return ((Document) res.getNode()).getDocumentElement();
    }

    @Override
    public JAXBElement<TProtCTeOS> protCTeOS(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().protCteOs(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<TProtCTeOS> prot;
            if (o instanceof JAXBElement) prot = fc.createProtCTeOS((TProtCTeOS) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtCTeOS((TProtCTeOS) o);
            if (Objects.equals("67", prot.getValue().getInfProt().getChCTe().substring(20, 22)))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            Object o = unmarshaller.unmarshal(new StringReader(CteMarshallerFactory.getInstance().protGtve(element)));
            ObjectFactory fc = new ObjectFactory();
            JAXBElement<TProtGTVe> prot;
            if (o instanceof JAXBElement) prot = fc.createProtGTVe((TProtGTVe) ((JAXBElement<?>) o).getValue());
            else prot = fc.createProtGTVe((TProtGTVe) o);
            if (Objects.equals("64", prot.getValue().getInfProt().getChCTe().substring(20, 22)))
                return prot;
            throw new RuntimeException();
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<TEnviCTe> enviCte(String xml) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Object o = unmarshaller.unmarshal(reader);
            ObjectFactory fc = new ObjectFactory();
            if (o instanceof JAXBElement)
                return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
            return fc.createEnviCTe((TEnviCTe) o);
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }
}
