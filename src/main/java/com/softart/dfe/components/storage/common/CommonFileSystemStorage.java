package com.softart.dfe.components.storage.common;

import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.interfaces.storage.Store;
import com.softart.dfe.util.DateUtils;
import com.softart.dfe.util.IOUtils;
import com.softart.dfe.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

import static java.io.File.separator;
import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class CommonFileSystemStorage {

    protected final static String BASE_DIR = System.getProperty("user.home");

    protected static String rootPath(Config config) {
        return String.join(separator, BASE_DIR,
                "xmls",
                config.environment().getRootPath(),
                config.cnpj(),
                DateUtils.currentyear(),
                StringUtils.padZeroStart(DateUtils.currentMonth(), 2)
        );
    }

    protected String xmlNameWithTime(Object prefix) {
        return prefix + "-" + System.currentTimeMillis() + "-" + UUID.randomUUID() + ".xml";
    }

    protected String xmlNameWithTime() {
        return System.currentTimeMillis() + "-" + UUID.randomUUID() + ".xml";
    }

    protected void writeSend(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        IOUtils.write(String.join(separator, rootPath(conf), key.getForSend(), xmlName), xmlContent.getBytes(UTF_8));
    }

    protected void writeReturn(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        IOUtils.write(String.join(separator, rootPath(conf), key.getForReturn(), xmlName), xmlContent.getBytes(UTF_8));
    }

    protected void writeProc(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException {
        IOUtils.write(String.join(separator, rootPath(conf), key.getForProcessed(), xmlName), xmlContent.getBytes(UTF_8));
    }

    protected void writeSend(Store<?> o, StorageKey key, String xmlName) throws IOException {
        writeSend(o.getConfig(), key, xmlName, o.getXml());
    }

    protected void writeReturn(Store<?> o, StorageKey key, String xmlName) throws IOException {
        writeReturn(o.getConfig(), key, xmlName, o.getXml());
    }

    protected void writeProc(Store<?> o, StorageKey key, String xmlName) throws IOException {
        writeProc(o.getConfig(), key, xmlName, o.getXml());
    }


}
