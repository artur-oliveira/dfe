package com.softart.dfe.models.internal.xml;

import lombok.Builder;


/**
 * It's a POJO that holds the XML and XSD file names
 */
@Builder
public record XMLValidation(String xsd, String xml) {
}
