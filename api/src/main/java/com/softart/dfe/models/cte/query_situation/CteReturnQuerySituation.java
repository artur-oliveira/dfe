package com.softart.dfe.models.cte.query_situation;

import br.inf.portalfiscal.cte.send.*;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.cte.event.CteReturnEvent;
import lombok.*;

import javax.xml.bind.JAXBElement;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CteReturnQuerySituation implements DFObject, XMLAdapter<CteReturnQuerySituation, TRetConsSitCTe> {
    protected String tpAmb;
    protected String verAplic;
    protected String cStat;
    protected String xMotivo;
    protected String cuf;
    protected ProtCTe protCTe;
    protected List<ProcEventoCTe> procEventoCTe;
    protected String versao;

    public Long getLastSequenceNumber(String eventType) {
        return getProcEventoCTe()
                .stream()
                .filter(it -> Objects.equals(eventType, it.getRetEvento().getInfEvento().getTpEvento()))
                .map(it -> Long.valueOf(it.getRetEvento().getInfEvento().getNSeqEvento()))
                .max(Comparator.naturalOrder())
                .orElse(0L) + 1L;
    }

    public String getLastSequenceNumberAsString(String eventType) {
        return String.valueOf(getLastSequenceNumber(eventType));
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProtCTe implements DFObject, XMLAdapter<ProtCTe, ProtCTeAny> {
        protected InfProtCte infProt;
        protected InfProtCteOs infProtOs;
        protected InfProtGtve infProtGtve;
        protected String versao;

        public String protocol() {
            if (Objects.nonNull(getInfProt())) return getInfProt().getNProt();
            if (Objects.nonNull(getInfProtOs())) return getInfProtOs().getNProt();
            if (Objects.nonNull(getInfProtGtve())) return getInfProtGtve().getNProt();
            throw new IllegalArgumentException("Não há protocolo no objeto " + this);
        }

        @Override
        public ProtCTeAny toObject() {
            ProtCTeAny protCTe = new ProtCTeAny();
            protCTe.setVersao(getVersao());
            return protCTe;
        }

        @Override
        public ProtCTe fromObject(ProtCTeAny o) {
            ProtCTe protCte = ProtCTe.builder().build();
            protCte.setVersao(o.getVersao());

            try {
                protCte.setInfProt(InfProtCte.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protCTe(o.getAny()).getValue().getInfProt()));
            } catch (MarshallException e1) {
                try {
                    setInfProtOs(InfProtCteOs.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protCTeOS(o.getAny()).getValue().getInfProt()));
                } catch (MarshallException e2) {
                    setInfProtGtve(InfProtGtve.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protGTVe(o.getAny()).getValue().getInfProt()));
                }
            }

            return protCte;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfProtCte implements DFObject, XMLAdapter<InfProtCte, TProtCTe.InfProt> {
            protected String tpAmb;
            protected String verAplic;
            protected String chCTe;
            protected String dhRecbto;
            protected String nProt;
            protected byte[] digVal;
            protected String cStat;
            protected String xMotivo;
            protected String id;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfProtCteOs implements DFObject, XMLAdapter<InfProtCteOs, TProtCTeOS.InfProt> {
            protected String tpAmb;
            protected String verAplic;
            protected String chCTe;
            protected String dhRecbto;
            protected String nProt;
            protected byte[] digVal;
            protected String cStat;
            protected String xMotivo;
            protected String id;
        }

        @Getter
        @Setter
        @Builder
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        public static class InfProtGtve implements DFObject, XMLAdapter<InfProtGtve, TProtGTVe.InfProt> {
            protected String tpAmb;
            protected String verAplic;
            protected String chCTe;
            protected String dhRecbto;
            protected String nProt;
            protected byte[] digVal;
            protected String cStat;
            protected String xMotivo;
            protected String id;
        }
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProcEventoCTe implements DFObject, XMLAdapter<ProcEventoCTe, br.inf.portalfiscal.cte.send.ProcEventoCTe> {

        protected CteReturnEvent retEvento;
        protected String versao;

        @Override
        public ProcEventoCTe fromObject(br.inf.portalfiscal.cte.send.ProcEventoCTe o) {
            ProcEventoCTe proc = XMLAdapter.super.fromObject(o);

            if (o.getAny() instanceof JAXBElement) {
                proc.setRetEvento(CteReturnEvent.builder().build().fromObject((TRetEvento) (((JAXBElement<?>) o.getAny())).getValue()));
            }

            return proc;
        }
    }
}
