package madwani.sushil.leetcode.Jan1_7_2021;

public class BeautifulArrangement {
    static int count = 0;
    public static void main(String[] args) {
        countArrangement(3);
        System.out.println(count);
    }

    public static int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        count(n, 1, visited);
        return count;
    }

    public static void count(int n, int pos, boolean[] visited) {
        if (pos > n) count ++;
        for (int i =1 ; i<=n ; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
