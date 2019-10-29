package madwani.sushil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    public static String loadFile(String filepath) throws IOException {

        Path file= Paths.get(ClassLoader.getSystemResource(filepath).getPath());
        return Files.lines(file).collect(Collectors.joining(" "));
    }

    public static int[][] create2dArray(String line, String dimensions) {
        List<Integer> dims = Stream.of(dimensions.split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int[][] array = new int[dims.get(0)][dims.get(1)];
        List<Integer> nums = Stream.of(line.split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int k = 0;
        for(int i =0 ; i < dims.get(0); i++) {
            for (int j = 0; j < dims.get(1); j++) {
                array[i][j] = nums.get(k);
                k++;
            }
        }
        return array;
    }

    public static void print2dArray(int[][] array){
        for(int i =0 ; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
