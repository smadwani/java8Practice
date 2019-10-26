package madwani.sushil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NthMostOccurringWordInAFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int nthFrequentNumber = sc.nextInt();
        String [] words = Util.loadFile("sample.txt").split(" ");
        Map<String, Integer> map = Stream.of(words).collect(Collectors.toMap(Function.identity(), e -> e.split(" ").length , (x, y)-> x+y));
        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
        System.out.println(sortedMap.keySet().toArray()[nthFrequentNumber-1]);

    }
}
