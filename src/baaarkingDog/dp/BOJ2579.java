package baaarkingDog.dp;

import java.util.*;

public class BOJ2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[][] dp = new int[n+1][4];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        dp[0][0] = 0;
        dp[0][1] = -987654321;
        dp[0][2] = -987654321;
        dp[1][0] = 0;
        dp[1][1] = a[0];
        dp[1][2] = -987654321;

        for(int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-2][1]), dp[i-2][2]) + a[i-1];
            dp[i][2] = dp[i-1][1] + a[i-1];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
// dp[n][m] = n번쨰 칸에서 m개를 연속으로 밟았을때 최댓값
// dp[n][0] = dp[n-1][1], dp[n-1][2]
// dp[n][1] = dp[n-1][0], dp[n-2][1], dp[n-2][2]

