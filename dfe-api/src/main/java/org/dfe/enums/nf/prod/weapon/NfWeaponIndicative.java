package org.dfe.enums.nf.prod.weapon;

import lombok.Getter;
import org.dfe.components.internal.DFEnum;

@Getter
public enum NfWeaponIndicative implements DFEnum.Codeable {

    ALLOWED("0", "Uso permitido"),
    RESTRICT("1", "Uso restrito");

    private final String code;
    private final String description;

    NfWeaponIndicative(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NfWeaponIndicative valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }
}
