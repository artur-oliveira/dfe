package org.dfe.interfaces.internal.mdfe;

import org.dfe.enums.internal.UF;
import org.dfe.models.internal.mdfe.RouteLocator;

import java.util.List;

/**
 * The code is defining a Java interface named `MdfeRouteService`. This interface declares two methods:
 * `getRoute(RouteLocator routeLocator)` and `getRoute(UF start, UF end)`. The first method takes a `RouteLocator` object
 * as a parameter and returns a list of `UF` objects based on the specified `RouteLocator`. The second method takes two
 * `UF` objects representing the start and end points of a route and returns a list of `UF` objects representing the route
 * between those locations. The interface is intended to be implemented by a class that provides the functionality for
 * calculating routes between locations.
 */
public interface MdfeRouteService {

    /**
     * The function returns a list of UF objects based on a given RouteLocator.
     *
     * @param routeLocator RouteLocator is an interface in Spring Cloud Gateway that is used to locate a route based on the
     *                     incoming request. It provides methods to retrieve a list of routes that match the request's URI, headers, and other
     *                     attributes. The getRoute() method takes a RouteLocator object as a parameter and returns a
     * @return A list of objects of type `UF` is being returned. The method `getRoute` takes a parameter of type
     * `RouteLocator` and returns a list of `UF` objects based on the specified `RouteLocator`.
     */
    List<UF> getRoute(RouteLocator routeLocator);

    /**
     * This function returns a list of UF objects representing a route between a start and end point.
     *
     * @param start The starting point of the route. In this case, it is an object of type UF.
     * @param end   The "end" parameter is an object of type "UF" which represents the destination or endpoint of the route.
     * @return A `List` of `UF` objects representing the route between the `start` and `end` locations. The `getRoute`
     * method is called with a `RouteLocator` object that specifies the start and end locations, and it returns a list of
     * `UF` objects representing the route between those locations. The `getRoute` method is likely part of a larger class
     * or system that calculates
     */
    default List<UF> getRoute(UF start, UF end) {
        return getRoute(RouteLocator.builder().start(start).end(end).build());
    }
}
