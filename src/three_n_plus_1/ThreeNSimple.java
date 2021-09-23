package three_n_plus_1;

import java.util.LinkedList;
import java.util.List;

final class ThreeNSimple implements ThreeN {

    @Override
    public synchronized List<Long> calculate(long input) {
        final LinkedList<Long> list = new LinkedList<>();
        list.add(input);
        while (input > 1) {
            input = OPERATE.applyAsLong(input);
            list.add(input);
        }
        return list;
    }
}