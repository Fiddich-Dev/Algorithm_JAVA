package baaarkingDog.dp;

import java.util.*;

public class BOJ9465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0) {
            int n = sc.nextInt();
            int[][] a = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for(int i = 0; i < 2; i++) {
                for(int j = 1; j <= n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = a[0][1];
            dp[1][1] = a[1][1];

            for(int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + a[0][i];
                dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + a[1][i];
            }

//            System.out.println();
//            for(int i = 0; i < 2; i++) {
//                for(int j = 1; j <= n; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }
    }
}

// dp[n][m] = n, m의 스티커를 땔때 쌓인 최대 점수
// dp[n][0] = dp[n-1][1] + a[n][0]
// dp[n][1] = dp[n-1][0] + a[n][1]
