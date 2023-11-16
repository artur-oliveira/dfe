package org.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import org.dfe.components.internal.xml.context.CteContextFactory;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.components.internal.xml.objectfactory.CteObjectFactoryWrapperFactory;
import org.dfe.exceptions.xml.MarshallException;
import org.dfe.exceptions.xml.UnmarshallException;
import org.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Element;

import java.io.StringReader;

final class DefaultCteUnmarshaller extends CteUnmarshallerFactory {

    @Override
    public JAXBElement<DistDFeInt> distributionCte(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteDistributionContext().createUnmarshaller().unmarshal(reader);
                if (o instanceof JAXBElement) {
                    if (!(((JAXBElement<?>) o).getValue() instanceof DistDFeInt)) {
                        throw new UnmarshallException("cannot convert to DistDFeInt", xml);
                    }
                    return CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createDistDFeInt((DistDFeInt) ((JAXBElement<?>) o).getValue());
                }
                return CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createDistDFeInt((DistDFeInt) o);
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
                    return CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createRetDistDFeInt((RetDistDFeInt) ((JAXBElement<?>) o).getValue());
                }
                return CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createRetDistDFeInt((RetDistDFeInt) o);
            }
        } catch (JAXBException e) {
            throw new MarshallException(e, xml);
        }
    }

    @Override
    public JAXBElement<TEvento> eventCte(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEventoCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TEvento.class, xml));
    }

    @Override
    public JAXBElement<TInutCTe> inutCte(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createInutCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TInutCTe.class, xml));
    }

    @Override
    public JAXBElement<TConsSitCTe> querySituationCte(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createConsSitCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TConsSitCTe.class, xml));
    }

    @Override
    public JAXBElement<TEnviCTe> receptionCte(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEnviCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TEnviCTe.class, xml));
    }

    @Override
    public JAXBElement<TGTVe> receptionGtve(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createGTVe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TGTVe.class, xml));
    }

    @Override
    public JAXBElement<TCTeOS> receptionCteOs(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createCTeOS(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TCTeOS.class, xml));
    }

    @Override
    public JAXBElement<TCTe> receptionCteSync(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TCTe.class, xml));
    }

    @Override
    public JAXBElement<TConsReciCTe> queryReceipt(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createConsReciCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TConsReciCTe.class, xml));
    }

    @Override
    public JAXBElement<TConsStatServ> statusService(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createConsStatServCte(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TConsStatServ.class, xml));
    }


    @Override
    public JAXBElement<TProtCTe> protCTe(Element element) {
        return protCTe(CteMarshallerFactory.getInstance().protCte(element));
    }

    @Override
    public JAXBElement<?> any300(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCteSendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new UnmarshallException("Object " + o + " of unknown type");
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<?> any300(Element element) {
        return any300(XMLUtils.elementToString(element));
    }


    @Override
    public JAXBElement<EvCancCTe> evCancCTe(Element element) {
        return evCancCTe(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvCancCTe> evCancCTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvCancCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvCancCTe.class, xml));
    }

    @Override
    public JAXBElement<EvCancCECTe> evCancCECTe(Element element) {
        return evCancCECTe(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvCancCECTe> evCancCECTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvCancCECTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvCancCECTe.class, xml));
    }

    @Override
    public JAXBElement<EvCCeCTe> evCCeCTe(Element element) {
        return evCCeCTe(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvCCeCTe> evCCeCTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvCCeCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvCCeCTe.class, xml));
    }

    @Override
    public JAXBElement<EvCECTe> evCECTe(Element element) {
        return evCECTe(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvCECTe> evCECTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvCECTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvCECTe.class, xml));
    }

    @Override
    public JAXBElement<EvEPECCTe> evEPECCTe(Element element) {
        return evEPECCTe(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvEPECCTe> evEPECCTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvEPECCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvEPECCTe.class, xml));
    }

    @Override
    public JAXBElement<EvGTV> evGTV(Element element) {
        return evGTV(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvGTV> evGTV(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvGTV(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvGTV.class, xml));
    }

    @Override
    public JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element) {
        return evPrestDesacordo(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvPrestDesacordo> evPrestDesacordo(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvPrestDesacordo(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvPrestDesacordo.class, xml));
    }

    @Override
    public JAXBElement<EvRegMultimodal> evRegMultimodal(Element element) {
        return evRegMultimodal(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<EvRegMultimodal> evRegMultimodal(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEvRegMultimodal(XMLUtils.getJaxbElementValue(any300(xml).getValue(), EvRegMultimodal.class, xml));
    }

    @Override
    public JAXBElement<Rodo> rodo(Element el) {
        return rodo(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Rodo> rodo(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createRodo(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Rodo.class, xml));
    }

    @Override
    public JAXBElement<Aereo> aereo(Element el) {
        return aereo(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Aereo> aereo(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createAereo(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Aereo.class, xml));
    }

    @Override
    public JAXBElement<Ferrov> ferrov(Element el) {
        return ferrov(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Ferrov> ferrov(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createFerrov(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Ferrov.class, xml));
    }

    @Override
    public JAXBElement<Aquav> aquav(Element el) {
        return aquav(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Aquav> aquav(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createAquav(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Aquav.class, xml));
    }

    @Override
    public JAXBElement<Multimodal> multimodal(Element el) {
        return multimodal(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Multimodal> multimodal(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createMultimodal(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Multimodal.class, xml));
    }

    @Override
    public JAXBElement<TProtCTeOS> protCTeOS(Element element) {
        return protCTeOS(CteMarshallerFactory.getInstance().protCteOs(element));
    }

    @Override
    public JAXBElement<TProtCTe> protCTe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createProtCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TProtCTe.class, xml));
    }

    @Override
    public JAXBElement<TProtCTeOS> protCTeOS(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createProtCTeOS(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TProtCTeOS.class, xml));
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createProtGTVe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TProtGTVe.class, xml));
    }

    @Override
    public JAXBElement<TProtGTVe> protGTVe(Element element) {
        return protGTVe(CteMarshallerFactory.getInstance().protGtve(element));
    }

    @Override
    public JAXBElement<TEnviCTe> enviCte(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createEnviCTe(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TEnviCTe.class, xml));
    }

    @Override
    public JAXBElement<TCteProc> cteProc(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createCteProc(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TCteProc.class, xml));
    }

    @Override
    public JAXBElement<TCteOSProc> cteOsProc(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createCteOSProc(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TCteOSProc.class, xml));
    }

    @Override
    public JAXBElement<TGTVeProc> gtveProc(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createGTVeProc(XMLUtils.getJaxbElementValue(any300(xml).getValue(), TGTVeProc.class, xml));
    }

    @Override
    public JAXBElement<?> any400(Element element) {
        return any400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<?> any400(String xml) {
        try {
            try (StringReader sr = new StringReader(xml)) {
                Object o = CteContextFactory.getInstance().getCte400SendContext().createUnmarshaller().unmarshal(sr);
                if (o instanceof JAXBElement) {
                    return (JAXBElement<?>) o;
                }
                throw new RuntimeException("Object " + o + " of unknown type");
            }
        } catch (JAXBException e) {
            throw new UnmarshallException(e);
        }
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(Element element) {
        return protCTe400(CteMarshallerFactory.getInstance().protCte(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TEvento> eventCte400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEventoCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TEvento.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TInutCTe> inutCte400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createInutCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TInutCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TConsSitCTe> querySituationCte400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createConsSitCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TConsSitCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TGTVe> receptionGtve400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createGTVe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TGTVe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCTeOS> receptionCteOs400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCTeOS(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TCTeOS.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCTe> receptionCteSync400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TConsStatServ> statusService400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createConsStatServCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TConsStatServ.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TRetConsStatServ> returnStatusService400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetConsStatServCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TRetConsStatServ.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTe> protCTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createProtCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TProtCTe.class, xml));
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(Element element) {
        return evCancCTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCTe> evCancCTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCancCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(Element element) {
        return evCancCECTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancCECTe> evCancCECTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancCECTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCancCECTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(Element element) {
        return evCCeCTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCCeCTe> evCCeCTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCCeCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCCeCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(Element element) {
        return evCECTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCECTe> evCECTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCECTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCECTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(Element element) {
        return evEPECCTe400(XMLUtils.elementToString(element));
    }


    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvEPECCTe> evEPECCTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvEPECCTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvEPECCTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(Element element) {
        return evGTV400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvGTV> evGTV400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvGTV(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvGTV.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(Element element) {
        return evPrestDesacordo400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvPrestDesacordo> evPrestDesacordo400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvPrestDesacordo(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvPrestDesacordo.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(Element element) {
        return evCancPrestDesacordo400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo> evCancPrestDesacordo400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancPrestDesacordo(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(Element element) {
        return evIECTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvIECTe> evIECTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvIECTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvIECTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(Element element) {
        return evCancIECTe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvCancIECTe> evCancIECTe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancIECTe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvCancIECTe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(Element element) {
        return evRegMultimodal400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.EvRegMultimodal> evRegMultimodal400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvRegMultimodal(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.EvRegMultimodal.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(Element element) {
        return protCTeOS400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtCTeOS> protCTeOS400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createProtCTeOS(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TProtCTeOS.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(Element element) {
        return protGTVe400(XMLUtils.elementToString(element));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TProtGTVe> protGTVe400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createProtGTVe(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TProtGTVe.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Rodo> rodo400(Element el) {
        return rodo400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Rodo> rodo400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRodo(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Rodo.class, xml));
    }

    @Override
    public JAXBElement<Duto> duto(Element el) {
        return duto(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<Duto> duto(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCteObjectFactory().createDuto(XMLUtils.getJaxbElementValue(any300(xml).getValue(), Duto.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Aereo> aereo400(Element el) {
        return aereo400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Aereo> aereo400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createAereo(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Aereo.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Ferrov> ferrov400(Element el) {
        return ferrov400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Ferrov> ferrov400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createFerrov(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Ferrov.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Aquav> aquav400(Element el) {
        return aquav400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Aquav> aquav400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createAquav(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Aquav.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Multimodal> multimodal400(Element el) {
        return multimodal400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Multimodal> multimodal400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createMultimodal(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Multimodal.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Duto> duto400(Element el) {
        return duto400(XMLUtils.elementToString(el));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.Duto> duto400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createDuto(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.Duto.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCteProc> cteProc400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCteProc(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TCteProc.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TCteOSProc> cteOsProc400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCteOSProc(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TCteOSProc.class, xml));
    }

    @Override
    public JAXBElement<br.inf.portalfiscal.cte.send400.TGTVeProc> gtveProc400(String xml) {
        return CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createGTVeProc(XMLUtils.getJaxbElementValue(any400(xml).getValue(), br.inf.portalfiscal.cte.send400.TGTVeProc.class, xml));
    }
}
