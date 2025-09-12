package org.dfe.components.internal.xml.objectfactory;

import br.inf.portalfiscal.nfe.send.*;
import jakarta.xml.bind.JAXBElement;
import lombok.Getter;

@Getter
final class DefaultNfObjectFactoryWrapper extends NfObjectFactoryWrapperFactory {

    private final br.inf.portalfiscal.nfe.send.ObjectFactory sendNfeObjectFactory = new br.inf.portalfiscal.nfe.send.ObjectFactory();
    private final br.inf.portalfiscal.nfe.event_generic.ObjectFactory eventNfeObjectFactory = new br.inf.portalfiscal.nfe.event_generic.ObjectFactory();
    private final br.inf.portalfiscal.nfe.gtin.ObjectFactory gtinNfeObjectFactory = new br.inf.portalfiscal.nfe.gtin.ObjectFactory();
    private final br.inf.portalfiscal.nfe.distribution.ObjectFactory distributionNfeObjectFactory = new br.inf.portalfiscal.nfe.distribution.ObjectFactory();

    @Override
    public TNfeProc nfeProc() {
        return getSendNfeObjectFactory().createTNfeProc();
    }

    @Override
    public TNFe.InfNFe.Det.Imposto imposto() {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImposto();
    }

    @Override
    public JAXBElement<TConsStatServ> consStatServ(TConsStatServ o) {
        return getSendNfeObjectFactory().createConsStatServ(o);
    }

    @Override
    public JAXBElement<String> vTotTrib(String o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoVTotTrib(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.ICMS> icms(TNFe.InfNFe.Det.Imposto.ICMS o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoICMS(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.PIS> pis(TNFe.InfNFe.Det.Imposto.PIS o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoPIS(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.PISST> pisst(TNFe.InfNFe.Det.Imposto.PISST o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoPISST(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.COFINS> cofins(TNFe.InfNFe.Det.Imposto.COFINS o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoCOFINS(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.COFINSST> cofinsst(TNFe.InfNFe.Det.Imposto.COFINSST o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoCOFINSST(o);
    }

    @Override
    public JAXBElement<TIpi> ipi(TIpi o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoIPI(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.II> ii(TNFe.InfNFe.Det.Imposto.II o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoII(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.ISSQN> issqn(TNFe.InfNFe.Det.Imposto.ISSQN o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoISSQN(o);
    }

    @Override
    public JAXBElement<TNFe.InfNFe.Det.Imposto.ICMSUFDest> icmsufdest(TNFe.InfNFe.Det.Imposto.ICMSUFDest o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoICMSUFDest(o);
    }

    @Override
    public JAXBElement<TIS> is(TIS o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoIS(o);
    }

    @Override
    public JAXBElement<TTribNFe> ibsCbs(TTribNFe o) {
        return getSendNfeObjectFactory().createTNFeInfNFeDetImpostoIBSCBS(o);
    }
}
