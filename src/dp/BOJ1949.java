package dp;

import java.util.*;

public class BOJ1949 {

    static int n;
    static int[] a = new int[10004];
    static List<Integer>[] adj = new ArrayList[10004];
    static int[] dp = new int[10004];

    public static void main(String[] args) {

        for(int i = 0; i < 10004; i++) {
            adj[i] = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            int q = sc.nextInt();
            int w = sc.nextInt();
            q--;
            w--;
            adj[q].add(w);
            adj[w].add(q);
        }
    }
}
// 테이블 : dp[
