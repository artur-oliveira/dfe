package org.dfe.components.internal.xml.validation;

import org.dfe.exceptions.xml.XSDValidationException;
import org.dfe.models.internal.xml.XMLValidation;
import org.xml.sax.SAXParseException;

final class SaxPatternExceptionHandler implements SaxParserExceptionHandler {

    public XSDValidationException handleSaxParseException(SAXParseException e, XMLValidation validation) {
        try {
            String xml = validation.xml();
            int start = getStartColumnTag(e, xml);
            String trimmed = xml.substring(start);
            int startTagOpen = trimmed.indexOf('<') + 1;
            int startTagClose = trimmed.indexOf('>');
            int endTagOpen = trimmed.indexOf("</", startTagClose);
            String tag = trimmed.substring(startTagOpen, startTagClose);
            String value = trimmed.substring(startTagClose + 1, endTagOpen);
            return new XSDValidationException(e, validation.xml(), tag, value);
        } catch (Exception ex) {
            return new XSDValidationException(ex, validation.xml());
        }
    }

    int getStartColumnTag(SAXParseException e, String xml) {
        int column = e.getColumnNumber();
        int startTagCount = 0;
        int endTagCount = 0;
        for (int i = column; i >= 0; i--) {
            if (xml.charAt(i) == '<') {
                startTagCount++;
            } else if (xml.charAt(i) == '>') {
                endTagCount++;
            }
            if (startTagCount == 3 && endTagCount == 2) {
                column = i;
                break;
            }
        }
        return column;
    }

    @Override
    public String getHandledTypeError() {
        return "cvc-pattern";
    }
}
