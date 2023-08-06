package com.softart.dfe.interfaces.xml.objectfactory;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TIpi;
import br.inf.portalfiscal.nfe.send.TNFe;
import br.inf.portalfiscal.nfe.send.TNfeProc;
import jakarta.xml.bind.JAXBElement;

public interface NfObjectFactoryWrapper {
    br.inf.portalfiscal.nfe.send.ObjectFactory getSendNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_generic.ObjectFactory getEventNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_cancel.ObjectFactory getCancelNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory getSubstituteCancelNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory getCorrectionLetterNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_epec.ObjectFactory getEpecNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory getManifestationNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory getInterestedActorNfeObjectFactory();

    br.inf.portalfiscal.nfe.gtin.ObjectFactory getGtinNfeObjectFactory();

    br.inf.portalfiscal.nfe.distribution.ObjectFactory getDistributionNfeObjectFactory();

    TNfeProc nfeProc();

    TNFe.InfNFe.Det.Imposto imposto();

    JAXBElement<TConsStatServ> consStatServ(TConsStatServ o);

    JAXBElement<String> vTotTrib(String o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.ICMS> icms(TNFe.InfNFe.Det.Imposto.ICMS o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.PIS> pis(TNFe.InfNFe.Det.Imposto.PIS o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.PISST> pisst(TNFe.InfNFe.Det.Imposto.PISST o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.COFINS> cofins(TNFe.InfNFe.Det.Imposto.COFINS o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.COFINSST> cofinsst(TNFe.InfNFe.Det.Imposto.COFINSST o);

    JAXBElement<TIpi> ipi(TIpi o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.II> ii(TNFe.InfNFe.Det.Imposto.II o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.ISSQN> issqn(TNFe.InfNFe.Det.Imposto.ISSQN o);

    JAXBElement<TNFe.InfNFe.Det.Imposto.ICMSUFDest> icmsufdest(TNFe.InfNFe.Det.Imposto.ICMSUFDest o);
}
