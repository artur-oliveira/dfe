package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import br.inf.portalfiscal.mdfe.distribution.DistDFeInt;
import br.inf.portalfiscal.mdfe.distribution.RetDistDFeInt;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.components.internal.xml.objectfactory.MdfeObjectFactoryWrapperFactory;
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

    Marshaller mdfeMarshaller() {
        try {
            return MdfeContextFactory.getInstance().getMdfeContext().createMarshaller();
        } catch (JAXBException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String rodo(Rodo data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRodo(data));
    }

    @Override
    public String aereo(Aereo data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createAereo(data));
    }

    @Override
    public String ferrov(Ferrov data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createFerrov(data));
    }

    @Override
    public String aquav(Aquav data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createAquav(data));
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
    public String sendDistributionOld(DistDFeInt data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeDistributionContext(), MdfeObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createDistDFeInt(data));
    }

    @Override
    public String returnDistributionOld(RetDistDFeInt data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeDistributionContext(), MdfeObjectFactoryWrapperFactory.getInstance().getDistributionObjectFactory().createRetDistDFeInt(data));
    }

    @Override
    public String returnDistribution(TRetDistDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetDistMDFe(data));
    }

    @Override
    public String returnEvent(TRetEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetEventoMDFe(data));
    }

    @Override
    public String returnQueryReceipt(TRetConsReciMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetConsReciMDFe(data));
    }

    @Override
    public String returnQuerySituation(TRetConsSitMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetConsSitMDFe(data));
    }

    @Override
    public String returnQueryUnclosed(TRetConsMDFeNaoEnc data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetConsMDFeNaoEnc(data));
    }

    @Override
    public String returnReception(TRetEnviMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetEnviMDFe(data));
    }

    @Override
    public String returnReceptionSync(TRetMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetMDFe(data));
    }

    @Override
    public String returnStatusService(TRetConsStatServ data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRetConsStatServMDFe(data));
    }

    @Override
    public String sendDistribution(TDistDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createDistMDFe(data));
    }

    @Override
    public String sendEvent(TEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEventoMDFe(data));
    }

    @Override
    public String procEvent(TProcEvento data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createProcEventoMDFe(data));
    }

    @Override
    public String sendQueryReceipt(TConsReciMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createConsReciMDFe(data));
    }

    @Override
    public String sendQuerySituation(TConsSitMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createConsSitMDFe(data));
    }

    @Override
    public String sendQueryUnclosed(TConsMDFeNaoEnc data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createConsMDFeNaoEnc(data));
    }

    @Override
    public String sendReception(TEnviMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEnviMDFe(data));
    }

    @Override
    public String sendReceptionSync(TMDFe data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createMDFe(data));
    }

    @Override
    public String procMdfe(TMdfeProc mdfeProc) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createMdfeProc(mdfeProc));
    }

    @Override
    public String sendStatusService(TConsStatServ data) {
        return XMLUtils.marshall(MdfeContextFactory.getInstance().getMdfeContext(), MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createConsStatServMDFe(data));
    }


    @Override
    public Element toElement(Rodo element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createRodo(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Aquav element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createAquav(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Aereo element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createAereo(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(Ferrov element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createFerrov(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvCancMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvCancMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvAlteracaoPagtoServMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvAlteracaoPagtoServMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvConfirmaServMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvConfirmaServMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvEncMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvEncMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvIncCondutorMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvIncCondutorMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvIncDFeMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvIncDFeMDFe(element), mdfeMarshaller());
    }

    @Override
    public Element toElement(EvPagtoOperMDFe element) {
        return XMLUtils.toElement(MdfeObjectFactoryWrapperFactory.getInstance().getObjectFactory().createEvPagtoOperMDFe(element), mdfeMarshaller());
    }
}

