package com.softart.dfe.enums.internal;

import br.inf.portalfiscal.nfe.send.TNFe;
import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.models.nf.authorization.Nf;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum Environment implements DFEnum.Codeable {
    PRODUCTION("1", "Ambiente de produção", "prod"),
    HOMOLOGATION("2", "Ambiente de homologação", "hom");

    private final String code;
    private final String description;
    private final String rootPath;

    Environment(String code, String description, String rootPath) {
        this.code = code;
        this.description = description;
        this.rootPath = rootPath;
    }

    public static Environment valueOfCode(String codigo) {
        return valueOfCode(Objects.equals(PRODUCTION.getCode(), codigo));
    }

    public static Environment valueOfCode(boolean codigo) {
        return codigo ? PRODUCTION : HOMOLOGATION;
    }

    public static Environment valueOfNf(Nf nf) {
        return valueOfCode(nf.getInfNFe().getIde().getTpAmb());
    }

    public static Environment valueOfNf(TNFe tnFe) {
        return valueOfCode(tnFe.getInfNFe().getIde().getTpAmb());
    }

    public boolean production() {
        return Objects.equals(this, Environment.PRODUCTION);
    }
}
