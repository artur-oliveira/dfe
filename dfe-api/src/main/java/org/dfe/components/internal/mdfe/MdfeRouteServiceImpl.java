package org.dfe.components.internal.mdfe;

import org.dfe.enums.internal.UF;
import org.dfe.models.internal.mdfe.RouteLocator;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.*;

/**
 * The MdfeRouteServiceImpl class extends the MdfeRouteFactory class in Java.
 */
@Getter(AccessLevel.PRIVATE)
final class MdfeRouteServiceImpl extends MdfeRouteFactory {

    private final Map<UF, List<UF>> frontiers = UF.getUfGraph();

    @Override
    public List<UF> getRoute(RouteLocator locator) {
        List<UF> route = new ArrayList<>();
        Queue<UF> queue = new LinkedList<>();
        Map<UF, UF> previousStates = new HashMap<>();

        queue.offer(locator.start());
        previousStates.put(locator.start(), null);

        while (!queue.isEmpty()) {
            UF estadoAtual = queue.poll();

            if (estadoAtual.equals(locator.end())) {
                break;
            }

            for (UF neighbor : getFrontiers().get(estadoAtual)) {
                if (!previousStates.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    previousStates.put(neighbor, estadoAtual);
                }
            }
        }

        UF state = locator.end();
        while (Objects.nonNull(state)) {
            route.add(state);
            state = previousStates.get(state);
        }

        Collections.reverse(route);
        if (!locator.includeStartEnd()) {
            route.removeIf(it -> Arrays.asList(locator.start(), locator.end()).contains(it));
        }
        return route;
    }

}
