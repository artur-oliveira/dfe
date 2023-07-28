package com.softart.dfe.interfaces.internal.nf;

/**
 * This code is defining a Java interface named `NfeURL` that extends two other interfaces: `NfCommonServiceURL` and
 * `NfAnServiceURL`. This means that `NfeURL` inherits all the methods declared in those two interfaces, in addition to any
 * methods declared directly in `NfeURL`. The interface also declares two methods: `queryRegisterHom()` and
 * `queryRegisterProd()`. Any class that implements `NfeURL` must provide an implementation for these two methods.
 */
public interface NfeURL extends NfCommonServiceURL, NfAnServiceURL {
    String queryRegisterHom();

    String queryRegisterProd();
}
