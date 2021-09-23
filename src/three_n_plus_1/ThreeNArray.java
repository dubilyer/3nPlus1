package three_n_plus_1;

import java.util.LinkedList;
import java.util.List;

final class ThreeNArray implements ThreeN {
    public static final int MEMORY_SIZE = 10000000;
    private final long[] cache = new long[MEMORY_SIZE];

    @Override
    public synchronized List<Long> calculate(long input) {
        final LinkedList<Long> list = new LinkedList<>();
        list.add(input);
        while (input > 1) {
            long tmp;
            tmp = readIgnoringPeaks((int) input);
            if (tmp == 0) {
                tmp = OPERATE.applyAsLong(input);
                writeIgnoringPeaks((int) input, tmp);
            }
            input = tmp;
            list.add(input);
        }
        return list;
    }

    private void writeIgnoringPeaks(final long index, final long tmp) {
        try {
            cache[(int)index] = tmp;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            // Ignoring peak value
        }
    }

    private long readIgnoringPeaks(final long index) {
        long tmp;
        try {
            tmp = cache[(int)index];
        } catch (ArrayIndexOutOfBoundsException e) {
            tmp = 0;
        }
        return tmp;
    }


}
