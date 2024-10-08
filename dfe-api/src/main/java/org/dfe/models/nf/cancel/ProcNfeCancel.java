package org.dfe.models.nf.cancel;


import br.inf.portalfiscal.nfe.event_cancel.TProcEvento;
import lombok.*;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProcNfeCancel implements DFObject, XMLAdapter<ProcNfeCancel, TProcEvento> {
    protected NfeCancel evento;
    protected ReturnNfeCancel.TRetEvento retEvento;
    protected String versao;
}
