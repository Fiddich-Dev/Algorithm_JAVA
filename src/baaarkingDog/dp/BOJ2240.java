package baaarkingDog.dp;

import java.util.*;

public class BOJ2240 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int w = sc.nextInt();
        int[] a = new int[t];
        for(int i = 0; i < t; i++) {
            a[i] = sc.nextInt() - 1;
        }

        int[][][] dp = new int[1004][34][2];
        for (int j = 0; j <= w; j++) {
            for (int k = 0; k < 2; k++) {
                if(j % 2 == 1 && k == 0) {
                    dp[0][j][k] = -987654321;
                }
                if(j % 2 == 0 && k == 1) {
                    dp[0][j][k] = -987654321;
                }
            }
        }

        dp[0][0][0] = 0;


        for(int i = 1; i <= t; i++) {
            for(int j = 0; j <= w; j++) {
                for(int k = 0; k < 2; k++) {
                    int temp = a[i-1] == k ? 1 : 0;

                    if(j-1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-1][k^1]) + temp;
                    }
                    else {
                        dp[i][j][k] = dp[i-1][j][k] + temp;
                    }
                }
            }
        }

        int ret = Integer.MIN_VALUE;
        for(int i = 0; i <= w; i++) {
            for(int j = 0; j < 2; j++) {
                ret = Math.max(ret, dp[t][i][j]);
            }
        }

        System.out.println(ret);

    }
}

// dp[n][m][pos] = n초에 m번 움직이고 pos에 있을떄 받을 수 있는 자두의 최대 개수
// dp[n][m][pos] = Math.max(dp[n-1][m][pos], dp[n-1][m-1][pos^1]) + if(a[n-1] == pos) + 1