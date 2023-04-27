package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.Objects;

@SuppressWarnings("unchecked")
final class DefaultCteUnmarshaller extends CteUnmarshallerFactory {

    private final ObjectFactory fc = new ObjectFactory();
    private final br.inf.portalfiscal.cte.distribution.ObjectFactory distFc = new br.inf.portalfiscal.cte.distribution.ObjectFactory();

    @Override
    public JAXBElement<DistDFeInt> distributionCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteDistributionContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<DistDFeInt>) o;
                }
                return distFc.createDistDFeInt((DistDFeInt) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEvento> eventCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEvento>) o;
                }
                return fc.createEventoCTe((TEvento) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TInutCTe> inutCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TInutCTe>) o;
                }
                return fc.createInutCTe((TInutCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsSitCTe> querySituationCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsSitCTe>) o;
                }
                return fc.createConsSitCTe((TConsSitCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEnviCTe> receptionCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEnviCTe>) o;
                }
                return fc.createEnviCTe((TEnviCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TGTVe> receptionGtve(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TGTVe>) o;
                }
                return fc.createGTVe((TGTVe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TCTeOS> receptionCteOs(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TCTeOS>) o;
                }
                return fc.createCTeOS((TCTeOS) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TCTe> receptionCteSync(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TCTe>) o;
                }
                return fc.createCTe((TCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsReciCTe> queryReceipt(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsReciCTe>) o;
                }
                return fc.createConsReciCTe((TConsReciCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsStatServ> statusService(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsStatServ>) o;
                }
                return fc.createConsStatServCte((TConsStatServ) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }


    @Override
    public JAXBElement<TProtCTe> protCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protCte(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<TProtCTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<TProtCTe>) o;
                } else {
                    prot = fc.createProtCTe((TProtCTe) o);
                }
                if (Objects.equals("57", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> any(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new RuntimeException("Object " + o + " of unknown type");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }


    @Override
    public JAXBElement<EvCancCTe> evCancCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCancCTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvCancCTe>) o;
                } else {
                    prot = fc.createEvCancCTe((EvCancCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCancCECTe> evCancCECTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCancCECTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvCancCECTe>) o;
                } else {
                    prot = fc.createEvCancCECTe((EvCancCECTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCCeCTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvCCeCTe>) o;
                } else {
                    prot = fc.createEvCCeCTe((EvCCeCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCECTe> evCECTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCECTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvCECTe>) o;
                } else {
                    prot = fc.createEvCECTe((EvCECTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvEPECCTe> evEPECCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvEPECCTe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvEPECCTe>) o;
                } else {
                    prot = fc.createEvEPECCTe((EvEPECCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvGTV> evGTV(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvGTV> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvGTV>) o;
                } else {
                    prot = fc.createEvGTV((EvGTV) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvPrestDesacordo> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvPrestDesacordo>) o;
                } else {
                    prot = fc.createEvPrestDesacordo((EvPrestDesacordo) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvRegMultimodal> evRegMultimodal(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvRegMultimodal> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<EvRegMultimodal>) o;
                } else {
                    prot = fc.createEvRegMultimodal((EvRegMultimodal) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvCancCTe o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvCancCTe(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(RodoOS o) throws JAXBException {
        return XMLUtils.toElement(fc.createRodoOS(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvCCeCTe o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvCCeCTe(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvCECTe o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvCECTe(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvCancCECTe o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvCancCECTe(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvEPECCTe o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvEPECCTe(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvGTV o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvGTV(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvRegMultimodal o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvRegMultimodal(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(EvPrestDesacordo o) throws JAXBException {
        return XMLUtils.toElement(fc.createEvPrestDesacordo(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Rodo o) throws JAXBException {
        return XMLUtils.toElement(fc.createRodo(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Aereo o) throws JAXBException {
        return XMLUtils.toElement(fc.createAereo(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Aquav o) throws JAXBException {
        return XMLUtils.toElement(fc.createAquav(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Duto o) throws JAXBException {
        return XMLUtils.toElement(fc.createDuto(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Ferrov o) throws JAXBException {
        return XMLUtils.toElement(fc.createFerrov(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public Element toElement(Multimodal o) throws JAXBException {
        return XMLUtils.toElement(fc.createMultimodal(o), CteContextFactory.getInstance().getCteSendContext().createMarshaller());
    }

    @Override
    public JAXBElement<TProtCTeOS> protCTeOS(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protCteOs(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<TProtCTeOS> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<TProtCTeOS>) o;
                } else {
                    prot = fc.createProtCTeOS((TProtCTeOS) o);
                }
                if (Objects.equals("67", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protGtve(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<TProtGTVe> prot;
                if (o instanceof JAXBElement) {
                    prot = (JAXBElement<TProtGTVe>) o;
                } else {
                    prot = fc.createProtGTVe((TProtGTVe) o);
                }
                if (Objects.equals("64", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<TEnviCTe> enviCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEnviCTe>) o;
                }
                return fc.createEnviCTe((TEnviCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }
}
