package com.softart.dfe.components.storage.mdfe;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.softart.dfe.components.storage.cte.GenericCteStorage;
import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.storage.StorageResult;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;
import com.softart.dfe.util.S3Utils;
import com.softart.dfe.util.StringUtils;

import java.io.IOException;

public final class MdfeS3Storage extends GenericMdfeStorage {

    private final AmazonS3 client;
    private final static String S3_BUCKET = System.getProperty("com.softart.dfe.s3.bucket");

    public MdfeS3Storage() {
        this.client = AmazonS3ClientBuilder.standard().build();
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

    /**
     * > This function writes the XML content to a file in the processed directory
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

    /**
     * > This function uploads the XML content to S3 and returns a StorageResult object
     *
     * @param filename   The name of the file to be stored in S3.
     * @param xmlContent The XML content to be stored in S3
     * @return A StorageResult object with the filename.
     */
    private StorageResult getResult(String filename, String xmlContent) throws IOException {
        S3Utils.putObject(getClient(), getS3Bucket(), filename, xmlContent);
        return StorageResult.builder().fileName(filename).build();
    }

    /**
     * Returns the S3 bucket name for the given S3 object.
     *
     * @return The S3 bucket name.
     */
    public String getS3Bucket() {
        return S3_BUCKET;
    }

    /**
     * This function returns an AmazonS3 client object.
     *
     * @return An AmazonS3 object.
     */
    public AmazonS3 getClient() {
        return client;
    }
}
