package com.softart.dfe.interfaces.xml.unmarshaller;

import br.inf.portalfiscal.cte.distribution.DistDFeInt;
import br.inf.portalfiscal.cte.send.*;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

public interface CteUnmarshaller {
    JAXBElement<DistDFeInt> distributionCte(String xml);

    JAXBElement<TEvento> eventCte(String xml);

    JAXBElement<TInutCTe> inutCte(String xml);

    JAXBElement<TConsSitCTe> querySituationCte(String xml);

    JAXBElement<TEnviCTe> receptionCte(String xml);

    JAXBElement<TGTVe> receptionGtve(String xml);

    JAXBElement<TCTeOS> receptionCteOs(String xml);

    JAXBElement<TCTe> receptionCteSync(String xml);

    JAXBElement<TConsReciCTe> queryReceipt(String xml);

    JAXBElement<TConsStatServ> statusService(String xml);

    JAXBElement<TProtCTe> protCTe(Element element);

    JAXBElement<?> any(Element element);

    JAXBElement<EvCancCTe> evCancCTe(Element element);

    JAXBElement<EvCancCECTe> evCancCECTe(Element element);

    JAXBElement<EvCCeCTe> evCCeCTe(Element element);

    JAXBElement<EvCECTe> evCECTe(Element element);

    JAXBElement<EvEPECCTe> evEPECCTe(Element element);

    JAXBElement<EvGTV> evGTV(Element element);

    JAXBElement<EvPrestDesacordo> evPrestDesacordo(Element element);

    JAXBElement<EvRegMultimodal> evRegMultimodal(Element element);

    Element toElement(EvCancCTe o) throws JAXBException;

    Element toElement(RodoOS o) throws JAXBException;

    Element toElement(EvCCeCTe o) throws JAXBException;

    Element toElement(EvCECTe o) throws JAXBException;

    Element toElement(EvCancCECTe o) throws JAXBException;

    Element toElement(EvEPECCTe o) throws JAXBException;

    Element toElement(EvGTV o) throws JAXBException;

    Element toElement(EvRegMultimodal o) throws JAXBException;

    Element toElement(EvPrestDesacordo o) throws JAXBException;

    Element toElement(Rodo o) throws JAXBException;

    Element toElement(Aereo o) throws JAXBException;

    Element toElement(Aquav o) throws JAXBException;

    Element toElement(Duto o) throws JAXBException;

    Element toElement(Ferrov o) throws JAXBException;

    Element toElement(Multimodal o) throws JAXBException;

    JAXBElement<TProtCTeOS> protCTeOS(Element element);

    JAXBElement<TProtGTVe> protGTVe(Element element);

    JAXBElement<TEnviCTe> enviCte(String xml);
}
