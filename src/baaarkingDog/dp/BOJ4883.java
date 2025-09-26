package baaarkingDog.dp;

import java.util.*;

public class BOJ4883 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        while(true) {
            cnt++;
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }

            int[][] a = new int[n][3];
            int[][] dp = new int[n][3];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 3; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = a[0][1];
            dp[0][0] = 987654321;
            dp[0][2] = a[0][1] + a[0][2];

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + a[i][0];
                dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), Math.min(dp[i-1][2], dp[i][0])) + a[i][1];
                dp[i][2] = Math.min(Math.min(dp[i-1][1], dp[i-1][2]), dp[i][1]) + a[i][2];
            }

            System.out.println(cnt + ". " + dp[n-1][1]);
        }

    }
}
