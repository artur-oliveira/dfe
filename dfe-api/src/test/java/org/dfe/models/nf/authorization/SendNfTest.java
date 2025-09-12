package org.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.*;
import org.dfe.util.StubsClassComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SendNfTest {

    @Test
    void testIfNotNewFields() {
        Assertions.assertTrue(StubsClassComparator.compare(SendNf.class, TEnviNFe.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.ICMS.class, TNFe.InfNFe.Det.Imposto.ICMS.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.IPI.class, TIpi.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.II.class, TNFe.InfNFe.Det.Imposto.II.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.ISSQN.class, TNFe.InfNFe.Det.Imposto.ISSQN.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.PIS.class, TNFe.InfNFe.Det.Imposto.PIS.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.PISST.class, TNFe.InfNFe.Det.Imposto.PISST.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.COFINS.class, TNFe.InfNFe.Det.Imposto.COFINS.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.COFINSST.class, TNFe.InfNFe.Det.Imposto.COFINSST.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.ICMSUFDest.class, TNFe.InfNFe.Det.Imposto.ICMSUFDest.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.IS.class, TIS.class, true, true).isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Nf.InfNFe.Det.Imposto.TTribNFe.class, TTribNFe.class, true, true).isEmpty());
    }
}