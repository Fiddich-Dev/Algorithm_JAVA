package baaarkingDog.dp;

import java.util.*;

public class BOJ2302 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[44];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < 44; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int ret = 1;
        int prev = 0;
        for(int i = 0; i < m; i++) {
            int temp = sc.nextInt();
            ret *= dp[temp - 1 - prev];
            prev = temp;
        }
        ret *= dp[n - prev];

        System.out.println(ret);
    }
}

// dp[n][m] = n번째 자리까지 고려했을떄 n번째 자리를 바꾼지 안바꾼지
//