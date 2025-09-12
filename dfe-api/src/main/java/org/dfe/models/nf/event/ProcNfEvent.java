package org.dfe.models.nf.event;


import br.inf.portalfiscal.nfe.event_generic.TProcEvento;
import lombok.*;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProcNfEvent implements DFObject, XMLAdapter<ProcNfEvent, TProcEvento> {
    protected NfEvent evento;
    protected ReturnNfEvent.TRetEvento retEvento;
    protected String versao;
}
