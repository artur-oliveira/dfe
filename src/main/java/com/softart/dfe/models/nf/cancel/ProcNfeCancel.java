package com.softart.dfe.models.nf.cancel;


import br.inf.portalfiscal.nfe.event_cancel.TProcEvento;
import com.softart.dfe.interfaces.xml.DFObject;
import com.softart.dfe.interfaces.xml.XMLAdapter;
import lombok.*;


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
