package madwani.sushil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoOfPossiblePathsInMatrix {
    public static void main(String[] args) {
        List<Integer> dims = Stream.of(Util.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(countPath(0,0,dims.get(0), dims.get(1)));

    }

    public static int countPath(int x, int y, int m, int n){
        if(x == m-1  || y == n-1 ) {
            return 1;
        }
        return countPath(x+1, y, m ,n) + countPath(x, y+1, m ,n);
    }
}
