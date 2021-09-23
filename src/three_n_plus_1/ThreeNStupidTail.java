package three_n_plus_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class ThreeNStupidTail implements ThreeN{
    private final Map<Long, List<Long>> cache = new ConcurrentHashMap<>((int)LIMIT, 1f);

    @Override
    public List<Long> calculate(long size) {
        if (cache.containsKey(size)) return cache.get(size);
        final long key = size;
        final List<Long> list = new LinkedList<>();
        while (size>1){
            if (cache.containsKey(size)) {
                list.addAll(cache.get(size));
                break;
            }
            size = OPERATE.applyAsLong(size);
            list.add(size);
        }
        cache.put(key, list);
        return list;
    }
}
