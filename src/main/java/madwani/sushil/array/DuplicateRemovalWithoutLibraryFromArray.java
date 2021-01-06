package madwani.sushil.array;

import madwani.sushil.Util;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateRemovalWithoutLibraryFromArray {
    public static void main(String[] args) {
        ArrayList<String > a = new ArrayList<>();
        System.out.println(a.size());
        a.add("a");
        a.add("b");
        a.add("c");
        a.add(1,"d");
        System.out.println(a.size());
        a.remove("a");
        a.remove(2);

        System.out.println(a.size());
        Integer[] input = Util.getSample1DArray();
        System.out.println(Stream.of(input)
                .collect(
                Collectors.groupingBy(Function.identity(),Collectors.summingInt(e->1))).keySet());
    }
}

