package com.softart.dfe.interfaces.storage;

import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.storage.StorageResult;

import java.io.IOException;

/**
 * Declaring a public interface named `StorageService`. This interface defines a set of methods that must be implemented by
 * any class that implements this interface. These methods are related to storing and retrieving data from a storage
 * system.
 */
public interface StorageService {

    /**
     * Returns the root path of the config
     *
     * @param config The configuration object that contains the configuration for the application.
     * @return A string
     */
    String rootPath(Config config);

    /**
     * It writes the xmlContent to a file in the local file system.
     *
     * @param conf       The configuration object that contains the connection information.
     * @param key        The key of the file to be written.
     * @param xmlName    The name of the XML file to be written.
     * @param xmlContent The XML content to be sent.
     * @return A File object.
     */
    StorageResult writeSend(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException;

    /**
     * * It takes a configuration object, a storage key, a file name, and a file content.
     * * It writes the file content to the file name in the storage location specified by the storage key.
     * * It returns a File object representing the file that was written
     *
     * @param conf       The configuration object that contains the configuration information for the storage system.
     * @param key        The key of the file to be written.
     * @param xmlName    The name of the XML file to be written.
     * @param xmlContent The XML content to be written to the file.
     * @return A File object.
     */
    StorageResult writeProc(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException;

    /**
     * It writes the xmlContent to the file specified by xmlName in the directory specified by key.
     *
     * @param conf       The configuration object that contains the information about the storage account.
     * @param key        The key of the file to be written.
     * @param xmlName    The name of the XML file to be written.
     * @param xmlContent The XML content to be written to the file.
     * @return A File object.
     */
    StorageResult writeReturn(Config conf, StorageKey key, String xmlName, String xmlContent) throws IOException;

    /**
     * "Write the XML to a file and send it to the server."
     *
     * @param o       The object to be written.
     * @param key     The key to the file to be written.
     * @param xmlName The name of the XML file to be written.
     * @return A File object.
     */
    default StorageResult writeSend(Store<?> o, StorageKey key, String xmlName) throws IOException {
        return writeSend(o.config(), key, xmlName, o.xml());
    }

    /**
     * "Write the XML file for the given object to the given key."
     *
     * @param o       The object to be written.
     * @param key     The key of the object to be written.
     * @param xmlName The name of the XML file to be written.
     * @return A File object.
     */
    default StorageResult writeProc(Store<?> o, StorageKey key, String xmlName) throws IOException {
        return writeProc(o.config(), key, xmlName, o.xml());
    }

    /**
     * "Write the XML file to disk and return the file."
     *
     * @param o       The object to be written.
     * @param key     The key of the file to write to.
     * @param xmlName The name of the XML file to be written.
     * @return A File object.
     */
    default StorageResult writeReturn(Store<?> o, StorageKey key, String xmlName) throws IOException {
        return writeReturn(o.config(), key, xmlName, o.xml());
    }
}
