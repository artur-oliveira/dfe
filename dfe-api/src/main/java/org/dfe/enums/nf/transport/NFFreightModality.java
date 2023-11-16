package org.dfe.enums.nf.transport;

import org.dfe.components.internal.DFEnum;
import lombok.Getter;

@Getter
public enum NFFreightModality implements DFEnum.Codeable {

    CONTRACTING_ISSUER("0", "Contratação do Frete por conta do Remetente (CIF)"),
    CONTRACTING_RECIPIENT("1", "Contratação do Frete por conta do Destinatário (FOB)"),
    CONTRACTING_THIRD_PARTY("2", "Contratação do Frete por conta de Terceiros"),
    OWN_TRANSPORT_BY_ISSUER("3", "Transporte Próprio por conta do Remetente"),
    OWN_TRANSPORT_BY_RECIPIENT("4", "Transporte Próprio por conta do Destinatário"),
    NO_TRANSPORT("9", "Sem Ocorrência de Transporte");

    private final String code;
    private final String description;

    NFFreightModality(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFFreightModality valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
