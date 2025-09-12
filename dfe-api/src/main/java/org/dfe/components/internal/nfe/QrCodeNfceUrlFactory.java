package org.dfe.components.internal.nfe;

import org.dfe.interfaces.internal.nf.NfceQrCodeUrl;

public final class QrCodeNfceUrlFactory {
    private static volatile NfceQrCodeUrl registry;

    public static void configure(NfceQrCodeUrl customRegistry) {
        registry = customRegistry;
    }

    public static NfceQrCodeUrl getInstance() {
        if (registry == null) {
            synchronized (NfceQrCodeUrl.class) {
                if (registry == null) {
                    registry = new EnumNfceQrCodeUrl();
                }
            }
        }
        return registry;
    }
}

