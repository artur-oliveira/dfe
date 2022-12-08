package com.softart.dfe.interfaces.process;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.xml.XML;

public interface BeforeWebServiceRequest<REQ extends XML> {

    <T extends BeforeRequest<REQ>> void process(T o) throws ProcessException;

}
