package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshaller;
import com.softart.dfe.exceptions.xml.MarshallException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;
import java.io.StringReader;

@SuppressWarnings({"unchecked", "unused"})
public final class MdfeUnmarshaller {

    private final static ObjectFactory fc = new ObjectFactory();

    private MdfeUnmarshaller() {
        throw new RuntimeException("No MdfeUnmarshaller for you");
    }

    public static Element toElement(JAXBElement<?> o) throws JAXBException {
        DOMResult res = new DOMResult();
        MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(o, res);
        return ((Document) res.getNode()).getDocumentElement();
    }

    public static JAXBElement<DistDFeInt> sendDistribution(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<DistDFeInt>) o;
                return fc.createDistDFeInt((DistDFeInt) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TEvento> sendEvent(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TEvento>) o;
                return fc.createEventoMDFe((TEvento) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsReciMDFe> sendQueryReceipt(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TConsReciMDFe>) o;
                return fc.createConsReciMDFe((TConsReciMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsSitMDFe> sendQuerySituation(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TConsSitMDFe>) o;
                return fc.createConsSitMDFe((TConsSitMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsMDFeNaoEnc> sendQueryUnclosed(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TConsMDFeNaoEnc>) o;
                return fc.createConsMDFeNaoEnc((TConsMDFeNaoEnc) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TEnviMDFe> sendReception(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TEnviMDFe>) o;
                return fc.createEnviMDFe((TEnviMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TMDFe> sendReceptionSync(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TMDFe>) o;
                return fc.createMDFe((TMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TConsStatServ> sendStatusService(String xml) {
        try {
            Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader sw = new StringReader(xml)) {
                Object o = unmarshaller.unmarshal(sw);

                if (o instanceof JAXBElement) return (JAXBElement<TConsStatServ>) o;
                return fc.createConsStatServMDFe((TConsStatServ) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    public static JAXBElement<TRetEvento> returnEvent(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);

                if (o instanceof JAXBElement) return (JAXBElement<TRetEvento>) o;
                return fc.createRetEventoMDFe((TRetEvento) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<TProtMDFe> protMdfe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader("<protMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\">" + MdfeMarshaller.any(el) + "</protMDFe>")) {
                Object o = unmarshaller.unmarshal(reader);

                if (o instanceof JAXBElement) return (JAXBElement<TProtMDFe>) o;
                return fc.createProtMDFe((TProtMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvCancMDFe> evCancMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement) return fc.createEvCancMDFe((EvCancMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvCancMDFe((EvCancMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvCancMDFe element) throws JAXBException {
        return toElement(fc.createEvCancMDFe(element));
    }

    public static Element toElement(Rodo element) throws JAXBException {
        return toElement(fc.createRodo(element));
    }

    public static Element toElement(Aquav element) throws JAXBException {
        return toElement(fc.createAquav(element));
    }

    public static Element toElement(Aereo element) throws JAXBException {
        return toElement(fc.createAereo(element));
    }

    public static Element toElement(Ferrov element) throws JAXBException {
        return toElement(fc.createFerrov(element));
    }

    public static JAXBElement<?> any(Element element) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(element))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement) return (JAXBElement<?>) o;
                throw new RuntimeException("Object " + o + " of unknown type");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvAlteracaoPagtoServMDFe((EvAlteracaoPagtoServMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvAlteracaoPagtoServMDFe((EvAlteracaoPagtoServMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvAlteracaoPagtoServMDFe element) throws JAXBException {
        return toElement(fc.createEvAlteracaoPagtoServMDFe(element));
    }

    public static JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvConfirmaServMDFe((EvConfirmaServMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvConfirmaServMDFe((EvConfirmaServMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvConfirmaServMDFe element) throws JAXBException {
        return toElement(fc.createEvConfirmaServMDFe(element));
    }

    public static JAXBElement<EvEncMDFe> evEncMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvEncMDFe((EvEncMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvEncMDFe((EvEncMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvEncMDFe element) throws JAXBException {
        return toElement(fc.createEvEncMDFe(element));
    }

    public static JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvIncCondutorMDFe((EvIncCondutorMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvIncCondutorMDFe((EvIncCondutorMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvIncCondutorMDFe element) throws JAXBException {
        return toElement(fc.createEvIncCondutorMDFe(element));
    }


    public static JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvIncDFeMDFe((EvIncDFeMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvIncDFeMDFe((EvIncDFeMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvIncDFeMDFe element) throws JAXBException {
        return toElement(fc.createEvIncDFeMDFe(element));
    }

    public static JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(Element el) {
        try {
            javax.xml.bind.Unmarshaller unmarshaller = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller();
            try (StringReader reader = new StringReader(MdfeMarshaller.any(el))) {
                Object o = unmarshaller.unmarshal(reader);
                if (o instanceof JAXBElement)
                    return fc.createEvPagtoOperMDFe((EvPagtoOperMDFe) ((JAXBElement<?>) o).getValue());
                return fc.createEvPagtoOperMDFe((EvPagtoOperMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    public static Element toElement(EvPagtoOperMDFe element) throws JAXBException {
        return toElement(fc.createEvPagtoOperMDFe(element));
    }
}

