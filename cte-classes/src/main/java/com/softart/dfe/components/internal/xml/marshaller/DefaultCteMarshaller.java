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

    @Override
    public String distributionCte(DistDFeInt data) {
        try {
            try (StringWriter sw = new StringWriter()) {
                CteContextFactory.getInstance().getCteDistributionContext().createMarshaller().marshal(new br.inf.portalfiscal.cte.distribution.ObjectFactory().createDistDFeInt(data), sw);
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
                CteContextFactory.getInstance().getCteDistributionContext().createMarshaller().marshal(new br.inf.portalfiscal.cte.distribution.ObjectFactory().createRetDistDFeInt(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createEventoCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetEventoCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createProcEventoCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createInutCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetInutCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createProcInutCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createConsSitCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsSitCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createEnviCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetEnviCte(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createCteProc(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createGTVe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetGTVe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createGTVeProc(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createCTeOS(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetCTeOS(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createCteOSProc(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createCteProc(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createConsReciCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsReciCTe(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createConsStatServCte(data), sw);
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
                CteContextFactory.getInstance().getCteSendContext().createMarshaller().marshal(new ObjectFactory().createRetConsStatServCte(data), sw);
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

