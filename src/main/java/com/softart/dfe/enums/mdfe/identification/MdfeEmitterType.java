package com.softart.dfe.enums.mdfe.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MdfeEmitterType implements DFEnum.Codeable {
    CODE_1("1", "Prestador de serviço de transporte"),
    CODE_2("2", "Transportador de Carga Própria"),
    CODE_3("3", "Prestador de serviço de transporte  que emitirá CT-e Globalizado");

    private final String code;
    private final String description;
}
