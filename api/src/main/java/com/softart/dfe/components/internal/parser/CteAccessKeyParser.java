package com.softart.dfe.components.internal.parser;

import com.softart.dfe.util.XMLStringUtils;

final class CteAccessKeyParser extends AccessKeyParserFactory {

    @Override
    public String idPrefix() {
        return XMLStringUtils.ID_CTE_PREFIX;
    }
}
