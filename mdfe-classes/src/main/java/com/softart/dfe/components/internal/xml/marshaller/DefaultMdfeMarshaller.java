package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.mdfe.classes.*;
import com.softart.dfe.components.internal.xml.context.MdfeContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import com.softart.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import jakarta.xml.bind.JAXBException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

final class DefaultMdfeMarshaller extends MdfeMarshallerFactory {

    private final ObjectFactory fc = new ObjectFactory();

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

    public String returnDistribution(TRetDistDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetDistMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnEvent(TRetEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetEventoMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnQueryReceipt(TRetConsReciMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetConsReciMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnQuerySituation(TRetConsSitMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetConsSitMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnQueryUnclosed(TRetConsMDFeNaoEnc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetConsMDFeNaoEnc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnReception(TRetEnviMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetEnviMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnReceptionSync(TRetMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String returnStatusService(TRetConsStatServ data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createRetConsStatServMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendDistribution(TDistDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createDistMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendEvent(TEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createEventoMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String procEvent(TProcEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createProcEventoMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendQueryReceipt(TConsReciMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createConsReciMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendQuerySituation(TConsSitMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createConsSitMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendQueryUnclosed(TConsMDFeNaoEnc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createConsMDFeNaoEnc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendReception(TEnviMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createEnviMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendReceptionSync(TMDFe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String procMdfe(TMdfeProc mdfeProc) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createMdfeProc(mdfeProc), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    public String sendStatusService(TConsStatServ data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                MdfeContextFactory.getInstance().getMdfeContext().createMarshaller().marshal(fc.createConsStatServMDFe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }
}

