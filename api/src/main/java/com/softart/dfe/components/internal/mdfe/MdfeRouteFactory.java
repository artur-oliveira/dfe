package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.interfaces.internal.mdfe.MdfeRouteService;

public abstract class MdfeRouteFactory implements MdfeRouteService {

    public static MdfeRouteService getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static MdfeRouteService INSTANCE = new MdfeRouteImpl();
    }

}
