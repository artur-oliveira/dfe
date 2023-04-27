package com.softart.dfe.interfaces.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.internal.mdfe.RouteLocator;

import java.util.List;

public interface MdfeRouteService {

    List<UF> getRoute(RouteLocator routeLocator);

    default List<UF> getRoute(UF start, UF end) {
        return getRoute(RouteLocator.builder().start(start).end(end).build());
    }
}
