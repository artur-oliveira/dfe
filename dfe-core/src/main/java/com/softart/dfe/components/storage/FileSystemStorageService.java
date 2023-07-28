package com.softart.dfe.components.storage;

import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.storage.StorageResult;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;
import com.softart.dfe.util.StringUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class FileSystemStorageService extends StorageServiceFactory {
    /**
     * It returns a string with the path to the directory where the XML files are stored
     *
     * @param config The config object that contains the environment, cnpj and other information.
     * @return The root path of the XMLs
     */
    @Override
    public String rootPath(Config config) {
        return String.join(IOUtils.separator(), IOUtils.homeDir(), "xmls", config.environment().getRootPath(), config.cnpj(), DateUtils.currentyear(), StringUtils.padZeroStart(DateUtils.currentMonth(), 2));
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
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForSend(), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getSend(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(conf), key.getForSend(), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
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
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForReturn(), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getReturn(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(conf), key.getForReturn(), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
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
        return StorageResult.builder().file(IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForProcessed(), xmlName), xmlContent.getBytes(UTF_8))).build();
    }

    @Override
    public Collection<StorageResult> getProc(Config conf, StorageKey key, String xmlName) {
        return IOUtils.findFilesByBasePath(String.join(IOUtils.separator(), rootPath(conf), key.getForProcessed(), xmlName))
                .stream()
                .map(it -> StorageResult.builder().file(it).build())
                .collect(Collectors.toList());
    }
}
