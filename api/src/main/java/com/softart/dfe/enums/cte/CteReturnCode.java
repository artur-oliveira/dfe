package com.softart.dfe.enums.cte;

import com.softart.dfe.components.internal.DFEnum;
import com.softart.dfe.interfaces.internal.ReturnCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Getter
public enum CteReturnCode implements ReturnCode {
    CODE_100("100", "Autorizado o uso do CT-e"),
    CODE_101("101", "Cancelamento de CT-e homologado"),
    CODE_102("102", "Inutilização de número homologado"),
    CODE_103("103", "Lote recebido com sucesso"),
    CODE_104("104", "Lote processado"),
    CODE_105("105", "Lote em processamento"),
    CODE_106("106", "Lote não localizado"),
    CODE_107("107", "Serviço em Operação"),
    CODE_108("108", "Serviço Paralisado Momentaneamente (curto prazo)"),
    CODE_109("109", "Serviço Paralisado sem Previsão"),
    CODE_110("110", "Uso Denegado"),
    CODE_113("113", "Serviço SVC em operação. Desativação prevista para a UF em dd/mm/aa, às hh:mm horas"),
    CODE_114("114", "SVC-[SP/RS] desabilitada pela SEFAZ de Origem"),
    CODE_134("134", "Evento registrado e vinculado ao CT-e com alerta para situação do documento. [Alerta Situação do CT-e: XXXXXXXXXX]"),
    CODE_135("135", "Evento registrado e vinculado a CT-e"),
    CODE_136("136", "Evento registrado, mas não vinculado a CT-e"),
    CODE_201("201", "Rejeição: O número máximo de numeração de CT-e a inutilizar ultrapassou o limite"),
    CODE_203("203", "Rejeição: Emissor não habilitado para emissão do CT-e"),
    CODE_204("204", "Rejeição: Duplicidade de CT-e [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_205("205", "Rejeição: CT-e está denegado na base de dados da SEFAZ"),
    CODE_206("206", "Rejeição: Número de CT-e já está inutilizado na Base de dados da SEFAZ"),
    CODE_207("207", "Rejeição: CNPJ do emitente inválido"),
    CODE_208("208", "Rejeição: CNPJ do destinatário inválido"),
    CODE_209("209", "Rejeição: IE do emitente inválida"),
    CODE_210("210", "Rejeição: IE do destinatário inválida"),
    CODE_212("212", "Rejeição: Data de emissão CT-e posterior a data de recebimento"),
    CODE_213("213", "Rejeição: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital"),
    CODE_214("214", "Rejeição: Tamanho da mensagem excedeu o limite estabelecido"),
    CODE_215("215", "Rejeição: Falha no schema XML"),
    CODE_216("216", "Rejeição: Chave de acesso difere da cadastrada"),
    CODE_217("217", "Rejeição: CT-e não consta na base de dados da SEFAZ"),
    CODE_218("218", "Rejeição: CT-e já está cancelado na base de dados da SEFAZ [nProt:999999999999999][dhCanc: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_219("219", "Rejeição: Circulação do CT-e verificada"),
    CODE_220("220", "Rejeição: CT-e autorizado há mais de 7 dias (168 horas)"),
    CODE_222("222", "Rejeição: Protocolo de Autorização de Uso difere do cadastrado"),
    CODE_223("223", "Rejeição: CNPJ do transmissor do lote difere do CNPJ do transmissor da consulta"),
    CODE_224("224", "Rejeição: A faixa inicial é maior que a faixa final"),
    CODE_225("225", "Rejeição: Falha no Schema XML do CT-e"),
    CODE_226("226", "Rejeição: Código da UF do Emitente diverge da UF autorizadora"),
    CODE_227("227", "Rejeição: Erro na composição do Campo ID"),
    CODE_228("228", "Rejeição: Data de Emissão muito atrasada"),
    CODE_229("229", "Rejeição: IE do emitente não informada"),
    CODE_230("230", "Rejeição: IE do emitente não cadastrada"),
    CODE_231("231", "Rejeição: IE do emitente não vinculada ao CNPJ"),
    CODE_232("232", "Rejeição: IE do destinatário não informada"),
    CODE_235("235", "Rejeição: Inscrição SUFRAMA inválida"),
    CODE_236("236", "Rejeição: Chave de Acesso inválida"),
    CODE_237("237", "Rejeição: CPF do destinatário inválido"),
    CODE_238("238", "Rejeição: Cabeçalho - Versão do arquivo XML superior a Versão vigente"),
    CODE_239("239", "Rejeição: Cabeçalho - Versão do arquivo XML não suportada"),
    CODE_240("240", "Rejeição: Cancelamento/Inutilização - Irregularidade Fiscal do Emitente"),
    CODE_241("241", "Rejeição: Um número da faixa já foi utilizado"),
    CODE_242("242", "Rejeição: Elemento cteCabecMsg inexistente no SOAP Header"),
    CODE_243("243", "Rejeição: XML Mal Formado"),
    CODE_244("244", "Rejeição: Falha na descompactação da área de dados"),
    CODE_247("247", "Rejeição: Sigla da UF do Emitente diverge da UF autorizadora"),
    CODE_248("248", "Rejeição: UF do Recibo diverge da UF autorizadora"),
    CODE_249("249", "Rejeição: UF da Chave de Acesso diverge da UF autorizadora"),
    CODE_250("250", "Rejeição: UF diverge da UF autorizadora"),
    CODE_251("251", "Rejeição: UF/Município destinatário não pertence a SUFRAMA"),
    CODE_252("252", "Rejeição: Ambiente informado diverge do Ambiente de recebimento"),
    CODE_253("253", "Rejeição: Dígito Verificador da chave de acesso composta inválido"),
    CODE_256("256", "Rejeição: Um número de CT-e da faixa está inutilizado na Base de dados da SEFAZ"),
    CODE_259("259", "Rejeição: CNPJ da consulta não cadastrado como contribuinte na UF"),
    CODE_267("267", "Rejeição: CT-e Complementar referência um CT-e inexistente"),
    CODE_269("269", "Rejeição: CNPJ Emitente do CT-e Complementar difere do CNPJ do CT complementado"),
    CODE_280("280", "Rejeição: Certificado Transmissor inválido"),
    CODE_281("281", "Rejeição: Certificado Transmissor Data Validade"),
    CODE_282("282", "Rejeição: Certificado Transmissor sem CNPJ"),
    CODE_283("283", "Rejeição: Certificado Transmissor - erro Cadeia de Certificação"),
    CODE_284("284", "Rejeição: Certificado Transmissor revogado"),
    CODE_285("285", "Rejeição: Certificado Transmissor difere ICP-Brasil"),
    CODE_286("286", "Rejeição: Certificado Transmissor erro no acesso a LCR"),
    CODE_290("290", "Rejeição: Certificado Assinatura inválido"),
    CODE_291("291", "Rejeição: Certificado Assinatura Data Validade"),
    CODE_292("292", "Rejeição: Certificado Assinatura sem CNPJ"),
    CODE_293("293", "Rejeição: Certificado Assinatura - erro Cadeia de Certificação"),
    CODE_294("294", "Rejeição: Certificado Assinatura revogado"),
    CODE_295("295", "Rejeição: Certificado Assinatura difere ICP-Brasil"),
    CODE_296("296", "Rejeição: Certificado Assinatura erro no acesso a LCR"),
    CODE_297("297", "Rejeição: Assinatura difere do calculado"),
    CODE_298("298", "Rejeição: Assinatura difere do padrão do Projeto"),
    CODE_301("301", "Uso Denegado: Irregularidade fiscal do emitente"),
    CODE_402("402", "Rejeição: XML da área de dados com codificação diferente de UTF-8"),
    CODE_404("404", "Rejeição: Uso de prefixo de namespace não permitido"),
    CODE_408("408", "Rejeição: Lote com CT-e de diferentes UF"),
    CODE_409("409", "Rejeição: Campo cUF inexistente no elemento cteCabecMsg do SOAP Header"),
    CODE_410("410", "Rejeição: UF informada no campo cUF não é atendida pelo WebService"),
    CODE_411("411", "Rejeição: Campo versaoDados inexistente no elemento cteCabecMsg do SOAP Header"),
    CODE_414("414", "Rejeição: Código de Município diverge da UF de término da prestação"),
    CODE_415("415", "Rejeição: CNPJ do remetente inválido"),
    CODE_416("416", "Rejeição: CPF do remetente inválido"),
    CODE_418("418", "Rejeição: Código de Município diverge da UF de localização remetente"),
    CODE_419("419", "Rejeição: IE do remetente inválida"),
    CODE_421("421", "Rejeição: IE do remetente não cadastrada"),
    CODE_422("422", "Rejeição: IE do remetente não vinculada ao CNPJ"),
    CODE_424("424", "Rejeição: Código de Município diverge da UF de localização destinatário"),
    CODE_426("426", "Rejeição: IE do destinatário não cadastrada"),
    CODE_427("427", "Rejeição: IE do destinatário não vinculada ao CNPJ"),
    CODE_428("428", "Rejeição: CNPJ do expedidor inválido"),
    CODE_429("429", "Rejeição: CPF do expedidor inválido"),
    CODE_431("431", "Rejeição: Código de Município diverge da UF de localização expedidor"),
    CODE_432("432", "Rejeição: IE do expedidor inválida"),
    CODE_434("434", "Rejeição: IE do expedidor não cadastrada"),
    CODE_435("435", "Rejeição: IE do expedidor não vinculada ao CNPJ"),
    CODE_436("436", "Rejeição: CNPJ do recebedor inválido"),
    CODE_437("437", "Rejeição: CPF do recebedor inválido"),
    CODE_439("439", "Rejeição: Código de Município diverge da UF de localização recebedor"),
    CODE_440("440", "Rejeição: IE do recebedor inválida"),
    CODE_442("442", "Rejeição: IE do recebedor não cadastrada"),
    CODE_443("443", "Rejeição: IE do recebedor não vinculada ao CNPJ"),
    CODE_444("444", "Rejeição: CNPJ do tomador inválido"),
    CODE_445("445", "Rejeição: CPF do tomador inválido"),
    CODE_447("447", "Rejeição: Código de Município diverge da UF de localização tomador"),
    CODE_448("448", "Rejeição: IE do tomador inválida"),
    CODE_456("456", "Rejeição: Código de Município diverge da UF de início da prestação"),
    CODE_457("457", "Rejeição: O lote contém CT-e de mais de um estabelecimento emissor"),
    CODE_458("458", "Rejeição: Grupo de CT-e normal não informado para CT-e normal"),
    CODE_459("459", "Rejeição: Grupo de CT-e complementar não informado para CT-e complementar"),
    CODE_460("460", "Rejeição: Não informado os dados do remetente indicado como tomador do serviço"),
    CODE_461("461", "Rejeição: Não informado os dados do expedidor indicado como tomador do serviço"),
    CODE_462("462", "Rejeição: Não informado os dados do recebedor indicado como tomador do serviço"),
    CODE_463("463", "Rejeição: Não informado os dados do destinatário indicado como tomador do serviço"),
    CODE_469("469", "Rejeição: Remetente deve ser informado para tipo de serviço diferente de redespacho intermediário ou Serviço vinculado a multimodal"),
    CODE_470("470", "Rejeição: Destinatário deve ser informado para tipo de serviço diferente de redespacho intermediário ou serviço vinculado a multimodal"),
    CODE_471("471", "Rejeição: Ano de inutilização não pode ser superior ao Ano atual"),
    CODE_472("472", "Rejeição: Ano de inutilização não pode ser inferior a 2008"),
    CODE_473("473", "Rejeição: Tipo Autorizador do Recibo diverge do Órgão Autorizador"),
    CODE_474("474", "Rejeição: Expedidor deve ser informado para tipo de serviço de redespacho intermediário e serviço vinculado a multimodal"),
    CODE_475("475", "Rejeição: Recebedor deve ser informado para tipo de serviço de redespacho intermediário e serviço vinculado a multimodal"),
    CODE_481("481", "Rejeição: IE deve ser informada para tomador Contribuinte"),
    CODE_482("482", "Rejeição: IE do tomador isento deve ser preenchida com “ISENTO”"),
    CODE_489("489", "Rejeição: IE do tomador não cadastrada"),
    CODE_490("490", "Rejeição: IE do tomador não vinculada ao CNPJ"),
    CODE_491("491", "Rejeição: CT-e complementado é diferente de Normal ou Substituição"),
    CODE_493("493", "Rejeição: Código de Município diverge da UF de envio"),
    CODE_496("496", "Rejeição: Grupo CT-e de Anulação não informado para o CT-e de Anulação"),
    CODE_497("497", "Rejeição: CT-e objeto da anulação inexistente"),
    CODE_498("498", "Rejeição: CT-e objeto da anulação deve estar com a situação autorizada (não pode estar cancelado ou denegado)"),
    CODE_499("499", "Rejeição: CT-e de anulação deve ter tipo de emissão = normal"),
    CODE_500("500", "Rejeição: CT-e objeto da anulação deve ter Tipo = 0 (normal) ou 3 (Substituição)"),
    CODE_501("501", "Rejeição: Autorização do CT-e de Anulação deve ocorrer em até 60 dias da data de autorização do CT-e objeto de anulação"),
    CODE_502("502", "Rejeição: CT-e de anulação deve ter o valor do ICMS e de prestação iguais ao CT-e original"),
    CODE_503("503", "Rejeição: CT-e substituto deve ter tipo de emissão = normal"),
    CODE_505("505", "Rejeição: Grupo CT-e de Substituição não informado para o CT-e de Substituição"),
    CODE_510("510", "Rejeição: CNPJ do emitente do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_511("511", "Rejeição: CNPJ/CPF do remetente do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_512("512", "Rejeição: CNPJ/CPF do destinatário do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_513("513", "Rejeição: UF nao atendida pela SVC-[SP/RS]"),
    CODE_515("515", "Rejeição: O tpEmis informado só é válido na contingência SVC"),
    CODE_516("516", "Rejeição: O tpEmis informado é incompatível com SVC-[SP/RS]"),
    CODE_517("517", "Rejeição: CT-e informado em SVC deve ser Normal"),
    CODE_518("518", "Rejeição: Serviço indisponível na SVC"),
    CODE_519("519", "Rejeição: CFOP inválido para operação"),
    CODE_520("520", "Rejeição: CT-e não pode receber mais do que 10 CT-e Complementares"),
    CODE_521("521", "Rejeição: Os documentos de transporte anterior devem ser informados para os tipos de serviço Subcontratação, Redespacho e Redespacho Intermediário"),
    CODE_522("522", "Rejeição: Nro Item Alterado inválido. Preencher com valor numérico (01 – 99)"),
    CODE_523("523", "Rejeição: Vedado cancelamento quando existir evento Carta de Correção"),
    CODE_524("524", "Rejeição: CFOP inválido, informar 5932 ou 6932"),
    CODE_525("525", "Rejeição: Carta de correção inválida (campo/grupo “xxxx” informado não existe no schema do CT-e ou não existe no grupo informado)"),
    CODE_526("526", "Rejeição: Preencher informações dos containers somente para redespacho intermediário e serviço vinculado a multimodal"),
    CODE_527("527", "Rejeição: NF-e duplicada no CT-e [chNFe: 99999999999999999999999999999999999999999999]"),
    CODE_528("528", "Rejeição: Vedado cancelamento se exitir MDF-e autorizado para o CT-e"),
    CODE_530("530", "Rejeição: Se ambiente SVC, rejeitar eventos diferentes de EPEC, Liberação EPEC e Cancelamento"),
    CODE_531("531", "Rejeição: Valor a receber deve ser menor ou igual Valor da Prestação"),
    CODE_532("532", "Rejeição: Município do Remetente inexistente"),
    CODE_533("533", "Rejeição: Município do Destinatário inexistente"),
    CODE_534("534", "Rejeição: Município do Expedidor inexistente"),
    CODE_535("535", "Rejeição: Município do Recebedor inexistente"),
    CODE_536("536", "Rejeição: Município do Tomador inexistente"),
    CODE_537("537", "Rejeição: Município de Envio inexistente"),
    CODE_539("539", "Rejeição: Duplicidade de CT-e, com diferença na Chave de Acesso [chCTe: [9999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_540("540", "Rejeição: Grupo de documentos informado inválido para remetente que emite NF-e"),
    CODE_541("541", "Rejeição: Município de início da prestação inexistente"),
    CODE_542("542", "Rejeição: Município de término da prestação inexistente"),
    CODE_543("543", "Rejeição: Chave de CT-e duplicada em documentos anteriores"),
    CODE_550("550", "Rejeição: O CNPJ/CPF do expedidor do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_551("551", "Rejeição: O CNPJ/CPF do recebedor do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_552("552", "Rejeição: O CNPJ/CPF do tomador do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_553("553", "Rejeição: A IE do emitente do CT-e substituto deve ser igual ao informado no CT-e substituído"),
    CODE_559("559", "Rejeição: A UF de início da prestação deve ser igual ao informado no CT-e substituído"),
    CODE_560("560", "Rejeição: A UF de fim da prestação deve ser igual ao informado no CT-e substituído"),
    CODE_563("563", "Rejeição: A substituição de um CT-e deve ocorrer no prazo máximo de 60 dias contados da data de autorização do CT-e objeto de Substituição"),
    CODE_564("564", "Rejeição: O CT-e de anulação não pode ser cancelado"),
    CODE_565("565", "Rejeição: O CT-e só pode ser anulado pelo emitente"),
    CODE_566("566", "Rejeição: CT-e objeto da anulação não pode ter sido anulado anteriormente"),
    CODE_567("567", "Rejeição: CT-e objeto da anulação não pode ter sido substituído anteriormente"),
    CODE_568("568", "Rejeição: CT-e a ser substituído inexistente"),
    CODE_569("569", "Rejeição: CT-e a ser substituído deve estar com a situação autorizada (não pode estar cancelado ou denegado)"),
    CODE_570("570", "Rejeição: CT-e a ser substituído não pode ter sido substituído anteriormente"),
    CODE_571("571", "Rejeição: CT-e a ser substituído deve ter Tipo = 0 (normal) ou 3 (Substituição)"),
    CODE_572("572", "Rejeição: CT-e de anulação inexistente"),
    CODE_573("573", "Rejeição: CT-e de anulação informado deve ter Tipo=2(Anulação)"),
    CODE_574("574", "Rejeição: Vedado o cancelamento de CT-e do tipo substituto (tipo=3)"),
    CODE_575("575", "Rejeição: Vedado o cancelamento se possuir CT-e de Anulação associado"),
    CODE_576("576", "Rejeição: Vedado o cancelamento se possuir CT-e de Substituição associado"),
    CODE_577("577", "Rejeição: CT-e a ser substituído não pode ter sido anulado anteriormente quando informados os documentos emitidos pelo tomador contribuinte"),
    CODE_578("578", "Rejeição: Chave de acesso do CT-e anulado deve ser igual ao substituído"),
    CODE_579("579", "Rejeição: Versão informada para o modal não suportada"),
    CODE_580("580", "Rejeição: Falha no Schema XML específico para o modal"),
    CODE_581("581", "Rejeição: Campo Valor da Carga deve ser informado para o modal"),
    CODE_582("582", "Rejeição: Grupo Tráfego Mútuo deve ser informado"),
    CODE_583("583", "Rejeição: Ferrovia emitente deve ser a de origem quando respFat=1"),
    CODE_584("584", "Rejeição: Referenciar o CT-e que foi emitido pela ferrovia de origem"),
    CODE_585("585", "Rejeição: IE Emitente não autorizada a emitir CT-e para o modal informado"),
    CODE_586("586", "Rejeição: Data e Justificativa de entrada em contingência não devem ser informadas para tipo de emissão diferente de FS-DA."),
    CODE_587("587", "Rejeição: Data e Justificativa de entrada em contingência devem ser informadas"),
    CODE_588("588", "Rejeição: Data de entrada em contingência posterior a data de emissão."),
    CODE_589("589", "Rejeição: O lote contém CT-e de mais de um modal"),
    CODE_590("590", "Rejeição: O lote contém CT-e de mais de uma versão de modal"),
    CODE_598("598", "Rejeição: Usar somente o namespace padrao do CT-e"),
    CODE_599("599", "Rejeição: Não é permitida a presença de caracteres de edição no início/fim da mensagem ou entre as tags da mensagem"),
    CODE_600("600", "Rejeição: Chave de Acesso difere da existente em BD"),
    CODE_601("601", "Rejeição: Quantidade de documentos informados no remetente excede limite de 2000"),
    CODE_614("614", "Rejeição: IE do Substituto Tributário inválida"),
    CODE_617("617", "Rejeição: UF do tomador não aceita ISENTO com Inscrição Estadual"),
    CODE_618("618", "Rejeição: GTV informada em duplicidade no evento"),
    CODE_619("619", "Rejeição: GTV já informada em outro evento para o mesmo CT-e"),
    CODE_627("627", "Rejeição: CNPJ do autor do evento inválido"),
    CODE_628("628", "Rejeição: Erro Atributo ID do evento não corresponde a concatenação dos campos (“ID” + tpEvento + chCTe + nSeqEvento)"),
    CODE_629("629", "Rejeição: O tpEvento informado inválido"),
    CODE_630("630", "Rejeição: Falha no Schema XML específico para o evento"),
    CODE_631("631", "Rejeição: Duplicidade de evento [nProt:999999999999999][dhRegEvento: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_632("632", "Rejeição: O autor do evento diverge do emissor do CT-e"),
    CODE_633("633", "Rejeição: O autor do evento não é um órgão autorizado a gerar o evento"),
    CODE_634("634", "Rejeição: A data do evento não pode ser menor que a data de emissão do CT-e"),
    CODE_635("635", "Rejeição: A data do evento não pode ser maior que a data do processamento"),
    CODE_636("636", "Rejeição: O número sequencial do evento é maior que o permitido"),
    CODE_637("637", "Rejeição: A data do evento não pode ser menor que a data de autorização do CT-e"),
    CODE_638("638", "Rejeição: Já existe CT-e autorizado com esta numeração"),
    CODE_639("639", "Rejeição: Existe EPEC emitido há mais de 7 dias (168h) sem a emissão do CT-e no ambiente normal de autorização"),
    CODE_640("640", "Rejeição: Tipo de emissão do CT-e difere de EPEC com EPEC autorizado na SVC-XX para este documento."),
    CODE_641("641", "Rejeição: O evento prévio deste CT-e não foi autorizado na SVC ou ainda não foi sincronizado. [OBS: Em caso de atraso na sincronização, favor aguardar alguns instantes para nova tentativa de transmissão]"),
    CODE_642("642", "Rejeição: Os valores de ICMS, ICMS ST, Prestação e Total da Carga do CT-e devem ser iguais aos informados no EPEC."),
    CODE_643("643", "Rejeição: As informações do tomador de serviço do CT-e devem ser iguais as informadas no EPEC"),
    CODE_644("644", "Rejeição: A informação do modal do CT-e deve ser igual a informada no EPEC"),
    CODE_645("645", "Rejeição: A UF de início e fim de prestação do CT-e devem ser iguais as informadas no EPEC."),
    CODE_646("646", "Rejeição: CT-e emitido em ambiente de homologação com Razão Social do remetente diferente de CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"),
    CODE_647("647", "Rejeição: CT-e emitido em ambiente de homologação com Razão Social do expedidor diferente de CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"),
    CODE_648("648", "Rejeição: CT-e emitido em ambiente de homologação com Razão Social do recebedor diferente de CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"),
    CODE_649("649", "Rejeição: CT-e emitido em ambiente de homologação com Razão Social do destinatário diferente de CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL"),
    CODE_650("650", "Rejeição: Valor total do serviço superior ao limite permitido (R$ 9.999.999,99)"),
    CODE_651("651", "Rejeição: Referenciar o CT-e Multimodal que foi emitido pelo OTM"),
    CODE_652("652", "Rejeição: NF-e não pode estar cancelada ou denegada"),
    CODE_653("653", "Rejeição: Tipo de evento não é permitido em ambiente de autorização Normal"),
    CODE_654("654", "Rejeição: Tipo de evento não é permitido em ambiente de autorização SVC"),
    CODE_655("655", "Rejeição: CT-e complementado deve estar com a situação autorizada (não pode estar cancelado ou denegado)"),
    CODE_656("656", "Rejeição: CT-e complementado não pode ter sido anulado"),
    CODE_657("657", "Rejeição: CT-e complementado não pode ter sido substituído"),
    CODE_658("658", "Rejeição: CT-e objeto da anulação não pode ter sido complementado"),
    CODE_659("659", "Rejeição: CT-e substituído não pode ter sido complementado"),
    CODE_660("660", "Rejeição: Vedado o cancelamento se possuir CT-e Complementar associado"),
    CODE_661("661", "Rejeição: NF-e inexistente na base de dados da SEFAZ"),
    CODE_662("662", "Rejeição: NF-e com diferença de Chave de Acesso"),
    CODE_664("664", "Rejeição: Evento não permitido para CT-e Substituído/Anulado"),
    CODE_667("667", "Rejeição: CNPJ-Base do Tomador deve ser igual ao CNPJ-Base do Emitente do CT-e multimodal [chCTe: 99999999999999999999999999999999999999999999]"),
    CODE_670("670", "Rejeição: Série utilizada não permitida no webservice"),
    CODE_671("671", "Rejeição: CT-e complementado no CT-e complementar com diferença de Chave de Acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_672("672", "Rejeição: CT-e de Anulação com diferença de Chave de Acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]."),
    CODE_673("673", "Rejeição: CT-e substituído com diferença de Chave de Acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_674("674", "Rejeição: CT-e Objeto de Anulação com diferença de Chave de Acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_675("675", "Rejeição: Valor do imposto não corresponde à base de cálculo X alíquota"),
    CODE_676("676", "Rejeição: CFOP informado inválido"),
    CODE_677("677", "Rejeição: Órgão de recepção do evento inválido"),
    CODE_678("678", "Rejeição: Consumo Indevido [Descrição: XXXXXXXXXXXXXXXXXXXXXXXXXXXX]"),
    CODE_679("679", "Rejeição: O modal do CT-e deve ser Multimodal para Evento Registros do Multimodal"),
    CODE_680("680", "Rejeição: Tipo de Emissão diferente de EPEC"),
    CODE_681("681", "Rejeição: Informação não pode ser alterada por carta de correção"),
    CODE_682("682", "Rejeição: Já existe pedido de inutilização com a mesma faixa de inutilização  [nProt:999999999999999]"),
    CODE_690("690", "Rejeição: CT-e multimodal referenciado inexistente na base de dados da SEFAZ [chCTe: 99999999999999999999999999999999999999999999]"),
    CODE_691("691", "Rejeição: CT-e multimodal referenciado existe com diferença de chave de acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_692("692", "Rejeição: CT-e multimodal referenciado não pode estar cancelado ou denegado [chCTe: 99999999999999999999999999999999999999999999]"),
    CODE_693("693", "Rejeição: Grupo Documentos Transportados deve ser informado para tipo de serviço diferente de redespacho intermediário e serviço vinculado a multimodal"),
    CODE_694("694", "Rejeição: Grupo Documentos Transportados não pode ser informado para tipo de serviço redespacho intermediário e serviço vinculado a multimodal"),
    CODE_695("695", "Rejeição: CT-e com emissão anterior ao evento prévio (EPEC)"),
    CODE_696("696", "Rejeição: Existe EPEC aguardando CT-e nessa faixa de numeração"),
    CODE_697("697", "Rejeição: Data de emissão do CT-e deve ser menor igual à data de autorização da EPEC"),
    CODE_698("698", "Rejeição: Evento Prévio autorizado há mais de 7 dias (168 horas)"),
    CODE_699("699", "Rejeição: CNPJ autorizado para download inválido"),
    CODE_700("700", "Rejeição: CPF autorizado para download inválido"),
    CODE_709("709", "Rejeição: CT-e da Ferrovia de Origem referenciado inexistente na base de dados da SEFAZ"),
    CODE_710("710", "Rejeição: CT-e da Ferrovia de Origem referenciado existe com diferença de chave de acesso"),
    CODE_711("711", "Rejeição: CT-e da Ferrovia de Origem referenciado não pode estar cancelado ou denegado"),
    CODE_712("712", "Rejeição: Código de Município diverge da UF de localização do emitente"),
    CODE_713("713", "Rejeição: Município do Emitente inexistente"),
    CODE_714("714", "Rejeição: Chave de CT-e duplicada na relação de CT-e Multimodal"),
    CODE_715("715", "Rejeição: Documento autorizado ao XML duplicado no CT-e"),
    CODE_716("716", "Rejeição: IE do Remetente não informada"),
    CODE_717("717", "Rejeição: IE do Expedidor não informada"),
    CODE_718("718", "Rejeição: IE do Recebedor não informada"),
    CODE_719("719", "Rejeição: IE do Tomador não informada"),
    CODE_720("720", "Rejeição: CT-e EPEC deve ser do tipo Normal"),
    CODE_721("721", "Rejeição: Chave de acesso inválida (modelo diferente de 67)"),
    CODE_722("722", "Rejeição: Tomador do serviço deve ser remetente ou destinatário para CT-e Globalizado"),
    CODE_723("723", "Rejeição: CT-e Globalizado deve conter apenas NF-e nos documentos transportados"),
    CODE_724("724", "Rejeição: CT-e Globalizado deve conter NF-e com CNPJ diferentes para múltiplos remetentes"),
    CODE_725("725", "Rejeição: Razão Social do Remetente do CT-e Globalizado inválido"),
    CODE_726("726", "Rejeição: Razão Social do Destinatário do CT-e Globalizado inválido"),
    CODE_727("727", "Rejeição: CNPJ do remetente do CT-e Globalizado deve ser o mesmo do emitente do CT-e"),
    CODE_728("728", "Rejeição: CNPJ do destinatário do CT-e Globalizado deve ser o mesmo do emitente do CT-e"),
    CODE_729("729", "Rejeição: NF-e de múltiplos emitentes informadas nos documentos transportados sem indicador de CT-e Globalizado"),
    CODE_730("730", "Rejeição: Razão Social inválida para remetente/destinatário sem indicador de CT-e Globalizado"),
    CODE_731("731", "Rejeição: Consulta a uma Chave de Acesso muito antiga"),
    CODE_732("732", "Rejeição: Chave de acesso inválida (modelo diferente de 57)"),
    CODE_733("733", "Rejeição: CNPJ do documento anterior deve ser o mesmo indicado no grupo emiDocAnt"),
    CODE_734("734", "Rejeição: As NF-e transportadas do CT-e substituto devem ser iguais às informadas no CT-e substituído"),
    CODE_735("735", "Rejeição: CT-e de anulação para CT-e com tomador contribuinte exige evento de Prestação de Serviço em Desacordo"),
    CODE_737("737", "Rejeição: O CT-e globalizado deve conter pelo menos 5 NF-e para o mesmo emitente"),
    CODE_738("738", "Rejeição: A indicação do tomador do CT-e de substituição deve ser igual à do CT-e substituído"),
    CODE_739("739", "Rejeição: O CT-e substituído deve possuir evento de Prestação do Serviço em Desacordo para alteração de tomador"),
    CODE_740("740", "Rejeição: O CNPJ base do tomador do CT-e substituto deve estar relacionado nos papéis do CT-e substituído para a alteração de tomador"),
    CODE_741("741", "Rejeição: A UF do CT-e substituto deve ser a mesma do tomador do CT-e substituído para alteração de tomador"),
    CODE_742("742", "Rejeição: Tomador do CT-e substituto igual ao informado no CT-e substituído para operação de alteração de tomador"),
    CODE_743("743", "Rejeição: CT-e Globalizado não pode ser utilizado para operação interestadual"),
    CODE_744("744", "Rejeição: CT-e Globalizado para tomador remetente com NF-e de emitentes diferentes"),
    CODE_745("745", "Rejeição: CNPJ base do tomador deve ser igual ao CNPJ base indicado no grupo emiDocAnt"),
    CODE_746("746", "Rejeição: Tipo de Serviço inválido para o tomador informado"),
    CODE_747("747", "Rejeição: Documentos anteriores informados para Tipo de Serviço Normal"),
    CODE_748("748", "Rejeição: CT-e referenciado em documentos anteriores inexistente na base de dados da SEFAZ"),
    CODE_749("749", "Rejeição: CT-e referenciado em documentos anteriores existe com diferença de chave de acesso"),
    CODE_750("750", "Rejeição: CT-e referenciado em documentos anteriores não pode estar cancelado ou denegado"),
    CODE_751("751", "Rejeição: UF de início e Fim da prestação devem estar preenchidas para Transporte de Pessoas"),
    CODE_752("752", "Rejeição: Município de início e Fim da prestação devem estar preenchidos para Transporte de Pessoas"),
    CODE_753("753", "Rejeição: Percurso inválido"),
    CODE_754("754", "Rejeição: Os documentos referenciados devem estar preenchidos para excesso de bagagem"),
    CODE_755("755", "Rejeição: Autor do evento prestação do serviço em desacordo deve ser o tomador do serviço do CT-e"),
    CODE_756("756", "Rejeição: Data de emissão do CT-e deve ser igual à data de emissão da EPEC"),
    CODE_757("757", "Rejeição: O tomador do serviço deve estar informado para Transporte de Pessoas e Valores"),
    CODE_758("758", "Rejeição: Existe CT-e OS de Transporte de Valores autorizado há mais de 45 dias sem informar as GTV [chCTe: 99999999999999999999999999999999999999999999]"),
    CODE_760("760", "Rejeição: INSS deve ser preenchido para tomador pessoa jurídica"),
    CODE_786("786", "Rejeição: Grupo de informações da partilha com a UF de fim da prestação deve estar preenchido"),
    CODE_787("787", "Rejeição: Data do evento de Prestação do Serviço em desacordo deve ocorrer em até 45 dias da autorização do CT-e"),
    CODE_798("798", "Rejeição: Os dados específicos do modal devem estar preenchidos para Transporte de Pessoas e Excesso de Bagagem"),
    CODE_799("799", "Rejeição: Identificação do tomador utilizada em outro papel no CT-e (CNPJ/CPF ou IE)"),
    CODE_800("800", "Rejeição: CNPJ/CPF do remetente do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_801("801", "Rejeição: CNPJ/CPF do destinatário do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_802("802", "Rejeição: O CNPJ/CPF do expedidor do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_803("803", "Rejeição: O CNPJ/CPF do recebedor do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_804("804", "Rejeição: O CNPJ/CPF do tomador do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_805("805", "Rejeição: A IE do emitente do CT-e complementar deve ser igual ao informado no CT-e complementado"),
    CODE_811("811", "Rejeição: A UF de início da prestação deve ser igual ao informado no CT-e complementado"),
    CODE_812("812", "Rejeição: A UF de fim da prestação deve ser igual ao informado no CT-e complementado"),
    CODE_813("813", "Rejeição: Tipo de Documento inválido para operação interestadual"),
    CODE_814("814", "Rejeição: Não devem ser informados CT-e Multimodais para Tipo de Serviço diferente de Serviço Vinculado a Multimodal"),
    CODE_815("815", "Rejeição: Não é permitido referenciar CT-e cancelado para este tipo de serviço"),
    CODE_824("824", "Rejeição: CT-e referenciado inexistente na base de dados da SEFAZ"),
    CODE_825("825", "Rejeição: CT-e referenciado existe com diferença de chave de acesso [chCTe: 99999999999999999999999999999999999999999999] [nProt:999999999999999][dhAut: AAAA-MM-DDTHH:MM:SS TZD]"),
    CODE_826("826", "Rejeição: CT-e referenciado deve estar cancelado"),
    CODE_827("827", "Rejeição: CT-e referenciado deve ser do mesmo emitente do CT-e"),
    CODE_828("828", "Rejeição: CNPJ/CPF autorizado já declarado no CT-e (remet/dest/exped/receb/tom)"),
    CODE_829("829", "Rejeição: Grupo infModal não deve ser preenchido"),
    CODE_830("830", "Rejeição: CT-e referenciado deve ser do mesmo tipo de serviço"),
    CODE_831("831", "Rejeição: Número do Registro Estadual Inválido"),
    CODE_832("832", "Rejeição: Município de início e fim de prestação do CT-e de subcontratação devem ser iguais ao CT-e subcontratado"),
    CODE_833("833", "Rejeição: O tipo de serviço do CT-e de anulação deve ser igual ao CT-e original"),
    CODE_834("834", "Rejeição: O tipo de serviço do CT-e de substituição deve ser igual ao CT-e substituído"),
    CODE_835("835", "Rejeição: O tipo de serviço do CT-e complementar deve ser igual ao CT-e complementado"),
    CODE_836("836", "Rejeição: CNPJ do desenvolvedor do sistema inválido (zerado ou dígito inválido)"),
    CODE_837("837", "Rejeição: Data e hora da viagem deve ser informada para tipo de fretamento eventual"),
    CODE_838("838", "Rejeição: Data e hora da viagem deve ser superior a data de emissão do CT-e"),
    CODE_839("839", "Rejeição: Número do Registro Estadual é obrigatório para transporte de pessoas rodoviário nas operações internas."),
    CODE_840("840", "Rejeição: Termo de Autorização de Fretamento é obrigatório para transporte de pessoas rodoviário interestadual"),
    CODE_841("841", "Rejeição: Informação do fretamento é obrigatória para transporte de pessoas"),
    CODE_842("842", "Rejeição: Chave de acesso do CT-e da Ferrovia de Origem inválida"),
    CODE_843("843", "Rejeição: Chave de acesso da NF-e transportada inválida"),
    CODE_844("844", "Rejeição: Chave de acesso do CT-e anterior inválida"),
    CODE_845("845", "Rejeição: Chave de acesso do CT-e multimodal inválida"),
    CODE_846("846", "Rejeição: Chave de acesso do CT-e objeto da anulação inválida"),
    CODE_847("847", "Rejeição: Chave de acesso do CT-e substituído inválida"),
    CODE_848("848", "Rejeição: Chave de acesso do CT-e de anulação inválida"),
    CODE_849("849", "Rejeição: Chave de acesso do CT-e complementado inválida"),
    CODE_850("850", "Rejeição: O QR Code do CT-e deve ser informado"),
    CODE_851("851", "Rejeição: Endereço do site da UF da Consulta via QR Code diverge do previsto"),
    CODE_852("852", "Rejeição: Parâmetro chave de acesso do QR Code divergente do CT-e"),
    CODE_853("853", "Rejeição: Parâmetro sign não informado no QR Code para emissão em contingência"),
    CODE_854("854", "Rejeição: Parâmetro sign não deve ser informado no QR Code para emissão Normal"),
    CODE_855("855", "Rejeição: Assinatura do QR-Code difere do calculado"),
    CODE_856("856", "Rejeição: Chave de acesso do CT-e referenciado inválida"),
    CODE_857("857", "Rejeição: Chave de acesso do CT-e OS objeto da anulação inválida"),
    CODE_858("858", "Rejeição: Chave de acesso do CT-e OS substituído inválida"),
    CODE_859("859", "Rejeição: Chave de acesso do CT-e OS complementado inválida"),
    CODE_860("860", "Rejeição: Chave de acesso da NF-e indicada no comprovante de entrega inválida"),
    CODE_861("861", "Rejeição: NF-e em duplicidade no evento comprovante de entrega"),
    CODE_862("862", "Rejeição: Vedado o cancelamento quando houver evento de Comprovante de Entrega associado"),
    CODE_863("863", "Rejeição: NF-e já possui comprovante de entrega para este CT-e"),
    CODE_864("864", "Rejeição: NF-e não possui relação com este CT-e"),
    CODE_865("865", "Rejeição: Comprovante de entrega deve relacionar NF-e para CT-e de tipo de serviço Normal"),
    CODE_866("866", "Rejeição:Protocolo do evento a ser cancelado não existe, não está associado ao CT-e ou já está cancelado"),
    CODE_867("867", "Rejeição: Obrigatória as informações do responsável técnico"),
    CODE_868("868", "Rejeição: Obrigatória a informação do identificador do CSRT e do Hash do CSRT"),
    CODE_869("869", "Rejeição: Evento não permitido para CT-e Complementar ou Anulação"),
    CODE_870("870", "Rejeição: Não é permitido mais de um comprovante de entrega para CT-e (exceto CT-e Globalizado)"),
    CODE_871("871", "Rejeição: Comprovante de entrega não pode informar NF-e para CT-e de tipo de serviço diferente de Normal"),
    CODE_872("872", "Rejeição: Data e hora da entrega inválida"),
    CODE_873("873", "Rejeição: Data e hora do hash do comprovante de entrega inválida"),
    CODE_997("997", "Rejeição: XML do CT-e referenciado indisponível no momento da validação (Existem situações em que o ambiente de autorização trabalha com um banco de dados separado para o arquivo XML)"),
    CODE_999("999", "Rejeição: Erro não catalogado (informar a mensagem de erro capturado no tratamento da exceção)");

    public static final Collection<CteReturnCode> denied = Arrays.asList(CODE_110, CODE_301);
    public static final Collection<CteReturnCode> authorized = Collections.singletonList(CODE_100);
    public static final Collection<CteReturnCode> general = Arrays.asList(CODE_101, CODE_102, CODE_135, CODE_136);
    private final String code;
    private final String description;

    CteReturnCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static boolean generateProc(CteReturnCode code) {
        return code.generateProc();
    }

    public static boolean generateProc(String code) {
        return valueOfCode(code).generateProc();
    }

    public static boolean generateProc(Number code) {
        return valueOfCode(code).generateProc();
    }

    public static CteReturnCode valueOfCode(String code) {
        return DFEnum.valueOfCode(values(), code);
    }

    public static CteReturnCode valueOfCode(Number code) {
        return valueOfCode(String.valueOf(code));
    }

    @Override
    public Collection<? extends ReturnCode> getDenied() {
        return denied;
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
