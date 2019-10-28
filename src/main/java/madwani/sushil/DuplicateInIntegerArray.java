package madwani.sushil;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateInIntegerArray {

    public static void main(String[] args) {
        Integer[] nums = {1,5,7,5,4,3,2,9};
        Stream.of(nums).collect(Collectors.toMap(Function.identity(), e->1,(x,y)->x+y));
    }
}
