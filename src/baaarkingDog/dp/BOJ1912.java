package baaarkingDog.dp;

import java.util.*;

public class BOJ1912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] dp = new int[n+1];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            dp[i+1] = a[i];
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);
        }

        int ret = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);

    }
}

// dp[n] = max(a[n], dp[n-1] + a[n])
