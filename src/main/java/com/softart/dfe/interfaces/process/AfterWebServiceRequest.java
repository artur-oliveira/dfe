package com.softart.dfe.interfaces.process;

import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.xml.XML;

public interface AfterWebServiceRequest<REQ extends XML, RES extends XML> {

    <T extends AfterRequest<REQ, RES>> void process(T o) throws ProcessException;

}
