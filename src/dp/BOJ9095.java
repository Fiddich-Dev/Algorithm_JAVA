package dp;

import java.util.*;

public class BOJ9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
