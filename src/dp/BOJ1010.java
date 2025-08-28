package dp;

import java.util.*;
import java.io.*;

public class BOJ1010 {

    static int[][] dp = new int[34][34];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();



        for(int i = 0; i <= 30; i++) {
            for(int j = 0; j <= 30; j++) {
                dp[i][j] = -1;
            }
        }

        for(int q = 0; q < t; q++) {
            int n = sc.nextInt();
            int m = sc.nextInt();


            System.out.println(go(m, n));




        }
    }
    // 초, 기, 메, 로
    static int go(int a, int b) {

        if(b == 0 || a == b) {
            return 1;
        }

        if (a < 0 || b < 0) {
            return 0;
        }


        if(dp[a][b] != -1) {
            return dp[a][b];
        }

        return dp[a][b] = go(a-1, b-1) + go(a-1, b);

    }
}

// n C r
// n! / r! * (n-r)!

// 테이블 dp[n][m] = n개 중에 m개를 고르는 경우의 수
// 점화식 dp[n][m] = dp[n-1][m-1] + dp[n-1][m]
// 초기화 dp[n][n] = 1, dp[n][0] = 1
