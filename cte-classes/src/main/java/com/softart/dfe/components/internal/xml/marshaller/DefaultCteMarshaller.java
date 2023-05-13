package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Element;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

final class DefaultCteMarshaller extends CteMarshallerFactory {

    private final br.inf.portalfiscal.cte.distribution.ObjectFactory distributionObjectFactory = new br.inf.portalfiscal.cte.distribution.ObjectFactory();
    private final br.inf.portalfiscal.cte.send.ObjectFactory objectFactory = new br.inf.portalfiscal.cte.send.ObjectFactory();
    private final br.inf.portalfiscal.cte.send400.ObjectFactory cte4O0bjectFactory = new br.inf.portalfiscal.cte.send400.ObjectFactory();

    Marshaller cteSendMarshaller() {
        try {
            return CteContextFactory.getInstance().getCteSendContext().createMarshaller();
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

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

    String marshallSend(JAXBElement<?> el) {
        return XMLUtils.marshall(CteContextFactory.getInstance().getCteSendContext(), el);
    }

    String marshallSend400(JAXBElement<?> el) {
        return XMLUtils.marshall(CteContextFactory.getInstance().getCte400SendContext(), el);
    }

    @Override
    public String distributionCte(DistDFeInt data) {
        return marshallDistribution(distributionObjectFactory.createDistDFeInt(data));
    }

    @Override
    public String returnDistributionCte(RetDistDFeInt data) {
        return marshallDistribution(distributionObjectFactory.createRetDistDFeInt(data));
    }

    @Override
    public String eventCte(TEvento data) {
        return marshallSend(objectFactory.createEventoCTe(data));
    }

    @Override
    public String returnEventCte(TRetEvento data) {
        return marshallSend(objectFactory.createRetEventoCTe(data));
    }

    @Override
    public String procEventCte(TProcEvento data) {
        return marshallSend(objectFactory.createProcEventoCTe(data));
    }

    @Override
    public String inutilizationCte(TInutCTe data) {
        return marshallSend(objectFactory.createInutCTe(data));
    }

    @Override
    public String returnInutilizationCte(TRetInutCTe data) {
        return marshallSend(objectFactory.createRetInutCTe(data));
    }

    @Override
    public String procInutilizationCte(TProcInutCTe data) {
        return marshallSend(objectFactory.createProcInutCTe(data));
    }

    @Override
    public String querySituationCte(TConsSitCTe data) {
        return marshallSend(objectFactory.createConsSitCTe(data));
    }

    @Override
    public String returnQuerySituationCte(TRetConsSitCTe data) {
        return marshallSend(objectFactory.createRetConsSitCTe(data));
    }

    @Override
    public String receptionCte(TEnviCTe data) {
        return marshallSend(objectFactory.createEnviCTe(data));
    }

    @Override
    public String returnReceptionCte(TRetEnviCTe data) {
        return marshallSend(objectFactory.createRetEnviCte(data));
    }

    @Override
    public String cteProc(TCteProc data) {
        return marshallSend(objectFactory.createCteProc(data));
    }

    @Override
    public String receptionGtve(TGTVe data) {
        return marshallSend(objectFactory.createGTVe(data));
    }


    @Override
    public String returnReceptionGtve(TRetGTVe data) {
        return marshallSend(objectFactory.createRetGTVe(data));
    }

    @Override
    public String gtveProc(TGTVeProc data) {
        return marshallSend(objectFactory.createGTVeProc(data));
    }

    @Override
    public String receptionCteOs(TCTeOS data) {
        return marshallSend(objectFactory.createCTeOS(data));
    }

    @Override
    public String returnReceptionCteOs(TRetCTeOS data) {
        return marshallSend(objectFactory.createRetCTeOS(data));
    }

    @Override
    public String cteOsProc(TCteOSProc data) {
        return marshallSend(objectFactory.createCteOSProc(data));
    }

    @Override
    public String receptionCteSync(TCTe data) {
        return marshallSend(objectFactory.createCTe(data));
    }

    @Override
    public String returnReceptionCteSync(TRetCTe data) {
        return marshallSend(objectFactory.createRetCTe(data));
    }

    @Override
    public String cteProcSync(TCteProc data) {
        return marshallSend(objectFactory.createCteProc(data));
    }

    @Override
    public String queryReceipt(TConsReciCTe data) {
        return marshallSend(objectFactory.createConsReciCTe(data));
    }

    @Override
    public String returnQueryReceipt(TRetConsReciCTe data) {
        return marshallSend(objectFactory.createRetConsReciCTe(data));
    }

    @Override
    public String statusService(TConsStatServ data) {
        return marshallSend(objectFactory.createConsStatServCte(data));
    }

    @Override
    public String returnStatusService(TRetConsStatServ data) {
        return marshallSend(objectFactory.createRetConsStatServCte(data));
    }


    @Override
    public String eventCte(br.inf.portalfiscal.cte.send400.TEvento data) {
        return marshallSend400(cte4O0bjectFactory.createEventoCTe(data));
    }

    @Override
    public String returnEventCte(br.inf.portalfiscal.cte.send400.TRetEvento data) {
        return marshallSend400(cte4O0bjectFactory.createRetEventoCTe(data));
    }

    @Override
    public String procEventCte(br.inf.portalfiscal.cte.send400.TProcEvento data) {
        return marshallSend400(cte4O0bjectFactory.createProcEventoCTe(data));
    }

    @Override
    public String inutilizationCte(br.inf.portalfiscal.cte.send400.TInutCTe data) {
        return marshallSend400(cte4O0bjectFactory.createInutCTe(data));
    }

    @Override
    public String returnInutilizationCte(br.inf.portalfiscal.cte.send400.TRetInutCTe data) {
        return marshallSend400(cte4O0bjectFactory.createRetInutCTe(data));
    }

    @Override
    public String procInutilizationCte(br.inf.portalfiscal.cte.send400.TProcInutCTe data) {
        return marshallSend400(cte4O0bjectFactory.createProcInutCTe(data));
    }

    @Override
    public String querySituationCte(br.inf.portalfiscal.cte.send400.TConsSitCTe data) {
        return marshallSend400(cte4O0bjectFactory.createConsSitCTe(data));
    }

    @Override
    public String returnQuerySituationCte(br.inf.portalfiscal.cte.send400.TRetConsSitCTe data) {
        return marshallSend400(cte4O0bjectFactory.createRetConsSitCTe(data));
    }

    @Override
    public String cteProc(br.inf.portalfiscal.cte.send400.TCteProc data) {
        return marshallSend400(cte4O0bjectFactory.createCteProc(data));
    }

    @Override
    public String receptionGtve(br.inf.portalfiscal.cte.send400.TGTVe data) {
        return marshallSend400(cte4O0bjectFactory.createGTVe(data));
    }


    @Override
    public String returnReceptionGtve(br.inf.portalfiscal.cte.send400.TRetGTVe data) {
        return marshallSend400(cte4O0bjectFactory.createRetGTVe(data));
    }

    @Override
    public String gtveProc(br.inf.portalfiscal.cte.send400.TGTVeProc data) {
        return marshallSend400(cte4O0bjectFactory.createGTVeProc(data));
    }

    @Override
    public String receptionCteOs(br.inf.portalfiscal.cte.send400.TCTeOS data) {
        return marshallSend400(cte4O0bjectFactory.createCTeOS(data));
    }

    @Override
    public String returnReceptionCteOs(br.inf.portalfiscal.cte.send400.TRetCTeOS data) {
        return marshallSend400(cte4O0bjectFactory.createRetCTeOS(data));
    }

    @Override
    public String cteOsProc(br.inf.portalfiscal.cte.send400.TCteOSProc data) {
        return marshallSend400(cte4O0bjectFactory.createCteOSProc(data));
    }

    @Override
    public String receptionCteSync(br.inf.portalfiscal.cte.send400.TCTe data) {
        return marshallSend400(cte4O0bjectFactory.createCTe(data));
    }

    @Override
    public String returnReceptionCteSync(br.inf.portalfiscal.cte.send400.TRetCTe data) {
        return marshallSend400(cte4O0bjectFactory.createRetCTe(data));
    }

    @Override
    public String cteProcSync(br.inf.portalfiscal.cte.send400.TCteProc data) {
        return marshallSend400(cte4O0bjectFactory.createCteProc(data));
    }

    @Override
    public String statusService(br.inf.portalfiscal.cte.send400.TConsStatServ data) {
        return marshallSend400(cte4O0bjectFactory.createConsStatServCTe(data));
    }

    @Override
    public String returnStatusService(br.inf.portalfiscal.cte.send400.TRetConsStatServ data) {
        return marshallSend400(cte4O0bjectFactory.createRetConsStatServCTe(data));
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
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String any400(Element element) {
        try {
            try (StringWriter sw = new StringWriter()) {
                XMLUtils.getTransformer().transform(new DOMSource(element), new StreamResult(sw));
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (Exception e) {
            throw new MarshallException(e);
        }
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
    public Element toElement(EvCancCTe o) {
        return XMLUtils.toElement(objectFactory.createEvCancCTe(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(RodoOS o) {
        return XMLUtils.toElement(objectFactory.createRodoOS(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvCCeCTe o) {
        return XMLUtils.toElement(objectFactory.createEvCCeCTe(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvCECTe o) {
        return XMLUtils.toElement(objectFactory.createEvCECTe(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvCancCECTe o) {
        return XMLUtils.toElement(objectFactory.createEvCancCECTe(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvEPECCTe o) {
        return XMLUtils.toElement(objectFactory.createEvEPECCTe(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvGTV o) {
        return XMLUtils.toElement(objectFactory.createEvGTV(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvRegMultimodal o) {
        return XMLUtils.toElement(objectFactory.createEvRegMultimodal(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(EvPrestDesacordo o) {
        return XMLUtils.toElement(objectFactory.createEvPrestDesacordo(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Rodo o) {
        return XMLUtils.toElement(objectFactory.createRodo(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Aereo o) {
        return XMLUtils.toElement(objectFactory.createAereo(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Aquav o) {
        return XMLUtils.toElement(objectFactory.createAquav(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Duto o) {
        return XMLUtils.toElement(objectFactory.createDuto(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Ferrov o) {
        return XMLUtils.toElement(objectFactory.createFerrov(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(Multimodal o) {
        return XMLUtils.toElement(objectFactory.createMultimodal(o), cteSendMarshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCancCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.RodoOS o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createRodoOS(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCCeCTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCCeCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCECTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancCECTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCancCECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvEPECCTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvEPECCTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvGTV o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvGTV(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvRegMultimodal o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvRegMultimodal(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvPrestDesacordo o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvPrestDesacordo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancPrestDesacordo o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCancPrestDesacordo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvIECTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvIECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.EvCancIECTe o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createEvCancIECTe(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Rodo o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createRodo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aereo o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createAereo(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Aquav o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createAquav(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Duto o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createDuto(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Ferrov o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createFerrov(o), cteSend400Marshaller());
    }

    @Override
    public Element toElement(br.inf.portalfiscal.cte.send400.Multimodal o) {
        return XMLUtils.toElement(cte4O0bjectFactory.createMultimodal(o), cteSend400Marshaller());
    }
}


