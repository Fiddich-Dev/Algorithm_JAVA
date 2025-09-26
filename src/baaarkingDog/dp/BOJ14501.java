package baaarkingDog.dp;

import java.util.*;

public class BOJ14501 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        for(int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n+4];
        int ret = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int next = i + t[i];

            dp[i+1] = Math.max(dp[i+1], dp[i]);
            ret = Math.max(ret, dp[i+1]);

            if(next <= n) {
                dp[next] = Math.max(dp[next], dp[i] + p[i]);
                ret = Math.max(ret, dp[next]);
            }
        }

//        for(int i = 0; i <= n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();

        System.out.println(dp[n]);


    }
}
