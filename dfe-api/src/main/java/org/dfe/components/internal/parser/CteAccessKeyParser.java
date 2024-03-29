package org.dfe.components.internal.parser;

import org.dfe.util.XMLStringUtils;

/**
 * The CteAccessKeyParser class extends the AccessKeyParserFactory and overrides the idPrefix method to return a specific
 * prefix.
 */
final class CteAccessKeyParser extends AccessKeyParserFactoryImpl {

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_CTE_PREFIX;
    }
}
