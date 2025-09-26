package baaarkingDog.dp;

import java.util.*;

public class BOJ1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Color[] a = new Color[n+1];

        for(int i = 1; i <= n; i++) {
            a[i] = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int[][] dp = new int[n+1][3];

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + a[i].r;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + a[i].g;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i].b;
        }

        int ret = Integer.MAX_VALUE;
        ret = Math.min(ret, dp[n][0]);
        ret = Math.min(ret, dp[n][1]);
        ret = Math.min(ret, dp[n][2]);
        System.out.println(ret);
    }

    static class Color {
        int r;
        int g;
        int b;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}

// dp[idx][color] = dp[idx-1][(color+1) % 3] + a[idx][color], dp[idx-1][(color+2) % 3] + a[idx][color]
