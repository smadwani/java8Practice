package madwani.sushil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDimScreenPixelColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dimensions = sc.nextLine();
        String data = sc.nextLine();
        String inputLine = sc.nextLine();
        int[][] _2dMatrix = Util.create2dArray(data, dimensions);
        System.out.println("input array \n");
        Util.print2dArray(_2dMatrix);
        //generateNewMatrix(inputLine, _2dMatrix);
        updateMatrix(inputLine, _2dMatrix);
    }

    public static int[][] fill(int[][] arr, int x, int y, int c, int k , int m ,int n) {
        if(x < 0 || x >= m || y < 0 || y >= n){
            return arr;
        }
        if(arr[x][y] !=c) {
            return arr;
        }
        arr[x][y] = k;
        fill(arr, x-1, y, c, k, m ,n);
        fill(arr, x, y-1, c, k, m ,n);
        fill(arr, x+1, y, c, k, m ,n);
        fill(arr, x, y+1, c, k, m ,n);
        return arr;

    }

    private static void generateNewMatrix(String inputLine, int[][] matrix) {
        List<Integer> inputs = Stream.of(inputLine.split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int x = inputs.get(0);
        int y = inputs.get(1);
        int color = inputs.get(2);
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i =0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j];
                if((i==x && j ==y ) || (i == x && Math.abs(j - y) == 1) || ( j==y && Math.abs(i-x)==1)) {
                    newMatrix[i][j] = color;
                }
                if(i!=0 && matrix[i-1][j] == matrix[i][j]){
                    newMatrix[i-1][j] = color;
                }
                if(i!=matrix.length-1 && matrix[i+1][j] == matrix[i][j]){
                    newMatrix[i+1][j] = color;
                }
                if(j!=0 && matrix[i][j-1] == matrix[i][j]){
                    newMatrix[i][j-1] = color;
                }
                if(j!=matrix[i].length-1 && matrix[i][j+1] == matrix[i][j]){
                    newMatrix[i][j+1] = color;
                }
            }
        }
        System.out.println("outPut array \n");
        Util.print2dArray(newMatrix);
    }

    private static void updateMatrix(String inputLine, int[][] matrix) {
        List<Integer> inputs = Stream.of(inputLine.split(" "))
                .map(Integer::valueOf).collect(Collectors.toList());
        int x = inputs.get(0);
        int y = inputs.get(1);
        int color = inputs.get(2);
        Util.print2dArray(fill(matrix,x,y,matrix[x][y],color,matrix.length, matrix[0].length));
    }
}

// 0 1 1 0 0 5 5 0
// 1 1 1 1 5 5 5 5
// 0 1 2 3 0 5 2 3

