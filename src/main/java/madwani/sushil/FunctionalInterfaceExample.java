package madwani.sushil;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        Predicate isNull = (value) -> value!=null;

        System.out.println(isNull.test("hello"));

        Supplier<Double> randomGenerator = () -> Math.random();

        System.out.println(randomGenerator.get());

        Function<String, Integer> integerConv = Integer::parseInt;

        System.out.println(integerConv.apply("2"));

        Consumer<Integer> exitCode = (num) -> System.exit(num);

        exitCode.accept(20);
    }
}
