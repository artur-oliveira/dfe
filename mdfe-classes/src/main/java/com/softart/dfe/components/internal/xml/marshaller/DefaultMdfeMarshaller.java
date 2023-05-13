package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Element;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

final class DefaultMdfeMarshaller extends MdfeMarshallerFactory {

    private final ObjectFactory fc = new ObjectFactory();

    Marshaller mdfeMarshaller() {
        try {
            return MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String rodo(Rodo data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRodo(data));
    }

    @Override
    public String aereo(Aereo data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createAereo(data));
    }

    @Override
    public String ferrov(Ferrov data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createFerrov(data));
    }

    @Override
    public String aquav(Aquav data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createAquav(data));
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
    public String returnDistribution(TRetDistDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetDistMDFe(data));
    }

    @Override
    public String returnEvent(TRetEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetEventoMDFe(data));
    }

    @Override
    public String returnQueryReceipt(TRetConsReciMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetConsReciMDFe(data));
    }

    @Override
    public String returnQuerySituation(TRetConsSitMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetConsSitMDFe(data));
    }

    @Override
    public String returnQueryUnclosed(TRetConsMDFeNaoEnc data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetConsMDFeNaoEnc(data));
    }

    @Override
    public String returnReception(TRetEnviMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetEnviMDFe(data));
    }

    @Override
    public String returnReceptionSync(TRetMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetMDFe(data));
    }

    @Override
    public String returnStatusService(TRetConsStatServ data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createRetConsStatServMDFe(data));
    }

    @Override
    public String sendDistribution(TDistDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createDistMDFe(data));
    }

    @Override
    public String sendEvent(TEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createEventoMDFe(data));
    }

    @Override
    public String procEvent(TProcEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createProcEventoMDFe(data));
    }

    @Override
    public String sendQueryReceipt(TConsReciMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createConsReciMDFe(data));
    }

    @Override
    public String sendQuerySituation(TConsSitMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createConsSitMDFe(data));
    }

    @Override
    public String sendQueryUnclosed(TConsMDFeNaoEnc data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createConsMDFeNaoEnc(data));
    }

    @Override
    public String sendReception(TEnviMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createEnviMDFe(data));
    }

    @Override
    public String sendReceptionSync(TMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createMDFe(data));
    }

    @Override
    public String procMdfe(TMdfeProc mdfeProc) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createMdfeProc(mdfeProc));
    }

    @Override
    public String sendStatusService(TConsStatServ data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), fc.createConsStatServMDFe(data));
    }


    @Override
    public Element toElement(Rodo element) {
        return XMLUtils.toElement(fc.createRodo(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Aquav element) {
        return XMLUtils.toElement(fc.createAquav(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Aereo element) {
        return XMLUtils.toElement(fc.createAereo(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Ferrov element) {
        return XMLUtils.toElement(fc.createFerrov(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvCancMDFe element) {
        return XMLUtils.toElement(fc.createEvCancMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvAlteracaoPagtoServMDFe element) {
        return XMLUtils.toElement(fc.createEvAlteracaoPagtoServMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvConfirmaServMDFe element) {
        return XMLUtils.toElement(fc.createEvConfirmaServMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvEncMDFe element) {
        return XMLUtils.toElement(fc.createEvEncMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvIncCondutorMDFe element) {
        return XMLUtils.toElement(fc.createEvIncCondutorMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvIncDFeMDFe element) {
        return XMLUtils.toElement(fc.createEvIncDFeMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvPagtoOperMDFe element) {
        return XMLUtils.toElement(fc.createEvPagtoOperMDFe(element), mdfeMarshaller());
    }
}

