package dp;

import java.util.*;

public class BOJ9084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int q = 0; q < t; q++) {
            int n = sc.nextInt();
            int[] a = new int[n];

            int[][] dp = new int[24][100004];

            for(int i = 0; i < 24; i++) {
                dp[i][0] = 1;
            }

            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int v = sc.nextInt();

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= v; j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j - a[i-1] >= 0) {
                        dp[i][j] = dp[i-1][j] + dp[i][j-a[i-1]];
                    }
                }

            }

            System.out.println(dp[n][v]);
        }
    }
}

// 테이블 : dp[n][m] = n번째 동전까지 사용했을때 m원을 만들수있는 경우의 수
// 점화식 : dp[n][m] =

// n번째 동전을 0개 썼을 경우 = dp[n-1][m]
// n번째 동전을 1개 썼을 경우 = dp[n-1][m-a[n]]