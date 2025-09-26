package baaarkingDog.dp;

import java.util.*;

public class BOJ15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];

        for(int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        for(int i = 0; i < n; i++) {
            // 상담 안할때
            dp[i+1] = Math.max(dp[i+1], dp[i]);

            // 상담 할때
            int next = i + t[i];
            if(next <= n) {
                dp[next] = Math.max(dp[next], dp[i]+p[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
