package baaarkingDog.dp;

import java.util.*;

public class BOJ11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k] % 10007;
                }
            }
        }

        int ret = 0;
        for(int i = 0; i < 10; i++) {
            ret += dp[n][i] % 10007;
        }
        System.out.println(ret % 10007);


    }
}


// dp[n][num] = num으로 시작하는 길이가 n인 오름막 수의 개수
// dp[n][num] = sum(dp[n-1][num] ~ dp[n-1][9])
