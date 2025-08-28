package dp;

import java.util.*;
import java.io.*;

public class BOJ12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[104][100004];

        Pair[] a = new Pair[n];

        int[] ws = new int[104];
        int[] vs = new int[104];

        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            a[i] = new Pair(w, v);
            ws[i+1] = w;
            vs[i+1] = v;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - ws[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-ws[i]] + vs[i]);
                }
            }
        }

        System.out.println(dp[n][k]);

    }

    static class Pair {
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
// 테이블 : dp[n][m] = n까지 확인했을때 m의 무게일때의 최대 가치
// 점화식 : dp[n][m] = 가방에 더 넣을수 있을 경우 dp[n-1][m - a[n]] + a[n], 넣을수 없는 경우 dp[n-1][m]


// 테이블 : dp[m] = m의 무게일때의 최대 가치
// 점화식 : dp[m] =