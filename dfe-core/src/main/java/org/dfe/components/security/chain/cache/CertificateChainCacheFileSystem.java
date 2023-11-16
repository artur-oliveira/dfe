package org.dfe.components.security.chain.cache;

import org.dfe.interfaces.security.CertificateChain;
import org.dfe.util.DateUtils;
import org.dfe.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

final class CertificateChainCacheFileSystem extends CertificateChainCacheFactory {

    String getFileName(CertificateChain chain) {
        return String.join(IOUtils.separator(), IOUtils.homeDir(), ".chain", chain.fileName());
    }

    @Override
    public byte[] getFromCache(CertificateChain certificateChain) throws IOException {
        File f = new File(getFileName(certificateChain));
        if (!f.exists()) return null;

        if (Duration.between(Objects.requireNonNull(IOUtils.creationDate(f)), DateUtils.now()).compareTo(Duration.ofDays(DAYS_IN_CACHE)) >= 0) {
            return null;
        }

        return IOUtils.readAllBytes(f);
    }

    @Override
    public void addToCache(CertificateChain certificateChain, byte[] bytes) throws IOException {
        IOUtils.write(getFileName(certificateChain), bytes);
    }
}
