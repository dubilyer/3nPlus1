package three_n_plus_1;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

final class ThreeNController {

    public static void main(String[] args) {
//        run(new ThreeNSimple());
//        System.gc();
//        run(new ThreeNArray());
//        System.gc();
        run(new ThreeNStupidTail());
    }

    private static void run(final ThreeN threeN) {
        final long startTime = currentTimeMillis();
        threeN.calculateRange();
        out.println("calculation time is " + (currentTimeMillis() - startTime));
    }
}
