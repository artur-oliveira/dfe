package com.softart.dfe.interfaces.internal;

import com.softart.dfe.components.internal.DFEnum;

import java.util.Collection;

/**
 * Interface that simulates the Sefaz Response Status
 */
public interface ReturnCode extends DFEnum.Codeable {

    /**
     * Get all denied return code that Sefaz returns
     *
     * @return collection of denied return codes
     */
    Collection<? extends ReturnCode> getDenied();

    /**
     * Get all denied authorized code that Sefaz returns
     *
     * @return collection of authorized return codes
     */
    Collection<? extends ReturnCode> getAuthorized();

    /**
     * Get all denied general code that Sefaz returns
     *
     * @return collection of general return codes
     */
    Collection<? extends ReturnCode> getGeneral();

    /**
     * If sefaz response includes one of denied, authorized or general codes. Must be generated a processed XML
     * that corresponds the event that was sended
     *
     * @return true if the current status must generate a processed XML, false otherwise
     */
    default boolean generateProc() {
        return getDenied().contains(this) || getAuthorized().contains(this) || getGeneral().contains(this);
    }
}
