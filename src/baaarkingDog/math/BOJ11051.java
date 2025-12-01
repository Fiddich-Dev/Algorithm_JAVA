package baaarkingDog.math;

import java.util.*;

public class BOJ11051 {

//    static int[][] dp = new int[1004][1004];

    // dp[n][k] = nCk
    // dp[n][k] = dp[n-1][k-1] + dp[n-1][k]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[1004][1004];

        for(int i = 0; i <= 1000; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int i = 1; i <= 1000; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = ((dp[i-1][j-1] % 10007) + (dp[i-1][j] % 10007)) % 10007;
            }
        }

        System.out.println(dp[n][k]);

    }
}
