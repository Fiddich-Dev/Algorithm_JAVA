package dp;

import java.util.*;

public class BOJ2293 {

    static int n, k;
    static int[] c = new int[104];
    static int[] dp = new int[10004];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = c[i]; j <= k; j++) {
                dp[j] += dp[j - c[i]];
            }
        }

        System.out.println(dp[k]);
    }
}

// 테이블 : dp[가치] = 경우의수
// 점화식 : dp[a] =

