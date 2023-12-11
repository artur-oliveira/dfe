package org.dfe.components.security.chain.cache;

import org.dfe.util.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CertificateChainCacheS3Test {

    @Test
    void testCanUseCacheWithDisabledDayCache() {
        System.setProperty("org.dfe.chain.cache.s3.bucket", "teste");
        System.setProperty("org.dfe.chain.cache.s3.enable-day-cache", "false");
        CertificateChainCacheS3 certificateChainCacheS3 = new CertificateChainCacheS3();
        assertTrue(certificateChainCacheS3.canUseCache(DateUtils.date(LocalDateTime.of(LocalDate.of(2023, 1, 1), LocalDateTime.now().toLocalTime()))));
    }

    @Test
    void testCanUseCacheWithEnabledDayCache() {
        System.setProperty("org.dfe.chain.cache.s3.bucket", "teste");
        System.setProperty("org.dfe.chain.cache.s3.enable-day-cache", "true");
        CertificateChainCacheS3 certificateChainCacheS3 = new CertificateChainCacheS3();
        assertTrue(certificateChainCacheS3.canUseCache(DateUtils.date(LocalDateTime.of(LocalDate.now().minusDays(13), LocalDateTime.now().toLocalTime()))));
    }
}