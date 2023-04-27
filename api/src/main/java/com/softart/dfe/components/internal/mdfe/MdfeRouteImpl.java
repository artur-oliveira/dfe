package com.softart.dfe.components.internal.mdfe;

import com.softart.dfe.enums.internal.UF;
import com.softart.dfe.models.internal.mdfe.RouteLocator;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.*;

@Getter(AccessLevel.PRIVATE)
final class MdfeRouteImpl extends MdfeRouteFactory {

    private final Map<UF, List<UF>> frontiers = UF.getUfGraph();

    @Override
    public List<UF> getRoute(RouteLocator locator) {
        List<UF> route = new ArrayList<>();
        Queue<UF> queue = new LinkedList<>();
        Map<UF, UF> previousStates = new HashMap<>();

        queue.offer(locator.getStart());
        previousStates.put(locator.getStart(), null);

        while (!queue.isEmpty()) {
            UF estadoAtual = queue.poll();

            if (estadoAtual.equals(locator.getEnd())) {
                break;
            }

            for (UF neighbor : getFrontiers().get(estadoAtual)) {
                if (!previousStates.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    previousStates.put(neighbor, estadoAtual);
                }
            }
        }

        UF state = locator.getEnd();
        while (Objects.nonNull(state)) {
            route.add(state);
            state = previousStates.get(state);
        }

        Collections.reverse(route);
        if (!locator.isIncludeStartEnd()) {
            route.removeIf(it -> Arrays.asList(locator.getStart(), locator.getEnd()).contains(it));
        }
        return route;
    }

}
