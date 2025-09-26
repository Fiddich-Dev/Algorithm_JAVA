package baaarkingDog.dp;

import java.util.*;

public class BOJ11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            dp[i] = sc.nextInt();
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);


    }
}

// dp[n] = n개의 카드를 찾기 위한 최대값
// dp[n] = dp[m] + dp[n-m] m: 1 ~ n