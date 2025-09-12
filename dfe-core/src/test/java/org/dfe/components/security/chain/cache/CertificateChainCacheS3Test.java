package org.dfe.components.security.chain.cache;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CertificateChainCacheS3Test {

    @Test
    void testCanUseCacheWithDisabledDayCache() {
        System.setProperty("org.dfe.chain.cache.s3.bucket", "teste");
        System.setProperty("org.dfe.chain.cache.s3.enable-day-cache", "false");
        CertificateChainCacheS3 certificateChainCacheS3 = new CertificateChainCacheS3();
        assertTrue(certificateChainCacheS3.canUseCache(LocalDate.of(2023, 1, 1).atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC)));
    }

    @Test
    void testCanUseCacheWithEnabledDayCache() {
        System.setProperty("org.dfe.chain.cache.s3.bucket", "teste");
        System.setProperty("org.dfe.chain.cache.s3.enable-day-cache", "true");
        CertificateChainCacheS3 certificateChainCacheS3 = new CertificateChainCacheS3();
        assertTrue(certificateChainCacheS3.canUseCache(LocalDate.now().minusDays(13).atTime(LocalTime.now()).toInstant(ZoneOffset.ofHours(-3))));
    }
}