package org.dfe.interfaces.xml.objectfactory;

import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;

public interface NfObjectFactoryWrapper {
    br.inf.portalfiscal.nfe.send.ObjectFactory getSendNfeObjectFactory();

    br.inf.portalfiscal.nfe.event_generic.ObjectFactory getEventNfeObjectFactory();

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

    JAXBElement<TIS> is(TIS o);

    JAXBElement<TTribNFe> ibsCbs(TTribNFe o);
}
