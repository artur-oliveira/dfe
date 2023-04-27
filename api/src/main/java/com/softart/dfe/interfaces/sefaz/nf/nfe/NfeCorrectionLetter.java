package com.softart.dfe.interfaces.sefaz.nf.nfe;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.exceptions.ValidationException;
import com.softart.dfe.exceptions.security.SecurityException;
import com.softart.dfe.interfaces.internal.Pair;
import com.softart.dfe.interfaces.sefaz.SefazRequest;

interface NfeCorrectionLetter {

    /**
     * It takes a SefazRequest object as a parameter, and returns a Pair of TEnvEvento and TRetEnvEvento objects
     *
     * @param data The object that contains the data to be sent to the Sefaz.
     * @return Pair<TEnvEvento, TRetEnvEvento>
     */
    <T extends SefazRequest<TEnvEvento, TRetEnvEvento>> Pair<TEnvEvento, TRetEnvEvento> correctionLetter(T data) throws SecurityException, ValidationException, ProcessException;

}
