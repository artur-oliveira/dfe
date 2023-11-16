package org.dfe.enums.mdfe;

import org.dfe.components.internal.DFEnum;
import org.dfe.exceptions.NoEnumException;
import org.dfe.interfaces.internal.ReturnCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Getter
@AllArgsConstructor
@Log4j2
public enum MdfeReturnCode implements ReturnCode {
    CODE_100("100", "Autorizado o uso do MDF-e"),
    CODE_101("101", "Cancelamento de MDF-e homologado"),
    CODE_103("103", "Arquivo recebido com sucesso"),
    CODE_104("104", "Arquivo processado"),
    CODE_105("105", "Arquivo em processamento"),
    CODE_106("106", "Arquivo não localizado"),
    CODE_107("107", "Serviço em Operação"),
    CODE_108("108", "Serviço Paralisado Momentaneamente (curto prazo)"),
    CODE_109("109", "Serviço Paralisado sem Previsão"),
    CODE_111("111", "Consulta Não Encerrados localizou MDF-e nessa situação"),
    CODE_112("112", "Consulta Não Encerrados não localizou MDF-e nessa situação"),
    CODE_132("132", "Encerramento de MDF-e homologado"),
    CODE_134("134", "Evento registrado com alerta para situação"),
    CODE_135("135", "Evento registrado e vinculado a MDF-e"),
    CODE_136("136", "Evento registrado, mas não vinculado a MDF-e"),
    CODE_202("202", "Rejeição: CPF do Emitente difere do CPF do Certificado Digital"),
    CODE_203("203", "Rejeição: Emissor não habilitado para emissão do MDF-e"),
    CODE_204("204", "Rejeição: Duplicidade de MDF-e [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_207("207", "Rejeição: CNPJ do emitente inválido"),
    CODE_209("209", "Rejeição: IE do emitente inválida"),
    CODE_210("210", "Rejeição: CPF do emitente inválido"),
    CODE_212("212", "Rejeição: Data/hora de emissão MDF-e posterior a data/hora de recebimento"),
    CODE_213("213", "Rejeição: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital"),
    CODE_214("214", "Rejeição: Tamanho da mensagem excedeu o limite estabelecido"),
    CODE_215("215", "Rejeição: Falha no schema XML"),
    CODE_216("216", "Rejeição: Chave de Acesso difere da cadastrada"),
    CODE_217("217", "Rejeição: MDF-e não consta na base de dados da SEFAZ"),
    CODE_218("218", "Rejeição: MDF-e já está cancelado na base de dados da SEFAZ. [nProt:999999999999999][dhCanc: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_219("219", "Rejeição: Circulação do MDF-e verificada"),
    CODE_220("220", "Rejeição: MDF-e autorizado há mais de 24 horas"),
    CODE_222("222", "Rejeição: Protocolo de Autorização de Uso difere do cadastrado"),
    CODE_223("223", "Rejeição: CNPJ / CPF do transmissor do arquivo difere do CNPJ / CPF do transmissor da consulta"),
    CODE_225("225", "Rejeição: Falha no Schema XML do MDF-e"),
    CODE_226("226", "Rejeição: Código da UF do Emitente diverge da UF autorizadora"),
    CODE_227("227", "Rejeição: Erro na composição do Campo ID"),
    CODE_228("228", "Rejeição: Data de emissão muito atrasada"),
    CODE_229("229", "Rejeição: IE do emitente não informada"),
    CODE_230("230", "Rejeição: IE do emitente não cadastrada"),
    CODE_231("231", "Rejeição: IE do emitente não vinculada ao CNPJ / CPF"),
    CODE_232("232", "Rejeição: CNPJ do emitente com série incompatível"),
    CODE_233("233", "Rejeição: CPF do emitente com série incompatível"),
    CODE_234("234", "Rejeição: Tipo de emitente inválido para emitente pessoa física"),
    CODE_236("236", "Rejeição: Chave de Acesso inválida [Motivo: XXXXXXXXXXXX]"),
    CODE_238("238", "Rejeição: Cabeçalho - Versão do arquivo XML superior a Versão vigente"),
    CODE_239("239", "Rejeição: Versão do arquivo XML não suportada"),
    CODE_242("242", "Rejeição: Elemento mdfeCabecMsg inexistente no SOAP Header"),
    CODE_243("243", "Rejeição: XML Mal Formado"),
    CODE_244("244", "Rejeição: Falha na descompactação da área de dados"),
    CODE_247("247", "Rejeição: Sigla da UF do Emitente diverge da UF autorizadora"),
    CODE_248("248", "Rejeição: UF do Recibo diverge da UF autorizadora"),
    CODE_249("249", "Rejeição: UF da Chave de Acesso diverge da UF autorizadora"),
    CODE_252("252", "Rejeição: Ambiente informado diverge do Ambiente de recebimento"),
    CODE_253("253", "Rejeição: Digito Verificador da chave de acesso composta inválido"),
    CODE_280("280", "Rejeição: Certificado Transmissor inválido"),
    CODE_281("281", "Rejeição: Certificado Transmissor Data Validade"),
    CODE_282("282", "Rejeição: Certificado Transmissor sem CNPJ / CPF"),
    CODE_283("283", "Rejeição: Certificado Transmissor - erro Cadeia de Certificação"),
    CODE_284("284", "Rejeição: Certificado Transmissor revogado"),
    CODE_285("285", "Rejeição: Certificado Transmissor difere ICP-Brasil"),
    CODE_286("286", "Rejeição: Certificado Transmissor erro no acesso a LCR"),
    CODE_290("290", "Rejeição: Certificado Assinatura inválido"),
    CODE_291("291", "Rejeição: Certificado Assinatura Data Validade"),
    CODE_292("292", "Rejeição: Certificado Assinatura sem CNPJ / CPF"),
    CODE_293("293", "Rejeição: Certificado Assinatura - erro Cadeia de Certificação"),
    CODE_294("294", "Rejeição: Certificado Assinatura revogado"),
    CODE_295("295", "Rejeição: Certificado Assinatura difere ICP-Brasil"),
    CODE_296("296", "Rejeição: Certificado Assinatura erro no acesso a LCR"),
    CODE_297("297", "Rejeição: Assinatura difere do calculado"),
    CODE_298("298", "Rejeição: Assinatura difere do padrão do Projeto"),
    CODE_402("402", "Rejeição: XML da área de dados com codificação diferente de UTF-8"),
    CODE_404("404", "Rejeição: Uso de prefixo de namespace não permitido"),
    CODE_405("405", "Rejeição: Município de Carregamento inexistente"),
    CODE_406("406", "Rejeição: Município de Descarregamento inexistente"),
    CODE_407("407", "Rejeição: Código de Município diverge da UF do Emitente do MDF-e"),
    CODE_408("408", "Rejeição: Município do Emitente inexistente"),
    CODE_409("409", "Rejeição: Campo cUF inexistente no elemento mdfeCabecMsg do SOAP Header"),
    CODE_410("410", "Rejeição: UF informada no campo cUF não é atendida pelo WebService"),
    CODE_411("411", "Rejeição: Campo versaoDados inexistente no elemento mdfeCabecMsg do SOAP Header"),
    CODE_454("454", "Rejeição: Tipo de Transportador para Carga Própria e Proprietário do veículo diferente do emitente deve ser TAC"),
    CODE_456("456", "Rejeição: Código de Município diverge da UF de Carregamento do MDF-e"),
    CODE_457("457", "Rejeição: Tipo de Transportador deve ser diferente de TAC"),
    CODE_458("458", "Rejeição: Tipo de Transportador não deve ser informado para Emitente de Carga Própria proprietário do veículo"),
    CODE_459("459", "Rejeição: Documento autorizado ao XML duplicado no MDF-e"),
    CODE_460("460", "Rejeição: Consulta a uma Chave de Acesso muito antiga"),
    CODE_462("462", "Rejeição: Existe MDF-e não encerrado há mais de 5 dias para placa com até 2 UF de percurso informadas [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODE_473("473", "Rejeição: Tipo Autorizador do Recibo diverge do Órgão Autorizador"),
    CODE_479("479", "Rejeição: Endereço do site da UF da Consulta via QR Code diverge do previsto"),
    CODE_480("480", "Rejeição: O QR Code do MDF-e deve ser informado"),
    CODE_481("481", "Rejeição: Parâmetro chave de acesso do QR Code divergente do MDF-e"),
    CODE_482("482", "Rejeição: Parâmetro sign não informado no QR Code para emissão em contingência"),
    CODE_488("488", "Rejeição: Parâmetro sign não deve ser informado no QR Code para emissão Normal"),
    CODE_496("496", "Rejeição: Assinatura do QR-Code difere do calculado"),
    CODE_539("539", "Rejeição: Duplicidade de MDF-e, com diferença na Chave de Acesso [chMDFe: 99999999999999999999999999999999999999999999] [nProt:999999999999999] [dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_540("540", "Rejeição: Não deve ser informado Conhecimento de Transporte para tipo de emitente Prestador Serviço de Transporte que emitirá CT-e Globalizado"),
    CODE_541("541", "Rejeição: Tipo de emitente inválido para operações interestaduais ou com exterior"),
    CODE_542("542", "Rejeição: CNPJ/CPF do responsável pelo seguro deve ser informado para o tipo de responsável informado"),
    CODE_577("577", "Rejeição: Duplicidade de condutor"),
    CODE_578("578", "Rejeição: Informações dos tomadores é obrigatória para esta operação"),
    CODE_579("579", "Rejeição: Versão informada para o modal não suportada"),
    CODE_580("580", "Rejeição: Falha no Schema XML específico para o modal"),
    CODE_598("598", "Rejeição: Usar somente o namespace padrão do MDF-e"),
    CODE_599("599", "Rejeição: Não é permitida a presença de caracteres de edição no início/fim da mensagem ou entre as tags da mensagem"),
    CODE_600("600", "Rejeição: Chave de Acesso difere da existente em BD"),
    CODE_601("601", "Rejeição: Chave de acesso do CT-e informado inválida [chCTe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODE_602("602", "Rejeição: Segundo Código de Barras deve ser informado para CT-e em contingência FS-DA"),
    CODE_603("603", "Rejeição: Segundo Código de Barras não deve ser informado para CT-e com este tipo de emissão"),
    CODE_604("604", "Rejeição: Chave de acesso da NF-e informada inválida [chNFe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODE_606("606", "Rejeição: Segundo Código de Barras deve ser informado para NF-e em contingência (FS-DA e FS-IA)"),
    CODE_607("607", "Rejeição: Segundo Código de Barras não deve ser informado para NF-e com este tipo de emissão"),
    CODE_609("609", "Rejeição: MDF-e já está encerrado na base de dados da SEFAZ [nProt:999999999999999][dhEnc: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_611("611", "Rejeição: Existe MDF-e não encerrado para esta placa, tipo de emitente e UF descarregamento [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODE_612("612", "Rejeição: Código de Município diverge da UF de descarregamento do MDF-e"),
    CODE_614("614", "Rejeição: Código de Município diverge da UF de encerramento do MDF-e"),
    CODE_615("615", "Rejeição: Data de encerramento anterior à data de autorização do MDF-e"),
    CODE_616("616", "Rejeição: Nenhum grupo de documentos foi informado (CT-e, CT, NF-e, MDF-e) Retornar Município de Descarregamento sem DF-e vinculado"),
    CODE_627("627", "Rejeição: CNPJ do autor do evento inválido"),
    CODE_628("628", "Rejeição: Erro Atributo ID do evento não corresponde à concatenação dos campos (“ID” + tpEvento + chMDFe + nSeqEvento)"),
    CODE_629("629", "Rejeição: O tpEvento informado inválido"),
    CODE_630("630", "Rejeição: Falha no Schema XML específico para o evento"),
    CODE_631("631", "Rejeição: Duplicidade de evento [nProt:999999999999999][dhRegEvento: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_632("632", "Rejeição: O autor do evento diverge do emissor do MDF-e"),
    CODE_633("633", "Rejeição: O autor do evento não é um órgão autorizado a gerar o evento"),
    CODE_634("634", "Rejeição: A data do evento não pode ser menor que a data de emissão do MDF-e"),
    CODE_635("635", "Rejeição: A data do evento não pode ser maior que a data do processamento"),
    CODE_636("636", "Rejeição: O número sequencial do evento é maior que o permitido"),
    CODE_637("637", "Rejeição: A data do evento não pode ser menor que a data de autorização do MDF-e"),
    CODE_638("638", "Rejeição: Não deve ser informada Nota Fiscal para tipo de emitente Prestador Serviço de Transporte"),
    CODE_639("639", "Rejeição: Não deve ser informado Conhecimento de Transporte Eletrônico para tipo de emitente Transporte de Carga Própria."),
    CODE_644("644", "Rejeição: Evento de inclusão de condutor só pode ser registrado para o modal rodoviário"),
    CODE_645("645", "Rejeição: CPF do condutor inválido"),
    CODE_646("646", "Rejeição: Placa de veículo formato inválido (UF Carregamento e Descarregamento <> ‘EX’)"),
    CODE_647("647", "Rejeição: MDF-e só pode ser referenciado por manifesto do modal aquaviário"),
    CODE_648("648", "Rejeição: MDF-e só pode ser referenciado quando UF de Carregamento/Descarregamento for igual a AM ou AP"),
    CODE_649("649", "Rejeição: Chave de acesso de MDF-e informada inválida [chMDFe: 99999999999999999999999999999999999999999999] [Motivo: XXXXXXXXXXXX]"),
    CODE_655("655", "Rejeição: MDF-e referenciado não existe na base de dados da SEFAZ"),
    CODE_656("656", "Rejeição: Chave de Acesso do MDF-e referenciado difere da existente em BD"),
    CODE_657("657", "Rejeição: MDF-e referenciado já está cancelado na base de dados da SEFAZ"),
    CODE_658("658", "Rejeição: Modal do MDF-e referenciado diferente de Rodoviário"),
    CODE_659("659", "Rejeição: Tipo do Emitente do MDF-e referenciado difere de Transportador de Carga Própria"),
    CODE_660("660", "Rejeição: CNPJ autorizado para download inválido"),
    CODE_661("661", "Rejeição: CPF autorizado para download inválido"),
    CODE_662("662", "Rejeição: Existe MDF-e não encerrado para esta placa, tipo de emitente no sentido oposto da viagem"),
    CODE_663("663", "Rejeição: Percurso informado inválido"),
    CODE_666("666", "Rejeição: Ano do MDF-e informado na chave de acesso inválido"),
    CODE_667("667", "Rejeição: Quantidade informada no grupo de totalizadores não confere com a quantidade de documentos relacionada"),
    CODE_668("668", "Rejeição: Chave de Acesso de CT-e duplicada [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_669("669", "Rejeição: Chave de Acesso de NF-e duplicada [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_671("671", "Rejeição: CT-e informado não existe na base de dados da SEFAZ [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_672("672", "Rejeição: CT-e informado com diferença de chave de acesso [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_673("673", "Rejeição: CT-e informado não pode estar cancelado/denegado na base da SEFAZ [chCTe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_675("675", "Rejeição: NF-e informada não existe na base de dados da SEFAZ [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_676("676", "Rejeição: NF-e informada com diferença de chave de acesso [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_677("677", "Rejeição: NF-e informada não pode estar cancelada/denegada na base da SEFAZ [chNFe: XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_678("678", "Rejeição: Uso Indevido"),
    CODE_680("680", "Rejeição: Município de descarregamento duplicado no MDF-e"),
    CODE_681("681", "Rejeição: RNTRC informado inexistente."),
    CODE_682("682", "Rejeição: RNTRC situação inválida."),
    CODE_683("683", "Rejeição: Placa do veículo de tração não vinculada ao RNTRC informado."),
    CODE_684("684", "Rejeição: CIOT obrigatório para RNTRC informado."),
    CODE_685("685", "Rejeição: Município de carregamento duplicado no MDF-e"),
    CODE_686("686", "Rejeição: Existe MDF-e não encerrado há mais de 30 dias para o emitente [chMDFe: 99999999999999999999999999999999999999999999][nProt:999999999999999]"),
    CODE_687("687", "Rejeição: RNTRC deve estar associado ao transportador indicado"),
    CODE_688("688", "Rejeição: RNTRC deve ser informado para Prestador de Serviço de Transporte"),
    CODE_689("689", "Rejeição: Município de encerramento deve ser 9999999 para encerramento no exterior"),
    CODE_698("698", "Rejeição: Seguro da carga é obrigatório para modal Prestador de Serviço de Transporte no modal rodoviário"),
    CODE_699("699", "Rejeição: Dados do seguro de carga incompletos para o modal rodoviário"),
    CODE_700("700", "Rejeição: CPF do autor do evento inválido"),
    CODE_701("701", "Rejeição: Tipo de evento incompatível com emitente pessoa física"),
    CODE_702("702", "Rejeição: Modal inválido para entrega parcial (apenas modal aéreo)"),
    CODE_703("703", "Rejeição: Carregamento e Descarregamento inválidos para MDF-e com indicação de carregamento posterior"),
    CODE_704("704", "Rejeição: MDF-e com indicação de carregamento posterior não permitido para operações interestaduais ou com o exterior"),
    CODE_705("705", "Rejeição: Modal inválido para MDF-e com indicação de carregamento posterior (apenas modal rodoviário)"),
    CODE_706("706", "Rejeição: Não informar documentos transportados para MDF-e com indicação de carregamento posterior (usar evento inclusão de DF-e)"),
    CODE_707("707", "Rejeição: MDF-e com indicação de carregamento posterior com tipo de emitente diferente de transporte próprio"),
    CODE_708("708", "Rejeição: MDF-e deve possui indicação de carregamento posterior para inclusão de DF-e"),
    CODE_709("709", "Rejeição: Chave de acesso de NF-e inválida no evento de inclusão [Motivo: CNPJ/CPF inválido / Modelo diferente de 55 / Ano inválido (< 2006) / Mês inválido (0 ou > 12) / Tipo de emissão inválido / UF inválida / Número zerado / DV inválido]"),
    CODE_710("710", "Rejeição: Cancelamento não é permitido para MDF-e com indicação de carregamento posterior que já realizou inserção de DF-e"),
    CODE_711("711", "Rejeição: NF-e já está vinculada ao MDF-e por outro evento"),
    CODE_712("712", "Rejeição: Existe MDF-e com indicação de carregamento posterior sem inclusão de DF-e para o emitente há mais de 168 horas"),
    CODE_713("713", "Rejeição: CNPJ do desenvolvedor do sistema inválido (zerado ou dígito inválido)"),
    CODE_714("714", "Rejeição: Município de encerramento inexistente"),
    CODE_715("715", "Rejeição: Não é permitido encerrar MDF-e com indicação de carregamento posterior sem inclusão de DF-e associada"),
    CODE_716("716", "Rejeição: CNPJ / CPF do responsável pela geração do CIOT inválido"),
    CODE_717("717", "Rejeição: CNPJ / CPF do contratante do transporte inválido"),
    CODE_718("718", "Rejeição: CNPJ / CPF do proprietário do veículo de tração inválido"),
    CODE_719("719", "Rejeição: CNPJ / CPF do proprietário do veículo reboque inválido"),
    CODE_720("720", "Rejeição: Obrigatória as informações do responsável técnico"),
    CODE_721("721", "Rejeição: Obrigatória a informação do identificador do CSRT e do Hash do CSRT"),
    CODE_722("722", "Rejeição: MDF-e deve ser do modal rodoviário para o evento Pagamento de MDF-e"),
    CODE_723("723", "Rejeição: O tipo do proprietário do MDF-e deve ser do tipo TAC Agregado"),
    CODE_724("724", "Rejeição: Grupo de informações do pagamento a prazo deve ser informado."),
    CODE_725("725", "Rejeição: Grupo produto predominante deve ser informado para modal rodoviário"),
    CODE_726("726", "Rejeição: O grupo de informações da carga lotação deve ser informado"),
    CODE_727("727", "Rejeição: CNPJ/CPF do responsável pelo pagamento do frete inválido."),
    CODE_728("728", "Rejeição: CNPJ da instituição de pagamento eletrônico do frete inválido."),
    CODE_729("729", "Rejeição: Grupo de informações do pagamento a prazo não deve ser informado."),
    CODE_735("735", "Rejeição: Número da parcela inválido."),
    CODE_736("736", "Rejeição: Data de vencimento da parcela menor que a data de emissão."),
    CODE_737("737", "Rejeição: Data de vencimento da parcela menor que a data da parcela anterior."),
    CODE_738("738", "Rejeição: Somatório do valor das parcelas diferente do valor do contrato."),
    CODE_739("739", "Rejeição: Valor do adiantamento não pode ser informado para pagamento à vista."),
    CODE_746("746", "Rejeição: A soma dos componentes do pagamento deve ser igual ao valor do contrato."),
    CODE_747("747", "Rejeição: MDFe deve ser do modal rodoviário para o evento Confirmação da operação de transporte."),
    CODE_748("748", "Rejeição: Contratante não relacionado no MDFe."),
    CODE_749("749", "Rejeição: MDFe deve ser do modal rodoviário para o evento de Alteração do Pagamento de MDFe."),
    CODE_997("997", "Rejeição: XML do MDF-e referenciado indisponível no momento da validação (Existem situações em que oambiente de autorização trabalha com um banco de dados separado para o arquivo XML)"),
    CODE_999("999", "Rejeição: Erro não catalogado (informar a msg de erro capturado no tratamento da exceção)");

    public static final Collection<MdfeReturnCode> authorized = Collections.singletonList(CODE_100);
    public static final Collection<MdfeReturnCode> general = Arrays.asList(CODE_101, CODE_135, CODE_136);
    private final String code;
    private final String description;

    public static boolean generateProc(MdfeReturnCode code) {
        return code.generateProc();
    }

    public static boolean generateProc(String code) {
        try {
            return generateProc(valueOfCode(code));
        } catch (NoEnumException e) {
            log.warn("no enum found for code " + e.getValue());
            return false;
        }
    }

    public static boolean generateProc(Number code) {
        return generateProc(Optional.ofNullable(code).map(Object::toString).orElse(null));
    }

    public static MdfeReturnCode valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

    public static MdfeReturnCode valueOfCode(Number code) {
        return valueOfCode(String.valueOf(code));
    }

    @Override
    public Collection<? extends ReturnCode> getDenied() {
        return Collections.emptyList();
    }

    @Override
    public Collection<? extends ReturnCode> getAuthorized() {
        return authorized;
    }

    @Override
    public Collection<? extends ReturnCode> getGeneral() {
        return general;
    }
}
