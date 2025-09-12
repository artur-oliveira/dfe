package org.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.*;
import org.dfe.util.StubsClassComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MdfeTest {
    @Test
    void testIfNotNewFields() {
        Assertions.assertTrue(StubsClassComparator.compare(Mdfe.class, TMDFe.class, true, true, "any", "infPAA", "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Mdfe.InfMDFe.InfModal.Aereo.class, Aereo.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Mdfe.InfMDFe.InfModal.Aquav.class, Aquav.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Mdfe.InfMDFe.InfModal.Ferrov.class, Ferrov.class, true, true, "signature", "content", "hashCSRT").isEmpty());
        Assertions.assertTrue(StubsClassComparator.compare(Mdfe.InfMDFe.InfModal.Rodo.class, Rodo.class, true, true, "signature", "content", "hashCSRT").isEmpty());
    }
}