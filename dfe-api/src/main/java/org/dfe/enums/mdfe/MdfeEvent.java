package org.dfe.enums.mdfe;

import org.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum MdfeEvent implements DFEnum.Codeable {
    STATUS_SERVICE("STATUS", "Consulta status serviço"),
    QUERY_SITUATION("CONSULTAR", "Consulta situação"),
    QUERY_UNCLOSED("CONSULTAR NÃO ENCERRADOS", "Consultar MDF-e não encerrados"),
    CANCEL("110111", "Cancelamento", System.getProperty("DEFAULT_MDFE_CANCEL_MESSAGE", "Cancelamento solicitado por conta de erros na emissao"), "evCancMDFe_v3.00.xsd"),
    CLOSE("110112", "Encerramento", null, "evEncMDFe_v3.00.xsd"),
    DRIVER_INCLUSION("110114", "Inclusao Condutor", null, "evIncCondutorMDFe_v3.00.xsd"),
    DFE_INCLUSION("110115", "Inclusao DF-e", null, "evInclusaoDFeMDFe_v3.00.xsd"),
    PAYMENT_OPERATION("110116", "Pagamento Operação MDF-e", null, "evPagtoOperMDFe_v3.00.xsd"),
    TRANSPORT_CONFIRMATION("110117", "Confirmação Serviço Transporte", null, "evConfirmaServMDFe_v3.00.xsd"),
    PAYMENT_MODIFICATION("110118", "Alteração Pagamento Serviço MDFe", null, "evAlteracaoPagtoServMDFe_v3.00.xsd"),
    ;


    private final String code;
    private final String description;
    private String defaultMessage;
    private String xsdName;

    public static MdfeEvent valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

}
