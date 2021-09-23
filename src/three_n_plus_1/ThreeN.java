package three_n_plus_1;

import java.util.List;
import java.util.function.LongUnaryOperator;

import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.range;

public interface ThreeN {
    long LIMIT = 1000000L;
    LongUnaryOperator OPERATE = i -> i%2==0?i>>1:i*3+1;


    /**
     * One row calculation
     * @param input - an input number
     * @return a row compiled to List.
     */
    List<Long> calculate(long input);

    /**
     * Calculates raws for all numbers from 1 to {@link #LIMIT}.
     * If you want to log results just add a <code>.peek(System.out::println)</code> between map and collect
     * For multithreading - switch stream to parallel <code>...boxed().parallel().map...</code>
     * @return returns an 3N+1 row
     */
    @SuppressWarnings({"UnusedReturnValue", "will be used in a future dev"})
    default List<List<Long>> calculateRange(){
        return range(1L, LIMIT).boxed().parallel().map(this::calculate).collect(toList());
    }
}
