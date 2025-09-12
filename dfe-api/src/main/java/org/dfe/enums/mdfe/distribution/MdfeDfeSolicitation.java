package org.dfe.enums.mdfe.distribution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
@AllArgsConstructor
public enum MdfeDfeSolicitation implements DFEnum.Codeable {
    CODE_0("0", "DF-e autorizados pela UF"),
    CODE_1("1", "DF-e com carregamento na UF"),
    CODE_2("2", "DF-e com descarregamento na UF"),
    CODE_3("3", "DF-e com percurso pela UF"),
    CODE_8("8", "DF-e carregados  (1), descarregados (2)  e que tiveram percurso na UF (3)"),
    CODE_9("9", "Todos DF-e que fazem referência a UF.");

    private final String code;
    private final String description;
}
