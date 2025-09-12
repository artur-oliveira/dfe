package org.dfe.components.internal.nfe;

import org.dfe.interfaces.internal.nf.NfceQueryUrl;

public final class QueryNfceUrlFactory {
    private static volatile NfceQueryUrl registry;

    public static void configure(NfceQueryUrl customRegistry) {
        registry = customRegistry;
    }

    public static NfceQueryUrl getInstance() {
        if (registry == null) {
            synchronized (NfceQueryUrl.class) {
                if (registry == null) {
                    registry = new EnumNfceQueryUrl();
                }
            }
        }
        return registry;
    }
}

