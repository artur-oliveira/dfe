package com.softart.dfe.components.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.storage.StorageResult;
import com.softart.dfe.util.*;
import lombok.Getter;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;


@Getter
public final class S3StorageService extends StorageServiceFactory {
    private final AmazonS3 client;
    private final String s3Bucket;

    public S3StorageService() {
        this(RequireUtils.nonNull(System.getProperty("com.softart.dfe.s3.bucket"), "com.softart.dfe.s3.bucket must be set in order to use S3StorageService"));
    }

    public S3StorageService(String s3Bucket) {
        this.client = S3Utils.clientInstance();
        this.s3Bucket = s3Bucket;
    }

    /**
     * It returns a string with the path to the directory where the XML files are stored
     *
     * @param config The config object that contains the environment, cnpj and other information.
     * @return The root path of the XMLs
     */
    @Override
    public String rootPath(Config config) {
        return String.join(IOUtils.separator(),
                "xmls",
                config.environment().getRootPath(),
                config.cnpj(),
                DateUtils.currentyear(),
                StringUtils.padZeroStart(DateUtils.currentMonth(), 2)
        );
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
        return getResult(String.join(IOUtils.separator(), rootPath(conf), key.getForSend(), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getSend(Config conf, StorageKey key, String xmlName) throws IOException {
        return listKeys(String.join(IOUtils.separator(), rootPath(conf), key.getForSend(), xmlName));
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
        return getResult(String.join(IOUtils.separator(), rootPath(conf), key.getForReturn(), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getReturn(Config conf, StorageKey key, String xmlName) {
        return listKeys(String.join(IOUtils.separator(), rootPath(conf), key.getForReturn(), xmlName));
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
        return getResult(String.join(IOUtils.separator(), rootPath(conf), key.getForProcessed(), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getProc(Config conf, StorageKey key, String xmlName) {
        return listKeys(String.join(IOUtils.separator(), rootPath(conf), key.getForProcessed(), xmlName));
    }

    /**
     * This function uploads the XML content to S3 and returns a StorageResult object
     *
     * @param filename   The name of the file to be stored in S3.
     * @param xmlContent The XML content to be stored in S3
     * @return A StorageResult object with the filename.
     */
    private StorageResult getResult(String filename, String xmlContent) throws IOException {
        S3Utils.putObject(getClient(), getS3Bucket(), filename, xmlContent);
        return StorageResult.builder().fileName(filename).build();
    }

    private Collection<StorageResult> listKeys(String filename) {
        return S3Utils.listObjects(filename).stream().map(it -> {
            try {
                return StorageResult.builder().file(IOUtils.writeTemp(it.getKey(), IOUtils.readAllBytes(it.getObjectContent()))).build();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

}
