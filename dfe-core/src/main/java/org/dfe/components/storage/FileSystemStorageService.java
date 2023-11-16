package org.dfe.components.storage;

import org.dfe.interfaces.internal.StorageKey;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.models.internal.storage.RootPath;
import org.dfe.models.internal.storage.StorageResult;
import org.dfe.util.DateUtils;
import org.dfe.util.IOUtils;
import org.dfe.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class FileSystemStorageService extends StorageServiceFactory {

    @Override
    public String rootPath(RootPath rootPath) {
        Config config = rootPath.config();
        return String.join(IOUtils.separator(), IOUtils.homeDir(), "xmls", config.environment().getRootPath(), config.cnpj(), rootPath.key(), DateUtils.currentyear(), StringUtils.padZeroStart(DateUtils.currentMonth(), 2));
    }

    /**
     * "Write the XML content to the file system."
     *
     * @param conf       The configuration object that contains the root path of the storage.
     * @param key        The key of the file to be written.
     * @param xmlName    The name of the file to be written.
     * @param xmlContent The XML content to be written to the file.
     */
    @Override
    public StorageResult writeSend(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForSend())), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getSend(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForSend())), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
    }

    StorageResult getFirst(Config config, String key, String xmlName) {
        return StorageResult.builder()
                .file(IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(new RootPath(config, key)), xmlName))
                        .stream()
                        .min(Comparator.comparing(it -> Optional.ofNullable(IOUtils.creationDate(it)).orElseGet(LocalDateTime::now)))
                        .orElse(null))
                .build();
    }

    @Override
    public StorageResult getFirstSend(Config conf, StorageKey key, String xmlName) throws IOException {
        return getFirst(conf, key.getForSend(), xmlName);
    }

    /**
     * Write the XML content to the file system.
     *
     * @param conf       The configuration object.
     * @param key        The key of the file to be written.
     * @param xmlName    the name of the file to be written
     * @param xmlContent The XML content to be written to the file.
     */
    @Override
    public StorageResult writeReturn(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForReturn())), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getReturn(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForReturn())), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
    }

    @Override
    public StorageResult getFirstReturn(Config conf, StorageKey key, String xmlName) throws IOException {
        return getFirst(conf, key.getForReturn(), xmlName);
    }

    /**
     * This function writes the XML content to a file in the processed directory
     *
     * @param conf       The configuration object
     * @param key        The key of the file to be written.
     * @param xmlName    the name of the file to be written
     * @param xmlContent The XML content to be written to the file.
     */
    @Override
    public StorageResult writeProc(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForProcessed())), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getProc(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(new RootPath(conf, key.getForProcessed())), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
    }

    @Override
    public StorageResult getFirstProc(Config conf, StorageKey key, String xmlName) throws IOException {
        return getFirst(conf, key.getForProcessed(), xmlName);
    }
}
