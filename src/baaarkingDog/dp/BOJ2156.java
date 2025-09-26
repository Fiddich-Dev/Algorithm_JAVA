package baaarkingDog.dp;

import java.util.*;

public class BOJ2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        if(n == 1) {
            System.out.println(a[1]);
            return;
        }

        dp[0] = 0;
        dp[1] = a[1];
        dp[2] = a[1] + a[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3] + a[i-1] + a[i], dp[i-2] + a[i]), dp[i-1]);
        }

        System.out.println(dp[n]);
    }
}

// dp[n] = n번쨰 잔까지 고려했을 떄 최댓값
// dp[i] = max(dp[i-1], dp[i-2] + a[i], dp[i-3]
// ...xoo  dp[i-3] + a[i-1] + a[i]
// ...?xo  dp[i-2] + a[i]
// ...??x  dp[i-1]
