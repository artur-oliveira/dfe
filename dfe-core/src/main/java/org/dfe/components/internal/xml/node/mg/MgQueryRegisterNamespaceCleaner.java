package org.dfe.components.internal.xml.node.mg;

import org.dfe.interfaces.xml.XMLNodeCleaner;
import org.w3c.dom.Node;

public final class MgQueryRegisterNamespaceCleaner implements XMLNodeCleaner {

    private MgQueryRegisterNamespaceCleaner() {
    }

    public static XMLNodeCleaner getInstance() {
        return Holder.MG_CLEANER;
    }

    @Override
    public void clean(Node node) {
        // TODO: Corrigir webservice de consulta cadastro em minas gerais da forma correta
    }

    private static final class Holder {
        static final XMLNodeCleaner MG_CLEANER = new MgQueryRegisterNamespaceCleaner();
    }


}
