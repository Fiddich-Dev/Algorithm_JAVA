package dp;

import java.util.*;

public class BOJ1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[1004][3];

        int[][] dp = new int[1004][3];

        for(int i = 1; i <= n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        dp[1][0] = a[1][0];
        dp[1][1] = a[1][1];
        dp[1][2] = a[1][2];

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]) + a[i][j];
            }
        }

        int ret = Integer.MAX_VALUE;

        ret = Math.min(ret, dp[n][0]);
        ret = Math.min(ret, dp[n][1]);
        ret = Math.min(ret, dp[n][2]);

        System.out.println(ret);
    }
}
// 테이블 : dp[n][m] = n번째 집까지 m의 색으로 칠했을떄 최소가격
// 점화식 : dp[n][m] = min(dp[n-1][(m+1) % 3], dp[n-1][(m+2) % 3]) + a[n][m]