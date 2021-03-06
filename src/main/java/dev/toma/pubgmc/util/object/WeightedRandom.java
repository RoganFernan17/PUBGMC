package dev.toma.pubgmc.util.object;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class WeightedRandom<T> implements Supplier<T> {

    protected static Random random = new Random();
    protected final T[] entries;
    protected final Function<T, Integer> toIntFunction;
    protected final LazyLoader<Integer> totalValue;
    protected final T fallBack;

    public WeightedRandom(Function<T, Integer> toIntFunction, T[] entries) {
        this(toIntFunction, entries, null);
    }

    public WeightedRandom(Function<T, Integer> toIntFunction, T[] entries, T fallBack) {
        this.entries = entries;
        this.toIntFunction = toIntFunction;
        this.totalValue = new LazyLoader<>(this::gatherAll);
        this.fallBack = fallBack;
    }

    public T[] getEntries() {
        return entries;
    }

    @Override
    public T get() {
        int total = totalValue.get();
        if(total <= 0) {
            return fallBack;
        }
        int weight = random.nextInt(total);
        for (int idx = entries.length - 1; idx >= 0; idx--) {
            T t = entries[idx];
            weight -= toIntFunction.apply(t);
            if(weight < 0) {
                return t;
            }
        }
        return entries[0];
    }

    private int gatherAll() {
        int i = 0;
        for(T t : entries) {
            i += toIntFunction.apply(t);
        }
        return i;
    }
}
