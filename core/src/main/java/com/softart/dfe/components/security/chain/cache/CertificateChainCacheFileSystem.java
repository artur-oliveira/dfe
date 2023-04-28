package com.softart.dfe.components.security.chain.cache;

import com.softart.dfe.interfaces.security.CertificateChain;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

final class CertificateChainCacheFileSystem extends CertificateChainCacheFactory {
    @Override
    public byte[] getFromCache(CertificateChain certificateChain) throws IOException {
        File f = new File(certificateChain.fileName());
        if (!f.exists()) return null;

        if (Duration.between(Objects.requireNonNull(IOUtils.creationDate(f)), DateUtils.now()).compareTo(Duration.ofDays(DAYS_IN_CACHE)) >= 0) {
            return null;
        }

        return IOUtils.readAllBytes(f);
    }

    @Override
    public void addToCache(CertificateChain generate, byte[] bytes) throws IOException {
        IOUtils.write(generate.fileName(), bytes);
    }
}
