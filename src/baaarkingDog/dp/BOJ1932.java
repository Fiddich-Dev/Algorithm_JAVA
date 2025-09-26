package baaarkingDog.dp;

import java.util.*;

public class BOJ1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = a[0][0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                if(j-1 < 0) {
                    dp[i][j] = dp[i-1][j] + a[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + a[i][j];
                }
            }
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[n-1][i]);
        }
        System.out.println(ret);
    }
}
