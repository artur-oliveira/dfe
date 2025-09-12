package org.dfe.components.validation.nf;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import org.dfe.components.internal.xml.validation.XMLValidatorFactory;
import org.dfe.enums.nf.NFEvent;
import org.dfe.exceptions.ValidationException;
import org.dfe.interfaces.validation.nf.common.NfEventValidator;
import org.dfe.models.internal.Validation;
import org.dfe.models.internal.xml.XMLValidation;
import org.dfe.util.XMLUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

final class XSDEventValidator implements NfEventValidator {

    private final static Map<String, String> eventsAndTagNames;

    static {
        eventsAndTagNames = Map.ofEntries(
                Map.entry("110001", "detEventoCancEv"),
                Map.entry("110110", "detEventoCCe"),
                Map.entry("110111", "detEventoCanc"),
                Map.entry("110112", "detEventoCancSubs"),
                Map.entry("110130", "detEventoCompEntreg"),
                Map.entry("110140", "detEventoEPEC"),
                Map.entry("110150", "detEventoAtorInteressado"),
                Map.entry("112110", "detEventoPagIntegral"),
                Map.entry("112120", "detEventoImpALCZFM"),
                Map.entry("112130", "detEventoPercPerdRouboFornecedor"),
                Map.entry("112140", "detEventoFornecimentoNaoRealizado"),
                Map.entry("210200", "detEventoManifestacao"),
                Map.entry("211110", "detEventoSolicApropCred"),
                Map.entry("211120", "detEventoUsoConsumo"),
                Map.entry("210240", "detEventoUsoConsumo"),
                Map.entry("211124", "detEventoPercPerdRouboAdquirente"),
                Map.entry("211128", "detEventoAceiteDebito"),
                Map.entry("211130", "detEventoImobilizacaoItem"),
                Map.entry("211140", "detEventoSolicApropCredComb"),
                Map.entry("211150", "detEventoSolicApropCredBensServDepAtivAdq"),
                Map.entry("212110", "detEventoManifestacaoPedTransfCredIBS"),
                Map.entry("212120", "detEventoManifestacaoPedTransfCredCBS"),
                Map.entry("412120", "detEventoManifestacaoFiscoPedTransfCredIBS"),
                Map.entry("412130", "detEventoManifestacaoFiscoPedTransfCredCBS")
        );
    }

    boolean isManifestation(String tpEvento) {
        return NFEvent.OPERATION_CONFIRMATION.getCode().equals(tpEvento) || NFEvent.OPERATION_IGNORANCE.getCode().equals(tpEvento) || NFEvent.OPERATION_SCIENCE.getCode().equals(tpEvento) || NFEvent.OPERATION_NOT_PERFORMED.getCode().equals(tpEvento);
    }

    @Override
    public void valid(Validation<TEnvEvento> o) throws ValidationException {
        XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_Generico_PL_v1.01/envEvento_v1.00.xsd", o.xml()));
        final String tpEvento = isManifestation(o.value().getEvento().getFirst().getInfEvento().getTpEvento()) ? "210200" : o.value().getEvento().getFirst().getInfEvento().getTpEvento();
        String versao = o.value().getEvento().getFirst().getInfEvento().getVerEvento();
        String xmlPart = Optional
                .ofNullable(XMLUtils.extractNodeAsString(o.xml(), "/envEvento/evento/infEvento/detEvento"))
                .map(it -> {
                    String newTagName = eventsAndTagNames.get(tpEvento);
                    return it
                            .replace("detEvento", newTagName)
                            .replaceFirst(newTagName, newTagName + " xmlns=\"http://www.portalfiscal.inf.br/nfe\"");
                })
                .orElse(null);
        if (Objects.nonNull(xmlPart)) {
            XMLValidatorFactory.getInstance().validateXML(new XMLValidation("xsds/nfe/Evento_Generico_PL_v1.01/e" + tpEvento + "_v" + versao + ".xsd", xmlPart));
        }

    }
}
