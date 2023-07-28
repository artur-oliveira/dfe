package com.softart.dfe.components.internal;

import com.softart.dfe.interfaces.internal.Pair;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
