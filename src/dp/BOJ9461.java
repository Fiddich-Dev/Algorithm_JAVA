package dp;

import java.util.*;

public class BOJ9461 {

    static long[] dp = new long[104];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;

        for(int i = 9; i <= 100; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }



        while(t-- != 0) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }

    }
}

// 1 1 1 2 2 3 4 5 7 9

// 1 1 1