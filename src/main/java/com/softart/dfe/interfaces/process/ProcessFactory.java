package com.softart.dfe.interfaces.process;

import com.softart.dfe.interfaces.xml.XML;

import java.util.Collection;

public interface ProcessFactory<REQ extends XML, RES extends XML> {

    Collection<? extends AfterWebServiceRequest<REQ, RES>> after();

    Collection<? extends BeforeWebServiceRequest<REQ>> before();

}
