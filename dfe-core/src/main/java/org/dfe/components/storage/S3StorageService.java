package org.dfe.components.storage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.Getter;
import org.dfe.interfaces.internal.StorageKey;
import org.dfe.interfaces.internal.config.Config;
import org.dfe.models.internal.storage.RootPath;
import org.dfe.models.internal.storage.StorageResult;
import org.dfe.util.IOUtils;
import org.dfe.util.RequireUtils;
import org.dfe.util.S3Utils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Getter
public final class S3StorageService extends StorageServiceFactory {
    private final AmazonS3 client;
    private final String s3Bucket;

    public S3StorageService() {
        this(RequireUtils.nonNull(System.getProperty("org.dfe.s3.bucket"), "org.dfe.s3.bucket must be set in order to use S3StorageService"));
    }

    public S3StorageService(String s3Bucket) {
        this.client = S3Utils.clientInstance();
        this.s3Bucket = s3Bucket;
    }

    @Override
    public String rootPath(RootPath rootPath) {
        return rootPath.getRootPath();
    }

    StorageResult getFirst(Config config, String key, String xmlName) throws IOException {
        String fileKey = String.join(IOUtils.separator(), rootPath(RootPath.builder().config(config).key(key).xmlName(xmlName).build()), xmlName);
        S3ObjectSummary summary = S3Utils.listObjects(fileKey).stream().min(Comparator.comparing(it -> Optional.ofNullable(it.getLastModified()).orElseGet(Date::new))).orElse(null);

        if (Objects.isNull(summary)) {
            return StorageResult.builder().build();
        }

        return StorageResult
                .builder()
                .file(IOUtils.writeTemp(summary.getKey(), IOUtils.readAllBytes(S3Utils.getObject(summary.getBucketName(), summary.getKey()).getObjectContent())))
                .build();
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
        return getResult(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForSend()).xmlName(xmlName).build()), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getSend(Config conf, StorageKey key, String xmlName) throws IOException {
        return listKeys(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForSend()).xmlName(xmlName).build()), xmlName));
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
        return getResult(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForReturn()).xmlName(xmlName).build()), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getReturn(Config conf, StorageKey key, String xmlName) {
        return listKeys(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForReturn()).xmlName(xmlName).build()), xmlName));
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
        return getResult(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForProcessed()).xmlName(xmlName).build()), xmlName), xmlContent);
    }

    @Override
    public Collection<StorageResult> getProc(Config conf, StorageKey key, String xmlName) {
        return listKeys(String.join(IOUtils.separator(), rootPath(RootPath.builder().config(conf).key(key.getForProcessed()).xmlName(xmlName).build()), xmlName));
    }

    @Override
    public Collection<StorageResult> getProc(RootPath rootPath) throws IOException {
        return listKeys(String.join(IOUtils.separator(), rootPath(rootPath), rootPath.getXmlName()));
    }

    @Override
    public StorageResult getFirstProc(Config conf, StorageKey key, String xmlName) throws IOException {
        return getFirst(conf, key.getForProcessed(), xmlName);
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
                return StorageResult.builder().file(IOUtils.writeTemp(it.getKey(), IOUtils.readAllBytes(S3Utils.getObject(it.getBucketName(), it.getKey()).getObjectContent()))).build();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

}
