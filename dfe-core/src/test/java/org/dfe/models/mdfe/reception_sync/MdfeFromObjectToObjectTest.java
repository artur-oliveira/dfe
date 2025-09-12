package org.dfe.models.mdfe.reception_sync;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import org.dfe.util.ClassUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MdfeFromObjectToObjectTest {
    @Test
    void testRodoModal() throws Exception {
        TMDFe.InfMDFe.InfModal infModal = new TMDFe.InfMDFe.InfModal();
        infModal.setAny(MdfeMarshallerFactory.getInstance().toElement(Mdfe.InfMDFe.InfModal.Rodo
                .builder()
                .infANTT(Mdfe.InfMDFe.InfModal.Rodo.InfANTT.builder().rntrc(null).build())
                .veicTracao(Mdfe.InfMDFe.InfModal.Rodo.VeicTracao.builder().placa("ABC1234").build())
                .build()
                .toObject()));
        Method method = infModal.getAny().getClass().getDeclaredMethod("setName", String.class, String.class);
        ClassUtils.set(method, infModal.getAny(), "http://www.w3.org/2000/09/xmldsig#", "rodo");
        Object el = MdfeUnmarshallerFactory.getInstance().any(infModal.getAny());
        Assertions.assertNotNull(el);
    }
}
