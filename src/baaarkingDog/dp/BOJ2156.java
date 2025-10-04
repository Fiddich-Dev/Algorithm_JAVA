package baaarkingDog.dp;

import java.util.*;

public class BOJ2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] dp = new int[10004];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        if(n == 1) {
            System.out.println(a[1]);
            return;
        }

        dp[1] = a[1];
        dp[2] = a[1] + a[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3] + a[i-1] + a[i], dp[i-2] + a[i]), dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}

// dp[n] = n번째를 마셨을떄 최댓값
// dp[n] = dp[n-3] + a[n-1] + a[n], dp[n-2] + a[n], dp[n-1]
// xoo
// xo
// x