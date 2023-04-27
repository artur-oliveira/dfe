package com.softart.dfe.components.internal.xml.marshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.distribution.RetDistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.context.CteContextFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.util.XMLStringUtils;
import com.softart.dfe.util.XMLUtils;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

final class DefaultCteMarshaller extends CteMarshallerFactory {

    private final br.inf.portalfiscal.cte.distribution.ObjectFactory distributionObjectFactory = new br.inf.portalfiscal.cte.distribution.ObjectFactory();
    private final br.inf.portalfiscal.cte.send.ObjectFactory objectFactory = new br.inf.portalfiscal.cte.send.ObjectFactory();

    @Override
    public String distributionCte(DistDFeInt data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteDistributionContext().createMarshaller().marshal(distributionObjectFactory.createDistDFeInt(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnDistributionCte(RetDistDFeInt data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteDistributionContext().createMarshaller().marshal(distributionObjectFactory.createRetDistDFeInt(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String eventCte(TEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createEventoCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnEventCte(TRetEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetEventoCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procEventCte(TProcEvento data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createProcEventoCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String inutilizationCte(TInutCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createInutCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnInutilizationCte(TRetInutCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetInutCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String procInutilizationCte(TProcInutCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createProcInutCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String querySituationCte(TConsSitCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createConsSitCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQuerySituationCte(TRetConsSitCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetConsSitCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String receptionCte(TEnviCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createEnviCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnReceptionCte(TRetEnviCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetEnviCte(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String cteProc(TCteProc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createCteProc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String receptionGtve(TGTVe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createGTVe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }


    @Override
    public String returnReceptionGtve(TRetGTVe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetGTVe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String gtveProc(TGTVeProc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createGTVeProc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String receptionCteOs(TCTeOS data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createCTeOS(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnReceptionCteOs(TRetCTeOS data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetCTeOS(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String cteOsProc(TCteOSProc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createCteOSProc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String receptionCteSync(TCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnReceptionCteSync(TRetCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String cteProcSync(TCteProc data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createCteProc(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String queryReceipt(TConsReciCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createConsReciCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnQueryReceipt(TRetConsReciCTe data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetConsReciCTe(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String statusService(TConsStatServ data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createConsStatServCte(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
    }

    @Override
    public String returnStatusService(TRetConsStatServ data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(objectFactory.createRetConsStatServCte(data), sw);
                return XMLStringUtils.cleanNamespace(sw.toString());
            }
        } catch (JAXBException | IOException e) {
            throw new MarshallException(e);
        }
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
}

