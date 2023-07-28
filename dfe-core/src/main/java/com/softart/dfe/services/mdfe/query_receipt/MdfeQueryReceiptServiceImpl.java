package com.softart.dfe.services.mdfe.query_receipt;

import com.softart.dfe.components.security.signer.XmlSigner;
import com.softart.dfe.components.sefaz.DfeServiceFactory;
import com.softart.dfe.components.validation.ValidatorFactory;
import com.softart.dfe.components.wsdl.ConfigureProviderFactory;
import com.softart.dfe.interfaces.internal.config.MdfeConfig;
import com.softart.dfe.interfaces.process.mdfe.MdfeProcessService;
import com.softart.dfe.interfaces.xml.XMLSignerService;
import com.softart.dfe.models.internal.process.MdfeProcess;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public final class MdfeQueryReceiptServiceImpl implements MdfeQueryReceiptService {
    private final MdfeConfig config;
    private final XMLSignerService xmlSigner = XmlSigner.getInstance();
    private final MdfeProcessService process = MdfeProcess.getInstance();
    private final DfeServiceFactory providerFactory = DfeServiceFactory.getInstance();
    private final ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
    private final ConfigureProviderFactory configureProviderFactory = ConfigureProviderFactory.getInstance();
}
