package org.dfe.models.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import org.dfe.enums.internal.Environment;
import org.dfe.enums.internal.UF;
import org.dfe.enums.internal.nf.QrCodeNfceURL;
import org.dfe.enums.internal.nf.QueryNfceURL;
import org.dfe.enums.nf.version.NFVersion;
import org.dfe.exceptions.security.XMLSignException;
import org.dfe.exceptions.services.NoProviderFound;
import org.dfe.interfaces.internal.config.NfConfig;
import org.dfe.interfaces.internal.config.NfceConfig;
import org.dfe.interfaces.xml.XMLAdapter;
import org.dfe.interfaces.xml.XMLSignerService;
import org.dfe.interfaces.xml.generic.DFObject;
import org.dfe.util.StringUtils;
import lombok.*;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SendNf implements DFObject, XMLAdapter<SendNf, TEnviNFe> {

    @Builder.Default
    protected String idLote = StringUtils.random();
    protected String indSinc;
    protected List<Nf> nFe;
    @Builder.Default
    protected String versao = NFVersion.getDefault().getVersion();

    public static SendNf build(Collection<Nf> nfs, NfConfig config, XMLSignerService xmlSigner) {
        nfs.stream().filter(Nf::isNfce).forEach(it -> {
            try {
                it.setInfNFeSupl(Nf.InfNFeSupl
                        .builder()
                        .urlChave(QueryNfceURL.get(UF.valueOfNf(it), Environment.valueOfNf(it)))
                        .qrCode(QrCodeNfceURL.generate(it, (NfceConfig) config, xmlSigner))
                        .build());
            } catch (NoProviderFound | GeneralSecurityException | XMLSignException e) {
                throw new RuntimeException(e);
            }
        });

        return SendNf
                .builder()
                .nFe(new ArrayList<>(nfs))
//                .indSinc(((nfs.stream().anyMatch(Nf::isNfe) && (config.uf().equals(UF.SP) || config.uf().equals(UF.BA))) || nfs.size() > 1 || config.send().equals(NFSend.ASYNC)) ? NFSend.ASYNC.getCode() : NFSend.SYNC.getCode())
                .indSinc(config.send().getCode())
                .build();
    }
}
