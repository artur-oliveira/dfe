package com.softart.dfe.interfaces.storage;

import com.softart.dfe.interfaces.internal.StorageKey;
import com.softart.dfe.interfaces.internal.config.Config;
import com.softart.dfe.models.internal.storage.StorageResult;

import java.io.IOException;
import java.util.Collection;

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
     * This function retrieves a collection of storage results for sending data with a specified configuration, storage
     * key, and XML file name.
     *
     * @param conf    The "conf" parameter is of type "Config" and is likely an object that contains configuration settings or
     *                properties needed for the operation of the method. It could include things like server addresses, authentication
     *                credentials, or other settings specific to the application or system the method is a part of.
     * @param key     The `key` parameter is of type `StorageKey` and is used to identify the storage location for the data
     *                being retrieved. It could be a file path, a database table name, or any other identifier that uniquely identifies
     *                the storage location.
     * @param xmlName xmlName is a String parameter that represents the name of the XML file. It is used as a parameter in
     *                the method to retrieve a collection of StorageResult objects based on the configuration, storage key, and the
     *                specified XML file name.
     * @return A collection of `StorageResult` objects is being returned.
     */
    Collection<StorageResult> getSend(Config conf, StorageKey key, String xmlName) throws IOException;


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
     * This function retrieves storage results for a given configuration, storage key, and XML file name.
     *
     * @param conf    The "conf" parameter is an object of type "Config" which contains configuration information for the
     *                storage system. It may include things like connection settings, authentication credentials, or other settings needed
     *                to access the storage system.
     * @param key     The `key` parameter is of type `StorageKey` and is used to identify the storage location for the data
     *                that needs to be retrieved. It could be a file path, a database table name, or any other identifier that uniquely
     *                identifies the storage location.
     * @param xmlName xmlName is a String parameter that represents the name of the XML file to be retrieved from the
     *                storage.
     * @return A collection of `StorageResult` objects is being returned.
     */
    Collection<StorageResult> getProc(Config conf, StorageKey key, String xmlName) throws IOException;

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
     * This function retrieves a collection of storage results based on a configuration, storage key, and XML name.
     *
     * @param conf    The "conf" parameter is of type "Config" and is likely an object that contains configuration settings or
     *                properties for the system or application. It is used as an input to the method to provide necessary configuration
     *                information.
     * @param key     The `key` parameter is of type `StorageKey` and is used to identify the specific storage location for
     *                which the method is retrieving data. It could be a file path, a database table name, or any other identifier that
     *                uniquely identifies the storage location.
     * @param xmlName xmlName is a String parameter that represents the name of the XML file. It is used as an input
     *                parameter for the method getReturn() to retrieve a collection of StorageResult objects based on the specified
     *                configuration, storage key, and XML file name.
     * @return A collection of `StorageResult` objects is being returned.
     */
    Collection<StorageResult> getReturn(Config conf, StorageKey key, String xmlName) throws IOException;

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
