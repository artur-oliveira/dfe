package com.softart.dfe.components.internal.xml.unmarshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.xml.UnmarshallException;
import com.softart.dfe.util.XMLUtils;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Element;

import java.io.StringReader;

final class DefaultMdfeUnmarshaller extends MdfeUnmarshallerFactory {

    private final ObjectFactory fc = new ObjectFactory();

    @Override
    public JAXBElement<TDistDFe> sendDistribution(String xml) {
        return fc.createDistMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TDistDFe.class, xml));
    }

    @Override
    public JAXBElement<TEvento> sendEvent(String xml) {
        return fc.createEventoMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TEvento.class, xml));
    }

    @Override
    public JAXBElement<TConsReciMDFe> sendQueryReceipt(String xml) {
        return fc.createConsReciMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TConsReciMDFe.class, xml));
    }

    @Override
    public JAXBElement<TConsSitMDFe> sendQuerySituation(String xml) {
        return fc.createConsSitMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TConsSitMDFe.class, xml));
    }

    @Override
    public JAXBElement<TConsMDFeNaoEnc> sendQueryUnclosed(String xml) {
        return fc.createConsMDFeNaoEnc(XMLUtils.getJaxbElementValue(any(xml).getValue(), TConsMDFeNaoEnc.class, xml));
    }

    @Override
    public JAXBElement<TEnviMDFe> sendReception(String xml) {
        return fc.createEnviMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TEnviMDFe.class, xml));
    }

    @Override
    public JAXBElement<TMDFe> sendReceptionSync(String xml) {
        return fc.createMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TMDFe.class, xml));
    }

    @Override
    public JAXBElement<TConsStatServ> sendStatusService(String xml) {
        return fc.createConsStatServMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TConsStatServ.class, xml));
    }

    @Override
    public JAXBElement<TRetEvento> returnEvent(String xml) {
        return fc.createRetEventoMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TRetEvento.class, xml));
    }

    @Override
    public JAXBElement<TRetEvento> returnEvent(Element el) {
        return returnEvent(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<TProtMDFe> protMdfe(String xml) {
        return fc.createProtMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), TProtMDFe.class, xml));
    }

    @Override
    public JAXBElement<TProtMDFe> protMdfe(Element el) {
        return protMdfe("<protMDFe xmlns=\"http://www.portalfiscal.inf.br/mdfe\">" + MdfeMarshallerFactory.getInstance().any(el) + "</protMDFe>");
    }

    @Override
    public JAXBElement<EvCancMDFe> evCancMDFe(Element el) {
        return evCancMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvCancMDFe> evCancMDFe(String xml) {
        return fc.createEvCancMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvCancMDFe.class, xml));
    }


    @Override
    public JAXBElement<?> any(Element element) {
        return any(MdfeMarshallerFactory.getInstance().any(element));
    }

    @Override
    public JAXBElement<?> any(String xml) {
        try {
            try (StringReader reader = new StringReader(xml)) {
                Object o = MdfeContextFactory.getInstance().getMdfeContext().createUnmarshaller().unmarshal(reader);
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
    public JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(Element el) {
        return evAlteracaoPagtoServMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvAlteracaoPagtoServMDFe> evAlteracaoPagtoServMDFe(String xml) {
        return fc.createEvAlteracaoPagtoServMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvAlteracaoPagtoServMDFe.class, xml));
    }

    @Override
    public JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(Element el) {
        return evConfirmaServMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvConfirmaServMDFe> evConfirmaServMDFe(String xml) {
        return fc.createEvConfirmaServMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvConfirmaServMDFe.class, xml));
    }

    @Override
    public JAXBElement<EvEncMDFe> evEncMDFe(Element el) {
        return evEncMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvEncMDFe> evEncMDFe(String xml) {
        return fc.createEvEncMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvEncMDFe.class, xml));
    }

    @Override
    public JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(Element el) {
        return evIncCondutorMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvIncCondutorMDFe> evIncCondutorMDFe(String xml) {
        return fc.createEvIncCondutorMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvIncCondutorMDFe.class, xml));
    }

    @Override
    public JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(Element el) {
        return evIncDFeMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvIncDFeMDFe> evIncDFeMDFe(String xml) {
        return fc.createEvIncDFeMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvIncDFeMDFe.class, xml));
    }

    @Override
    public JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(Element el) {
        return evPagtoOperMDFe(MdfeMarshallerFactory.getInstance().any(el));
    }

    @Override
    public JAXBElement<EvPagtoOperMDFe> evPagtoOperMDFe(String xml) {
        return fc.createEvPagtoOperMDFe(XMLUtils.getJaxbElementValue(any(xml).getValue(), EvPagtoOperMDFe.class, xml));
    }
}

