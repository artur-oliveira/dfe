package com.softart.dfe.components.storage.common;

import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.storage.StorageService;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;
import com.softart.dfe.util.StringUtils;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class CommonFileSystemStorage extends CommonStorage implements StorageService {

    /**
     * It returns a string with the path to the directory where the XML files are stored
     *
     * @param config The config object that contains the environment, cnpj and other information.
     * @return The root path of the XMLs
     */
    @Override
    public String rootPath(Config config) {
        return String.join(IOUtils.separator(), IOUtils.homeDir(),
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
    public File writeSend(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForSend(), xmlName), xmlContent.getBytes(UTF_8));
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
    public File writeReturn(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForReturn(), xmlName), xmlContent.getBytes(UTF_8));
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
    public File writeProc(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        return IOUtils.write(String.join(IOUtils.separator(), rootPath(conf), key.getForProcessed(), xmlName), xmlContent.getBytes(UTF_8));
    }


}
