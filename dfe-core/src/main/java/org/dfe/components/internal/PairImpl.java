package org.dfe.components.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.dfe.interfaces.internal.Pair;

@RequiredArgsConstructor
@Getter
@Setter
public final class PairImpl<T, I> implements Pair<T, I> {

    private final T first;
    private final I second;

    @Override
    public T first() {
        return getFirst();
    }

    @Override
    public I second() {
        return getSecond();
    }
}
