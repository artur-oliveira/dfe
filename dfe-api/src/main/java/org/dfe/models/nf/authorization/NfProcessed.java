package org.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TNfeProc;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.generic.DFObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NfProcessed implements DFObject, XMLAdapter<NfProcessed, TNfeProc> {
    protected Nf nFe;
    protected NfProtocol protNFe;
    protected String versao;
}
