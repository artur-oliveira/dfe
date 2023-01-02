package com.softart.dfe.models.internal.xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * It's a POJO that holds the XML and XSD file names
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public final class XMLValidation {

    private String xsd;
    private String xml;

}
