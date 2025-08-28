package dp;

import java.util.*;

public class BOJ9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[104];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 6; i < 104; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for(int q = 0; q < t; q++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}

// dp[n] = dp[n-1] + dp[n-5]