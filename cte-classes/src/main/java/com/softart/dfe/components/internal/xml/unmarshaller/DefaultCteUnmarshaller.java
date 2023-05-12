package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.exceptions.xml.UnmarshallException;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Element;

import java.io.StringReader;
import java.util.Objects;

final class DefaultCteUnmarshaller extends CteUnmarshallerFactory {

    private final br.inf.portalfiscal.cte.send.ObjectFactory fc = new br.inf.portalfiscal.cte.send.ObjectFactory();
    private final br.inf.portalfiscal.cte.send400.ObjectFactory cte400fc = new br.inf.portalfiscal.cte.send400.ObjectFactory();
    private final br.inf.portalfiscal.cte.distribution.ObjectFactory distFc = new br.inf.portalfiscal.cte.distribution.ObjectFactory();

    @Override
    public JAXBElement<DistDFeInt> distributionCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteDistributionContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof DistDFeInt)) {
                        throw new UnmarshallException("cannot convert to DistDFeInt", xml);
                    }
                    return distFc.createDistDFeInt((DistDFeInt) ((JAXBElement<?>) o).getValue());
                }
                return distFc.createDistDFeInt((DistDFeInt) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<RetDistDFeInt> returnDistributionCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteDistributionContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof RetDistDFeInt)) {
                        throw new UnmarshallException("cannot convert to RetDistDFeInt", xml);
                    }
                    return distFc.createRetDistDFeInt((RetDistDFeInt) ((JAXBElement<?>) o).getValue());
                }
                return distFc.createRetDistDFeInt((RetDistDFeInt) o);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TEvento)) {
                        throw new UnmarshallException("cannot convert to TEvento", xml);
                    }
                    return fc.createEventoCTe((TEvento) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TInutCTe)) {
                        throw new UnmarshallException("cannot convert to TInutCTe", xml);
                    }
                    return fc.createInutCTe((TInutCTe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsSitCTe)) {
                        throw new UnmarshallException("cannot convert to TConsSitCTe", xml);
                    }
                    return fc.createConsSitCTe((TConsSitCTe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TEnviCTe)) {
                        throw new UnmarshallException("cannot convert to TEnviCTe", xml);
                    }
                    return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TGTVe)) {
                        throw new UnmarshallException("cannot convert to TGTVe", xml);
                    }
                    return fc.createGTVe((TGTVe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TCTeOS)) {
                        throw new UnmarshallException("cannot convert to TCTeOS", xml);
                    }
                    return fc.createCTeOS((TCTeOS) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TCTe)) {
                        throw new UnmarshallException("cannot convert to TCTe", xml);
                    }
                    return fc.createCTe((TCTe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsReciCTe)) {
                        throw new UnmarshallException("cannot convert to TConsReciCTe", xml);
                    }
                    return fc.createConsReciCTe((TConsReciCTe) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TConsStatServ)) {
                        throw new UnmarshallException("cannot convert to TConsStatServ", xml);
                    }
                    return fc.createConsStatServCte((TConsStatServ) ((JAXBElement<?>) o).getValue());
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtCTe)) {
                        throw new UnmarshallException("cannot convert to TProtCTe");
                    }
                    prot = fc.createProtCTe((TProtCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createProtCTe((TProtCTe) o);
                }
                if (Objects.equals("57", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> any300(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new UnmarshallException("Object " + o + " of unknown type");
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }


    @Override
    public JAXBElement<EvCancCTe> evCancCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCancCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvCancCTe)) {
                        throw new UnmarshallException("cannot convert to EvCancCTe");
                    }
                    prot = fc.createEvCancCTe((EvCancCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvCancCTe((EvCancCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCancCECTe> evCancCECTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCancCECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvCancCECTe)) {
                        throw new UnmarshallException("cannot convert to EvCancCECTe");
                    }
                    prot = fc.createEvCancCECTe((EvCancCECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvCancCECTe((EvCancCECTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCCeCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvCCeCTe)) {
                        throw new UnmarshallException("cannot convert to EvCCeCTe");
                    }
                    prot = fc.createEvCCeCTe((EvCCeCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvCCeCTe((EvCCeCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCECTe> evCECTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvCECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvCECTe)) {
                        throw new UnmarshallException("cannot convert to EvCECTe");
                    }
                    prot = fc.createEvCECTe((EvCECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvCECTe((EvCECTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvEPECCTe> evEPECCTe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvEPECCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvEPECCTe)) {
                        throw new UnmarshallException("cannot convert to EvEPECCTe");
                    }
                    prot = fc.createEvEPECCTe((EvEPECCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvEPECCTe((EvEPECCTe) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvGTV> evGTV(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvGTV> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvGTV)) {
                        throw new UnmarshallException("cannot convert to EvGTV");
                    }
                    prot = fc.createEvGTV((EvGTV) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvGTV((EvGTV) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvPrestDesacordo> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvPrestDesacordo)) {
                        throw new UnmarshallException("cannot convert to EvPrestDesacordo");
                    }
                    prot = fc.createEvPrestDesacordo((EvPrestDesacordo) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvPrestDesacordo((EvPrestDesacordo) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvRegMultimodal> evRegMultimodal(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<EvRegMultimodal> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof EvRegMultimodal)) {
                        throw new UnmarshallException("cannot convert to EvRegMultimodal");
                    }
                    prot = fc.createEvRegMultimodal((EvRegMultimodal) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createEvRegMultimodal((EvRegMultimodal) o);
                }
                {
                    return prot;
                }
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
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
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtCTeOS)) {
                        throw new UnmarshallException("cannot convert to TProtCTeOS");
                    }
                    prot = fc.createProtCTeOS((TProtCTeOS) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createProtCTeOS((TProtCTeOS) o);
                }
                if (Objects.equals("67", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TProtCTe> protCTe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtCTe)) {
                        throw new UnmarshallException("cannot convert to TProtCTe", xml);
                    }
                    return fc.createProtCTe((TProtCTe) ((JAXBElement<?>) o).getValue());
                }
                return fc.createProtCTe((TProtCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TProtCTeOS> protCTeOS(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtCTeOS)) {
                        throw new UnmarshallException("cannot convert to TProtCTeOS", xml);
                    }
                    return fc.createProtCTeOS((TProtCTeOS) ((JAXBElement<?>) o).getValue());
                }
                return fc.createProtCTeOS((TProtCTeOS) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtGTVe)) {
                        throw new UnmarshallException("cannot convert to TProtGTVe", xml);
                    }
                    return fc.createProtGTVe((TProtGTVe) ((JAXBElement<?>) o).getValue());
                }
                return fc.createProtGTVe((TProtGTVe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protGtve(element))) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<TProtGTVe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TProtGTVe)) {
                        throw new UnmarshallException("cannot convert to TProtGTVe");
                    }
                    prot = fc.createProtGTVe((TProtGTVe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = fc.createProtGTVe((TProtGTVe) o);
                }
                if (Objects.equals("64", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<TEnviCTe> enviCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof TEnviCTe)) {
                        throw new UnmarshallException("cannot convert to TEnviCTe", xml);
                    }
                    return fc.createEnviCTe((TEnviCTe) ((JAXBElement<?>) o).getValue());
                }
                return fc.createEnviCTe((TEnviCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TEvento> eventCte400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TEvento)) {
                        throw new UnmarshallException("cannot convert to TEvento", xml);
                    }
                    return cte400fc.createEventoCTe((br.inf.portalfiscal.cte.send400.TEvento) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createEventoCTe((br.inf.portalfiscal.cte.send400.TEvento) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TInutCTe> inutCte400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TInutCTe)) {
                        throw new UnmarshallException("cannot convert to TInutCTe", xml);
                    }
                    return cte400fc.createInutCTe((br.inf.portalfiscal.cte.send400.TInutCTe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createInutCTe((br.inf.portalfiscal.cte.send400.TInutCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TConsSitCTe> querySituationCte400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TConsSitCTe)) {
                        throw new UnmarshallException("cannot convert to TConsSitCTe", xml);
                    }
                    return cte400fc.createConsSitCTe((br.inf.portalfiscal.cte.send400.TConsSitCTe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createConsSitCTe((br.inf.portalfiscal.cte.send400.TConsSitCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TGTVe> receptionGtve400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TGTVe)) {
                        throw new UnmarshallException("cannot convert to TGTVe", xml);
                    }
                    return cte400fc.createGTVe((br.inf.portalfiscal.cte.send400.TGTVe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createGTVe((br.inf.portalfiscal.cte.send400.TGTVe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCTeOS> receptionCteOs400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TCTeOS)) {
                        throw new UnmarshallException("cannot convert to TCTeOS", xml);
                    }
                    return cte400fc.createCTeOS((br.inf.portalfiscal.cte.send400.TCTeOS) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createCTeOS((br.inf.portalfiscal.cte.send400.TCTeOS) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCTe> receptionCteSync400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TCTe)) {
                        throw new UnmarshallException("cannot convert to TCTe", xml);
                    }
                    return cte400fc.createCTe((br.inf.portalfiscal.cte.send400.TCTe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createCTe((br.inf.portalfiscal.cte.send400.TCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TConsStatServ> statusService400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TConsStatServ)) {
                        throw new UnmarshallException("cannot convert to TConsStatServ", xml);
                    }
                    return cte400fc.createConsStatServCTe((br.inf.portalfiscal.cte.send400.TConsStatServ) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createConsStatServCTe((br.inf.portalfiscal.cte.send400.TConsStatServ) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtCTe)) {
                        throw new UnmarshallException("cannot convert to TProtCTe", xml);
                    }
                    return cte400fc.createProtCTe((br.inf.portalfiscal.cte.send400.TProtCTe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createProtCTe((br.inf.portalfiscal.cte.send400.TProtCTe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protCte(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtCTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.TProtCTe");
                    }
                    prot = cte400fc.createProtCTe((br.inf.portalfiscal.cte.send400.TProtCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createProtCTe((br.inf.portalfiscal.cte.send400.TProtCTe) o);
                }
                if (Objects.equals("57", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> any400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new RuntimeException("Object " + o + " of unknown type");
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCancCTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCancCTe");
                    }
                    prot = cte400fc.createEvCancCTe((br.inf.portalfiscal.cte.send400.EvCancCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCancCTe((br.inf.portalfiscal.cte.send400.EvCancCTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCancCECTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCancCECTe");
                    }
                    prot = cte400fc.createEvCancCECTe((br.inf.portalfiscal.cte.send400.EvCancCECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCancCECTe((br.inf.portalfiscal.cte.send400.EvCancCECTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCCeCTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCCeCTe");
                    }
                    prot = cte400fc.createEvCCeCTe((br.inf.portalfiscal.cte.send400.EvCCeCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCCeCTe((br.inf.portalfiscal.cte.send400.EvCCeCTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCECTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCECTe");
                    }
                    prot = cte400fc.createEvCECTe((br.inf.portalfiscal.cte.send400.EvCECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCECTe((br.inf.portalfiscal.cte.send400.EvCECTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvEPECCTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvEPECCTe");
                    }
                    prot = cte400fc.createEvEPECCTe((br.inf.portalfiscal.cte.send400.EvEPECCTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvEPECCTe((br.inf.portalfiscal.cte.send400.EvEPECCTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvGTV)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvGTV");
                    }
                    prot = cte400fc.createEvGTV((br.inf.portalfiscal.cte.send400.EvGTV) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvGTV((br.inf.portalfiscal.cte.send400.EvGTV) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvPrestDesacordo)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvPrestDesacordo");
                    }
                    prot = cte400fc.createEvPrestDesacordo((br.inf.portalfiscal.cte.send400.EvPrestDesacordo) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvPrestDesacordo((br.inf.portalfiscal.cte.send400.EvPrestDesacordo) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo");
                    }
                    prot = cte400fc.createEvCancPrestDesacordo((br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCancPrestDesacordo((br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvIECTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvIECTe");
                    }
                    prot = cte400fc.createEvIECTe((br.inf.portalfiscal.cte.send400.EvIECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvIECTe((br.inf.portalfiscal.cte.send400.EvIECTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvCancIECTe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvCancIECTe");
                    }
                    prot = cte400fc.createEvCancIECTe((br.inf.portalfiscal.cte.send400.EvCancIECTe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvCancIECTe((br.inf.portalfiscal.cte.send400.EvCancIECTe) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().any(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.EvRegMultimodal)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.EvRegMultimodal");
                    }
                    prot = cte400fc.createEvRegMultimodal((br.inf.portalfiscal.cte.send400.EvRegMultimodal) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createEvRegMultimodal((br.inf.portalfiscal.cte.send400.EvRegMultimodal) o);
                }
                return prot;
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCancCTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.RodoOS o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createRodoOS(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCCeCTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCCeCTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCECTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCECTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCECTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCancCECTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvEPECCTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvEPECCTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvGTV o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvGTV(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvRegMultimodal o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvRegMultimodal(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvPrestDesacordo o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvPrestDesacordo(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCancPrestDesacordo(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvIECTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvIECTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancIECTe o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createEvCancIECTe(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Rodo o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createRodo(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aereo o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createAereo(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aquav o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createAquav(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Duto o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createDuto(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Ferrov o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createFerrov(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Multimodal o) throws JAXBException {
        return XMLUtils.toElement(cte400fc.createMultimodal(o), CteContextFactory.getInstance().getCte400SendContext().createMarshaller());
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protCteOs(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtCTeOS)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.TProtCTeOS");
                    }
                    prot = cte400fc.createProtCTeOS((br.inf.portalfiscal.cte.send400.TProtCTeOS) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createProtCTeOS((br.inf.portalfiscal.cte.send400.TProtCTeOS) o);
                }
                if (Objects.equals("67", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtCTeOS)) {
                        throw new UnmarshallException("cannot convert to TProtCTeOS", xml);
                    }
                    return cte400fc.createProtCTeOS((br.inf.portalfiscal.cte.send400.TProtCTeOS) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createProtCTeOS((br.inf.portalfiscal.cte.send400.TProtCTeOS) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(Element element) {
        try {
            try (StringReader sr = new StringReader(CteMarshallerFactory.getInstance().protGtve(element))) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> prot;
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtGTVe)) {
                        throw new UnmarshallException("cannot convert to br.inf.portalfiscal.cte.send400.TProtGTVe");
                    }
                    prot = cte400fc.createProtGTVe((br.inf.portalfiscal.cte.send400.TProtGTVe) ((JAXBElement<?>) o).getValue());
                } else {
                    prot = cte400fc.createProtGTVe((br.inf.portalfiscal.cte.send400.TProtGTVe) o);
                }
                if (Objects.equals("64", prot.getValue().getInfProt().getChCTe().substring(20, 22))) {
                    return prot;
                }
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof br.inf.portalfiscal.cte.send400.TProtGTVe)) {
                        throw new UnmarshallException("cannot convert to TProtGTVe", xml);
                    }
                    return cte400fc.createProtGTVe((br.inf.portalfiscal.cte.send400.TProtGTVe) ((JAXBElement<?>) o).getValue());
                }
                return cte400fc.createProtGTVe((br.inf.portalfiscal.cte.send400.TProtGTVe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }

    }
}
