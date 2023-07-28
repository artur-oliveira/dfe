package com.softart.dfe.enums.nf.identification;

import com.softart.dfe.components.internal.DFEnum;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum NFEmissionType implements DFEnum.Codeable {

    NORMAL("1", "Emissão normal (não em contingência)"),
    FS_IA("2", "Contingência FS-IA, com impressão do DANFE em Formulário de Segurança - Impressor Autônomo"),
    SCAN("3", "Contingência SCAN (Sistema de Contingência do Ambiente Nacional); *Desativado * NT 2015/00"),
    EPEC("4", "Contingência EPEC (Evento Prévio da Emissão em Contingência)"),
    FS_DA("5", "Contingência FS-DA, com impressão do DANFE em Formulário de Segurança - Documento Auxiliar"),
    SVCAN("6", "Contingência SVC-AN (SEFAZ Virtual de Contingência do AN)"),
    SVCRS("7", "Contingência SVC-RS (SEFAZ Virtual de Contingência do RS)"),
    OFFLINE("9", "Contingência off-line da NFC-e");

    private final String code;
    private final String description;

    NFEmissionType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NFEmissionType valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

    public static List<NFEmissionType> nfe() {
        return Arrays.asList(NFEmissionType.NORMAL, NFEmissionType.SVCAN, NFEmissionType.SVCRS);
    }

    public static boolean isOffline(String tpEmis) {
        return NFEmissionType.OFFLINE.getCode().equals(tpEmis);
    }
}
