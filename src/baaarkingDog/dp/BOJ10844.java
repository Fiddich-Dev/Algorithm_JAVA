package baaarkingDog.dp;

import java.util.*;

public class BOJ10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[104][10];

        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= 100; i++) {
            for(int j = 0; j < 10; j++) {
                int temp1 = 0;
                int temp2 = 0;
                if(j-1 >= 0) {
                    temp1 = dp[i-1][j-1] % 1000000000;
                }
                if(j+1 <= 9) {
                    temp2 = dp[i-1][j+1] % 1000000000;
                }
                dp[i][j] = (temp1 + temp2) % 1000000000;
            }
        }
        int ret = 0;
        for(int i = 0; i < 10; i++) {
            ret = ((ret % 1000000000) + (dp[n][i] % 1000000000)) % 1000000000;
        }

        System.out.println(ret);
    }
}

// dp[n][m] = 1의 자리수가 m인 n자리 수인 계단수의 개수
// dp[n][1] = dp[n-1][0] + dp[n-1][2]
// dp[1] = 9
