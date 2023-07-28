package com.softart.dfe.models.mdfe.query_situation;

import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.components.internal.xml.unmarshaller.MdfeUnmarshallerFactory;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.mdfe.event.MdfeReturnEvent;
import com.softart.dfe.models.mdfe.reception_sync.MdfeProtocol;
import com.softart.dfe.util.RequireUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class MdfeReturnQuerySituation implements DFObject, XMLAdapter<MdfeReturnQuerySituation, TRetConsSitMDFe> {
    private String tpAmb;
    private String verAplic;
    private String cStat;
    private String xMotivo;
    private String cuf;
    private ProtMDFe protMDFe;
    private List<MdfeProcEvent> procEventoMDFe;
    private String versao;

    public Long getLastSequenceNumber(String eventType) {
        return RequireUtils.nonNull(getProcEventoMDFe(), "getProcEventoMDFe() must be not null in order to call getLastSequenceNumber")
                .stream()
                .filter(it -> Objects.equals(eventType, it.getRetEvento().getInfEvento().getTpEvento()))
                .map(it -> Long.valueOf(it.getRetEvento().getInfEvento().getNSeqEvento()))
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1L;
    }

    public String getLastSequenceNumberAsString(String eventType) {
        return String.valueOf(getLastSequenceNumber(eventType));
    }

    public String protocol() {
        return RequireUtils.nonNull(getProtMDFe(), "Mdfe must have a protocol").getProt().getInfProt().getNProt();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public final static class ProtMDFe implements DFObject, XMLAdapter<ProtMDFe, TRetConsSitMDFe.ProtMDFe> {
        private MdfeProtocol prot;
        private String versao;

        @Override
        public ProtMDFe fromObject(TRetConsSitMDFe.ProtMDFe o) {
            this.setVersao(o.getVersao());
            this.setProt(MdfeProtocol.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().protMdfe(o.getAny()).getValue()));
            return this;
        }

        @Override
        public TRetConsSitMDFe.ProtMDFe toObject() {
            TRetConsSitMDFe.ProtMDFe prot = new TRetConsSitMDFe.ProtMDFe();
            prot.setVersao(getVersao());
            return prot;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public final static class MdfeProcEvent implements DFObject, XMLAdapter<MdfeProcEvent, TRetConsSitMDFe.ProcEventoMDFe> {
        private String versao;
        private MdfeReturnEvent retEvento;

        @Override
        public MdfeProcEvent fromObject(TRetConsSitMDFe.ProcEventoMDFe o) {
            setVersao(o.getVersao());
            setRetEvento(MdfeReturnEvent.builder().build().fromObject(MdfeUnmarshallerFactory.getInstance().returnEvent(o.getAny()).getValue()));
            return this;
        }

    }
}
