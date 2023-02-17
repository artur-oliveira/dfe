package com.softart.dfe.enums.cte;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum CteEvent implements DFEnum.Codeable {

    STATUS_SERVICE("STATUS", "Consulta status serviço"),
    INUTILIZATION("INUTILIZAR", "Inutilizacao", System.getProperty("com.softart.dfe.cte.message.inutilization", "erro de emissao")),
    QUERY_SITUATION("CONSULTAR", "Consulta situação"),
    CANCEL("110111", "Cancelamento", System.getProperty("com.softart.dfe.cte.message.cancel", "erro de emissao"), "evCancCTe_v3.00.xsd"),
    CORRECTION_LETTER("110110", "Carta de Correcao", null, "evCCeCTe_v3.00.xsd"),
    DELIVERY_RECEIPT("110180", "Comprovante de Entrega do CT-e", null, "evCECTe_v3.00.xsd"),
    CANCEL_DELIVERY_RECEIPT("110181", "Cancelamento do Comprovante de Entrega do CT-e", null, "evCancCECTe_v3.00.xsd"),
    EPEC("110113", "EPEC", System.getProperty("com.softart.dfe.cte.message.epec", "erro no autorizador de origem"), "evEPECCTe_v3.00.xsd"),
    INFO_GTV("110170", "Informações da GTV", null, "evGTV_v3.00.xsd"),
    PROVISION_IN_DISAGREEMENT("610110", "Prestação do Serviço em Desacordo", null, "evPrestDesacordo_v3.00.xsd"),
    MULTIMODAL("110160", "Registro Multimodal", null, "evRegMultimodal_v3.00.xsd"),
    ;
    private final String code;
    private final String description;
    private final String defaultMessage;
    private final String xsdName;

    CteEvent(String code, String description, String defaultMessage) {
        this(code, description, defaultMessage, null);
    }

    CteEvent(String code, String description, String defaultMessage, String xsdName) {
        this.code = code;
        this.description = description;
        this.defaultMessage = defaultMessage;
        this.xsdName = xsdName;
    }

    CteEvent(String code, String description) {
        this(code, description, null);
    }

    public static CteEvent valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
