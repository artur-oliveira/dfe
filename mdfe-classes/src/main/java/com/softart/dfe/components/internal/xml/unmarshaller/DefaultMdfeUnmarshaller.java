package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import java.io.StringReader;

@SuppressWarnings({"unchecked", "unused"})
final class DefaultMdfeUnmarshaller extends MdfeUnmarshallerFactory {

    private final ObjectFactory fc = new ObjectFactory();

    @Override
    public JAXBElement<TDistDFe> sendDistribution(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TDistDFe>) o;
                }
                return fc.createDistMDFe((TDistDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEvento> sendEvent(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEvento>) o;
                }
                return fc.createEventoMDFe((TEvento) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsReciMDFe> sendQueryReceipt(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsReciMDFe>) o;
                }
                return fc.createConsReciMDFe((TConsReciMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsSitMDFe> sendQuerySituation(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsSitMDFe>) o;
                }
                return fc.createConsSitMDFe((TConsSitMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsMDFeNaoEnc> sendQueryUnclosed(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsMDFeNaoEnc>) o;
                }
                return fc.createConsMDFeNaoEnc((TConsMDFeNaoEnc) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEnviMDFe> sendReception(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TEnviMDFe>) o;
                }
                return fc.createEnviMDFe((TEnviMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TMDFe> sendReceptionSync(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TMDFe>) o;
                }
                return fc.createMDFe((TMDFe) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TConsStatServ> sendStatusService(String xml) {
        try {
            try (StringReader sw = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(sw);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TConsStatServ>) o;
                }
                return fc.createConsStatServMDFe((TConsStatServ) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TRetEvento> returnEvent(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TRetEvento>) o;
                }
                return fc.createRetEventoMDFe((TRetEvento) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<TProtMDFe> protMdfe(Element el) {
        try {
            try (StringReader reader = new StringReader("<protMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\">" + MdfeMarshallerFactory.getInstance().any(el) + "</protMDFe>")) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);

                if (o instanceof JAXBElement) {
                    return (JAXBElement<TProtMDFe>) o;
                }
                return fc.createProtMDFe((TProtMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public JAXBElement<EvCancMDFe> evCancMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvCancMDFe>) o;
                }
                return fc.createEvCancMDFe((EvCancMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvCancMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvCancMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public Element toElement(Rodo element) throws JAXBException {
        return XMLUtils.toElement(fc.createRodo(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public Element toElement(Aquav element) throws JAXBException {
        return XMLUtils.toElement(fc.createAquav(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public Element toElement(Aereo element) throws JAXBException {
        return XMLUtils.toElement(fc.createAereo(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public Element toElement(Ferrov element) throws JAXBException {
        return XMLUtils.toElement(fc.createFerrov(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public JAXBElement<?> any(Element element) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(element))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
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
    public JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvAlteracaoPagtoServMDFe>) o;
                }
                return fc.createEvAlteracaoPagtoServMDFe((EvAlteracaoPagtoServMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvAlteracaoPagtoServMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvAlteracaoPagtoServMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvConfirmaServMDFe>) o;
                }
                return fc.createEvConfirmaServMDFe((EvConfirmaServMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvConfirmaServMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvConfirmaServMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public JAXBElement<EvEncMDFe> evEncMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvEncMDFe>) o;
                }
                return fc.createEvEncMDFe((EvEncMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvEncMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvEncMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvIncCondutorMDFe>) o;
                }
                return fc.createEvIncCondutorMDFe((EvIncCondutorMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvIncCondutorMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvIncCondutorMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }


    @Override
    public JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvIncDFeMDFe>) o;
                }
                return fc.createEvIncDFeMDFe((EvIncDFeMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvIncDFeMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvIncDFeMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }

    @Override
    public JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(Element el) {
        try {
            try (StringReader reader = new StringReader(MdfeMarshallerFactory.getInstance().any(el))) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<EvPagtoOperMDFe>) o;
                }
                return fc.createEvPagtoOperMDFe((EvPagtoOperMDFe) o);
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(EvPagtoOperMDFe element) throws JAXBException {
        return XMLUtils.toElement(fc.createEvPagtoOperMDFe(element), MdfeContextFactory.getInstance().getMdfeContext().createMarshaller());
    }
}

