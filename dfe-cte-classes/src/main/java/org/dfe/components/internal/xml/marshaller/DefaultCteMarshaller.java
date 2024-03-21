package org.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.dfe.components.internal.xml.context.CteContextFactory;
import org.dfe.components.internal.xml.objectfactory.CteObjectFactoryWrapperFactory;
import org.dfe.exceptions.xml.MarshallException;
import org.dfe.util.XMLStringUtils;
import org.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

final class DefaultCteMarshaller extends CteMarshallerFactory {

    Marshaller cteSend400Marshaller() {
        try {
            return CteContextFactory.getInstance().getCte400SendContext().createMarshaller();
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    String marshallDistribution(JAXBElement<?> el) {
        return XMLUtils.marshall(CteContextFactory.getInstance().getCteDistributionContext(), el);
    }

    String marshallSend400(JAXBElement<?> el) {
        return XMLUtils.marshall(CteContextFactory.getInstance().getCte400SendContext(), el);
    }

    @Override
    public String distributionCte(DistDFeInt data) {
        return marshallDistribution(CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createDistDFeInt(data));
    }

    @Override
    public String returnDistributionCte(RetDistDFeInt data) {
        return marshallDistribution(CteObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createRetDistDFeInt(data));
    }


    @Override
    public String eventCte(br.inf.portalfiscal.cte.send400.TEvento data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEventoCTe(data));
    }

    @Override
    public String returnEventCte(br.inf.portalfiscal.cte.send400.TRetEvento data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetEventoCTe(data));
    }

    @Override
    public String procEventCte(br.inf.portalfiscal.cte.send400.TProcEvento data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createProcEventoCTe(data));
    }

    @Override
    public String inutilizationCte(br.inf.portalfiscal.cte.send400.TInutCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createInutCTe(data));
    }

    @Override
    public String returnInutilizationCte(br.inf.portalfiscal.cte.send400.TRetInutCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetInutCTe(data));
    }

    @Override
    public String procInutilizationCte(br.inf.portalfiscal.cte.send400.TProcInutCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createProcInutCTe(data));
    }

    @Override
    public String querySituationCte(br.inf.portalfiscal.cte.send400.TConsSitCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createConsSitCTe(data));
    }

    @Override
    public String returnQuerySituationCte(br.inf.portalfiscal.cte.send400.TRetConsSitCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetConsSitCTe(data));
    }

    @Override
    public String cteProc(br.inf.portalfiscal.cte.send400.TCteProc data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCteProc(data));
    }

    @Override
    public String receptionGtve(br.inf.portalfiscal.cte.send400.TGTVe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createGTVe(data));
    }


    @Override
    public String returnReceptionGtve(br.inf.portalfiscal.cte.send400.TRetGTVe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetGTVe(data));
    }

    @Override
    public String gtveProc(br.inf.portalfiscal.cte.send400.TGTVeProc data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createGTVeProc(data));
    }

    @Override
    public String receptionCteOs(br.inf.portalfiscal.cte.send400.TCTeOS data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCTeOS(data));
    }

    @Override
    public String returnReceptionCteOs(br.inf.portalfiscal.cte.send400.TRetCTeOS data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetCTeOS(data));
    }

    @Override
    public String cteOsProc(br.inf.portalfiscal.cte.send400.TCteOSProc data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCteOSProc(data));
    }

    @Override
    public String receptionCteSync(br.inf.portalfiscal.cte.send400.TCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCTe(data));
    }

    @Override
    public String returnReceptionCteSync(br.inf.portalfiscal.cte.send400.TRetCTe data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetCTe(data));
    }

    @Override
    public String cteProcSync(br.inf.portalfiscal.cte.send400.TCteProc data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createCteProc(data));
    }

    @Override
    public String statusService(br.inf.portalfiscal.cte.send400.TConsStatServ data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createConsStatServCTe(data));
    }

    @Override
    public String returnStatusService(br.inf.portalfiscal.cte.send400.TRetConsStatServ data) {
        return marshallSend400(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRetConsStatServCTe(data));
    }

    @Override
    public String protCte(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protCTe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTe>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String protCte400(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protCTe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTe>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String any(Element element) {
        return XMLUtils.elementToString(element);
    }

    @Override
    public String any400(Element element) {
        return XMLUtils.elementToString(element);
    }

    @Override
    public String protCteOs(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTeOS>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String protCteOs400(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protCTeOS xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protCTeOS>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String protGtve(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protGTVe>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String protGtve400(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace("<protGTVe xmlns=\"http://www.portalfiscal.inf.br/cte\">" + sw.toString().replace(" xmlns=\"http://www.portalfiscal.inf.br/cte\"", "") + "</protGTVe>");
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.RodoOS o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRodoOS(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCCeCTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCCeCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCECTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCECTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancCECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvEPECCTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvEPECCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvGTV o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvGTV(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvRegMultimodal o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvRegMultimodal(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvPrestDesacordo o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvPrestDesacordo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancPrestDesacordo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvIECTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvIECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancIECTe o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createEvCancIECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Rodo o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createRodo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aereo o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createAereo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aquav o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createAquav(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Duto o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createDuto(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Ferrov o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createFerrov(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Multimodal o) {
        return XMLUtils.toElement(CteObjectFactoryWrapperFactory.getInstance().getCte4ObjectFactory().createMultimodal(o), cteSend400Marshaller());
    }
}


