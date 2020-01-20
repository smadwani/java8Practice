package madwani.sushil.array;

import madwani.sushil.Util;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateRemovalWithoutLibraryFromArray {
    public static void main(String[] args) {
        Integer[] input = Util.getSample1DArray();
        System.out.println(Stream.of(input)
                .collect(
                Collectors.groupingBy(Function.identity(),Collectors.summingInt(e->1))).keySet());
    }
}

