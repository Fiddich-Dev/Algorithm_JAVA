package baaarkingDog.dp;

import java.util.*;

public class BOJ2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[104][10004];



        for(int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= k; j++) {
                dp[i][j] += dp[i-1][j]; // + dp[i][j-a[i]];
                if(j - a[i] >= 0) {
                    dp[i][j] += dp[i][j-a[i]];
                }
            }
        }

//        for(int i = 1; i <= n; i++) {
//            for(int j = 1; j <= k; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][k]);



    }
}

// dp[i][n] = i번째 동전까지 써서 n원을 만들수 있는 경우의 수
// dp[i][n] = dp[i-1][n] + dp[i][n-a[i]]
