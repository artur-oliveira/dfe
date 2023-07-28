package com.softart.dfe.models.cte4.query_situation;

import br.inf.portalfiscal.cte.send400.*;
import com.softart.dfe.components.internal.xml.unmarshaller.CteUnmarshallerFactory;
import com.softart.dfe.exceptions.xml.MarshallException;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import com.softart.dfe.interfaces.xml.generic.DFObject;
import com.softart.dfe.models.cte4.event.CteReturnEvent;
import jakarta.xml.bind.JAXBElement;
import lombok.*;

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
    public static class ProtCTe implements DFObject, XMLAdapter<ProtCTe, TRetConsSitCTe.ProtCTe> {
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
        public TRetConsSitCTe.ProtCTe toObject() {
            TRetConsSitCTe.ProtCTe protCTe = new TRetConsSitCTe.ProtCTe();
            protCTe.setVersao(getVersao());
            return protCTe;
        }

        @Override
        public ProtCTe fromObject(TRetConsSitCTe.ProtCTe o) {
            ProtCTe protCte = ProtCTe.builder().build();
            protCte.setVersao(o.getVersao());

            try {
                protCte.setInfProt(InfProtCte.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protCTe400(o.getAny()).getValue().getInfProt()));
            } catch (MarshallException e1) {
                try {
                    setInfProtOs(InfProtCteOs.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protCTeOS400(o.getAny()).getValue().getInfProt()));
                } catch (MarshallException e2) {
                    setInfProtGtve(InfProtGtve.builder().build().fromObject(CteUnmarshallerFactory.getInstance().protGTVe400(o.getAny()).getValue().getInfProt()));
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
    public static class ProcEventoCTe implements DFObject, XMLAdapter<ProcEventoCTe, br.inf.portalfiscal.cte.send400.TRetConsSitCTe.ProcEventoCTe> {

        protected CteReturnEvent retEvento;
        protected String versao;

        @Override
        public ProcEventoCTe fromObject(br.inf.portalfiscal.cte.send400.TRetConsSitCTe.ProcEventoCTe o) {
            ProcEventoCTe proc = XMLAdapter.super.fromObject(o);

            if (o.getAny() instanceof JAXBElement) {
                proc.setRetEvento(CteReturnEvent.builder().build().fromObject((TRetEvento) (((JAXBElement<?>) o.getAny())).getValue()));
            }

            return proc;
        }
    }
}
